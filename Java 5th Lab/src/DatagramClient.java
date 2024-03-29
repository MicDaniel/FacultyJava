import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramClient {
    
    //Globals
    private static int PORT = 8200;

    public static JButton B_CONNECT = new JButton("CONNECT");
    public static JFrame MainWindow = new JFrame("Datagram Client");
    public static JScrollPane SP_OUTPUT = new JScrollPane();
    public  static JTextArea TA_OUTPUT = new JTextArea();

    public static void main(String[] args){
        BuildGui();
    }

    private static void BuildGui() {
        MainWindow.setSize(500, 250);
        MainWindow.setLocation(50,50);
        MainWindow.setResizable(false);
        MainWindow.setBackground(new java.awt.Color(255,255,255));
        MainWindow.getContentPane().setLayout(null);
        
        B_CONNECT.setBackground(new java.awt.Color(0, 0,255));
        B_CONNECT.setForeground(Color.white);
        MainWindow.getContentPane().add(B_CONNECT);
        B_CONNECT.setBounds(150,15,110,25);
        
        TA_OUTPUT.setLineWrap(true);
        SP_OUTPUT.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        SP_OUTPUT.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        SP_OUTPUT.setViewportView(TA_OUTPUT);
        MainWindow.getContentPane().add(SP_OUTPUT);
        SP_OUTPUT.setBounds(10,45,380,180);
        
        MainWindow_Action();

        MainWindow.setVisible(true);
        
    }

    private static void MainWindow_Action() {
        B_CONNECT.addActionListener(
                event -> CONNECT()
        );
    }

    private static void CONNECT() {
        try {
            //Create a datagram socket
            DatagramSocket SOCK = new DatagramSocket();

            //Connect to the SERVER
            byte[] BUFFER = new byte[256];
            String msg = "Craiova";
            BUFFER = msg.getBytes();

            InetAddress IP_ADDRESS = InetAddress.getByName("127.0.0.1");
            DatagramPacket PACKET = new DatagramPacket(BUFFER, BUFFER.length, IP_ADDRESS, PORT);

            SOCK.send(PACKET);

            //Rebuild new PACKET and request from SERVER
            BUFFER = new byte[256];
            PACKET = new DatagramPacket(BUFFER, BUFFER.length);
            SOCK.receive(PACKET);

            //Extract data from stream, convert it to stream and display it
            String message = new String(PACKET.getData(), 0, PACKET.getLength());

            TA_OUTPUT.append("\nToday's QUOTE: " + message);

            SOCK.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}
