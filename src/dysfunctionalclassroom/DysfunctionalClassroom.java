package dysfunctionalclassroom;
import Server.SlickClient;
import Server.SlickServer;
import frame.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import org.newdawn.slick.AppGameContainer;
import org.lwjgl.*;
public class DysfunctionalClassroom {
    public static void main(String[] args) {
        SlickServer myServer;
        SlickClient myClient;
        Player me = new Player("Jeremy");
        try {
            myServer = new SlickServer(9797);
            myClient = new SlickClient(me);
            AppGameContainer appgc = new AppGameContainer(myClient);
            appgc.setDisplayMode(1000, 600, false);
            appgc.start();
            myClient.connect(myServer.getIP(), myServer.getPort());
            System.out.println("Good1");
        }
        catch(Exception e) {
            return;
        }
        
        
        
        
        
        /*
        try(
            //System.out.println("Good2");
            Socket kkSocket = new Socket(myServer.getIP(),myServer.getPort());
            //System.out.println("Good3");
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
            //System.out.println("Good4");
            BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
            //System.out.println("Good5");
            ){
            
            myServer.startServer();
            System.out.println("Start try.");
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;
            System.out.println("At line.");
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;
                 
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host IP");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to the IP");
            System.exit(1);
        }*/
    }
    
}
