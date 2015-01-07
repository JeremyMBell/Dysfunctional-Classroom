package io;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import frame.Lobby;
import frame.Player;
import java.io.InputStream;
import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.TrueTypeFont;
import java.awt.Font;
import java.awt.Point;
import org.newdawn.slick.gui.TextField;
public class Output extends BasicGame
{
    private Lobby room;
    private Image BACKGROUND;
    private OPerson[] people;
    private TrueTypeFont deflt;
    private final int BLOCK_SIZE = 150;
    private Input userPanel;
        
    public Output(String gamename)
    {
            super(gamename);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        gc.setTargetFrameRate(30);
        userPanel = new Input(gc);
        userPanel.setHeight(gc.getHeight());
        userPanel.setWidth(gc.getWidth() / 3);
        userPanel.setLocation(gc.getWidth() - gc.getWidth() / 3, 0);
        deflt = new TrueTypeFont(new Font("Cambria", Font.PLAIN, 12), true);
        userPanel.init(gc, room);
        userPanel.setWidth(gc.getWidth() - BACKGROUND.getWidth());
        userPanel.setLocation(BACKGROUND.getWidth(), BACKGROUND.getHeight() - 40);
        
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        userPanel.update(gc, i);
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        BACKGROUND.draw(0, 0);
        g.setFont(deflt);//Cambria size 12
        for(OPerson person:people)
            person.draw(g);
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
    /**
     * RoomObj
     * Gives images to use in the classroom that represent objects.
     */
    public enum RoomObj {
        desk("images/desk.gif"),
        teacherDesk("images/teacher_desk.gif"),
        boy("images/male.gif"),
        girl ("images/female.gif");
        Image image;
        RoomObj(String a) {
            image = toImage(a);
        }
        /**
         * draw (int x, int y)
         * x - x-coordinate to draw to
         * y - y-cordinate to draw to
         * 
         * Draws the RoomObj image to the desired location.
        */
        public void draw(int x, int y){image.draw(x, y);}
    }
}
