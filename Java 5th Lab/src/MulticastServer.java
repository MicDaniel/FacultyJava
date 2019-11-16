import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

public class MulticastServer extends Thread {

    public static final int PORT = 8200;
    private DatagramSocket SOCK = null;
    public int time = 3000;

    public MulticastServer() throws IOException {
        SOCK = new DatagramSocket(PORT);
        System.out.println("Launched MulticastS server Thread!");
        System.out.println("Waiting for the client to connect...");
    }

    public void run() {
        while (true) {
            try {
                byte[] BUFFER = new byte[256];

                Date Time = new Date();
                String message = Time.toString();
                BUFFER = message.getBytes();
                System.out.println("Serving the date every 3 seconds:");

                //Address must be multicast to a group. (classful IP addressing)
                InetAddress IP_ADRSS_GROUP = InetAddress.getByName("224.0.0.1");
                DatagramPacket PACKET = new DatagramPacket(BUFFER, BUFFER.length, IP_ADRSS_GROUP, PORT);

                //Sending the packet with the response to the client
                SOCK.send(PACKET);

                try{
                    sleep(time);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        MulticastServer SERVER = new MulticastServer();
        SERVER.start();
    }

}