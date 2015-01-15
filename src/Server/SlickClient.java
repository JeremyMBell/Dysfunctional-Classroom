package Server;

import frame.Player;
import io.SlickInputPanel;
import io.SlickOutputPanel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class SlickClient extends BasicGame {
    private final Player player;
    /**
     * Information that will be displayed for all to see.
     */
    private SlickOutputPanel publicPanel;
    /**
     * Information that only this person can see.
     */
    private SlickInputPanel privatePanel;
    private Socket mySocket;
    public SlickClient(Player player, String ip, int port) {
        super("Dysfunctional Classroom");
        this.player = player;
        connect(ip, port);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        try {
        privatePanel = new SlickInputPanel(0, .3f, 1, .7f);
        }catch(IOException e){System.out.println("I failed.");}
        System.out.println("Initialized.");
        privatePanel.setBackgroundColor(Color.red);
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {}
        

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        if (publicPanel != null) publicPanel.render(gc, g);
        privatePanel.render(gc, g);
    }
    public void connect(String ip, int port) {
        try {
            mySocket = new Socket(ip, port);
            publicPanel = SlickSocket.getOutputPanel(mySocket);
            System.out.println("Good panel.");
            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        } catch (IOException ex) {
            System.out.println("Connection failed.");
        }
    }
    @Override
    public void mousePressed(int button, int x, int y){
        System.out.println("Clicky");
        if (button == 0 && x >= privatePanel.getX() && x <= privatePanel.getX() + privatePanel.getWidth()
            && y >= privatePanel.getY() && y <= privatePanel.getY() + privatePanel.getHeight()) {
            System.out.println("Click2");
            go();
        }
    }
    public void go() {
        SlickServer.runInput(publicPanel);
    }
    
}
