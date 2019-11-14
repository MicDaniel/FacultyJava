import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramServer {
    public static final int PORT = 8200;
    private DatagramSocket socket = null;
    DatagramPacket request, response = null;

    public DatagramServer() throws IOException {
        socket = new DatagramSocket(PORT);
        System.out.println("Launched DatagramS server Thread!");
        System.out.println("Waiting for the client to connect...");
    }

    public void start() throws IOException {
        try {
            while(true) {
                //Declaring the packet where we will receive the request
                byte[] BUFFER = new byte[256];
                request =  new DatagramPacket(BUFFER, BUFFER.length);
                System.out.println("Waiting for a packet...");
                socket.receive(request);

                //Getting the address and the port from which the request is coming
                InetAddress address = request.getAddress();
                int port = request.getPort();

                //Building the response
                String message = "GO " + new String(request.getData());
                BUFFER = message.getBytes();

                //Sending the packet with the response to the client
                response = new DatagramPacket(BUFFER, BUFFER.length, address, port);
                socket.send(response);
            }
        }
        finally {
            if(socket != null) {
                socket.close();
            }
        }
    }

    public static void main (String[] args) throws IOException {
        DatagramServer SERVER = new DatagramServer();
        SERVER.start();
    }
}

