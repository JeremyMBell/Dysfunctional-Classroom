package io;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import frame.Classroom;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
public class Output extends BasicGame
{
    private Classroom room;
    private final Image BACKGROUND = toImage("src/images/background.png");
        
    public Output(String gamename)
    {
            super(gamename);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {}

    @Override
    public void update(GameContainer gc, int i) throws SlickException {}

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
            BACKGROUND.draw(0, 0);
    }
    public void setClassroom(Classroom clsrm) {room = clsrm;}
    /**
     * Converts File to BufferedImage class.
     */
    public static Image toImage(String file) {
        System.out.println(new File(file).getAbsolutePath());
        try{return new Image(file);}
        catch(Exception e){
            System.out.println("Caught");
            return null;}
    }
    public enum RoomObj {
        desk("images/desk.png", 0, 0),
        boy("images/male.png", 0, 0),
        girl ("images/female.png", 0, 0);
        Image image;
        int x, y;
        RoomObj(String a, int b, int c) {
            image = toImage(a);
            x = b;
            y = c;
        }
        public void setX(int newX){x = newX;}
        public void setY(int newY) {y = newY;}
    }
}
