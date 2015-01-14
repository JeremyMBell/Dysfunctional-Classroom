package Server;

import frame.Player;
import io.SlickInteractivePanel;
import java.io.IOException;
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
    private SlickInteractivePanel publicPanel;
    /**
     * Information that only this person can see.
     */
    private SlickInteractivePanel privatePanel;
    public SlickClient(Player player) {
        super("Dysfunctional Classroom");
        this.player = player;
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        publicPanel = new SlickInteractivePanel(gc, 0, 0, 1, .5f);
        privatePanel = new SlickInteractivePanel(gc, 0, .5f, 1, .5f);
        
        publicPanel.setBackgroundColor(Color.yellow);
        privatePanel.setBackgroundColor(Color.red);
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {}

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        publicPanel.render(gc, g);
        privatePanel.render(gc, g);
    }
    public void connect(String ip, int port) {
        try (Socket socket = new Socket(ip, port);){
            while(true) {
                privatePanel.getInput();
                SlickServer.runInput(publicPanel);
            }
            
        } catch (IOException ex) {
            System.out.println("Connection failed.");
        }
        
        
    }
    
}
