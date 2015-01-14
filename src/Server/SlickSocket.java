package Server;

import dysfunctionalclassroom.DysfunctionalClassroom;
import io.SlickInputPanel;
import io.SlickOutputPanel;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
public class SlickSocket extends Socket {
    private static HashMap<String, SlickOutputPanel> outputs = new HashMap<>();
    public SlickSocket(String ip, int port) throws UnknownHostException, IOException {
        super(ip, port);
    }
    public SlickSocket(Socket socket) throws UnknownHostException, IOException {
        super(socket.getInetAddress(), socket.getPort());
    }
    public static SlickOutputPanel getOutputPanel(Socket socket) {
        if (!outputs.containsKey(socket.getInetAddress().toString() + ":" + socket.getPort())) outputs.put(socket.getInetAddress().toString() + socket.getPort(), new SlickOutputPanel(0,0,1,.3f));
        return outputs.get((socket.getInetAddress().toString() + socket.getPort()));
    }
    
    
}
