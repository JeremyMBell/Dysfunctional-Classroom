package Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Server {
    private ServerSocket server;
    private Socket socket;
    private int port;
    public Server(int port) throws IOException {
        server = new ServerSocket(port);
        this.port = port;
    }
    public String getIP() throws UnknownHostException {return Inet4Address.getLocalHost().getHostAddress();}
    public int getPort(){return port;}
    public void startServer() {
        final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);
        Thread serverThread = new Thread(new ServerWait());
        serverThread.start();
    }
    public class ServerWait implements Runnable {
        @Override
        public void run() {
            try {
                socket = server.accept();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String inputLine, outputLine;
                while ((inputLine = in.readLine()) != null) {
                    outputLine = inputLine;
                    out.println(outputLine);
                    if (outputLine.equals("Bye."))
                        break;
                }
            } catch (IOException ex) {
                System.out.println("Thread failed.");
            }
        }
    }
    public class ServerPlayCards implements Runnable {
        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    public class ServerSelectWinner implements Runnable {
        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    public class ServerChatMessage implements Runnable {
        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
