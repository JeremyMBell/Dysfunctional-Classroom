package io;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import frame.Lobby;
import java.io.InputStream;
import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import java.awt.Font;
public class Output extends BasicGame
{
    private Lobby room;
    public static final MutableFont deflt = new MutableFont(new Font("Cambria", Font.PLAIN, 20), true);
    private SlickInteractivePanel publicViewing, privateViewing;
        
    public Output(String gamename)
    {
            super(gamename);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        gc.setTargetFrameRate(30);
        publicViewing = new SlickInteractivePanel(gc,);
        
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        g.setFont(deflt);//Cambria size 12
        userPanel.render(gc, g);
        
    }
    public void setClassroom(Lobby clsrm) {room = clsrm;}
    /**
     * Converts GIF image location to Image class.
     */
    public static Image toImage(String file) {
        try {
            //Make a texture using the string and return an image based off
            //the texture
            InputStream fileInput = ResourceLoader.getResourceAsStream(file);
            Texture texture = TextureLoader.getTexture("GIF", fileInput);
            return toImage(texture);
        }
        catch(Exception e){//Tell us where it went wrong!
            System.out.println("Caught toImage(String)");
            e.printStackTrace();
            return null;
        }
    }
    public static Image toImage(Texture image) {
        try{return new Image(image);}//Image() has an initializer for texture.
        catch(Exception e){//Tell us where it went wrong!
            System.out.println("Caught toImage(Texture)");
            e.printStackTrace();
            return null;
        }
       
    }
}
