package io;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import frame.Classroom;
import frame.Character;
import java.io.InputStream;
import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.TrueTypeFont;
import java.awt.Font;
import java.awt.Point;
import org.newdawn.slick.Color;
public class Output extends BasicGame
{
    private Classroom room;
    private Image BACKGROUND;
    private Image[] pplSprite;
    private Point[] pplLocation;
    private TrueTypeFont deflt;
    private final int BLOCK_SIZE = 150;
        
    public Output(String gamename)
    {
            super(gamename);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        BACKGROUND = toImage("src/images/background.gif");
        Character[] classmates = room.classmates();
        pplSprite = new Image[classmates.length];
        pplLocation = new Point[classmates.length];
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 5; i2++) {
                int i3 = i * 5 + i2;
                if (i3 < classmates.length && classmates[i3].isMale())
                    pplSprite[i3] = RoomObj.boy.image;
                else if (i3 < classmates.length)
                    pplSprite[i3] = RoomObj.girl.image;
                if (i3 < classmates.length && classmates[i3].getRole() != Character.Role.teacher)
                    pplLocation[i3] = new Point(i2 * (BLOCK_SIZE + 30), i * (BLOCK_SIZE));
                else if (i3 < classmates.length)
                    pplLocation[i3] = new Point (BLOCK_SIZE, gc.getHeight() - BLOCK_SIZE * 2 / 3);
                
            }
            
        }
        //gc.setShowFPS(false);
        deflt = new TrueTypeFont(new Font("Cambria", Font.PLAIN, 12), true);
        
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {}

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        BACKGROUND.draw(0, 0);
        g.setFont(deflt);
        for (int i = 0; i < pplSprite.length; i++) {
            int rectX = pplLocation[i].x + BLOCK_SIZE / 6;
            int rectY = pplLocation[i].y + BLOCK_SIZE * 7 / 12;
            if (room.classmates()[i].getRole() != Character.Role.teacher) {
                RoomObj.desk.draw(pplLocation[i].x, pplLocation[i].y);
                pplSprite[i].draw(pplLocation[i].x + BLOCK_SIZE / 3, pplLocation[i].y);
            }
            else {
                RoomObj.teacherDesk.draw(pplLocation[i].x, pplLocation[i].y);
                pplSprite[i].draw(pplLocation[i].x + 3 * BLOCK_SIZE, pplLocation[i].y);
                rectY = pplLocation[i].y + BLOCK_SIZE / 6;
            }
            g.setColor(Color.white);
            g.fillRect(rectX, rectY, BLOCK_SIZE * 2 / 3, BLOCK_SIZE / 3);
            g.setColor(Color.black);
            if (room.classmates()[i].hasFailed()) {
                g.setColor(Color.red);
                g.drawString(room.classmates()[i].getRole().toString(), rectX, rectY + 20);
            }
            g.drawString(room.classmates()[i].toString(), rectX, rectY);
        }
            
        
    }
    public void setClassroom(Classroom clsrm) {room = clsrm;}
    /**
     * Converts file location to BufferedImage class.
     */
    public static Image toImage(String file) {
        try {
            InputStream fileInput = ResourceLoader.getResourceAsStream(file);
            System.out.println("Good input stream");
            Texture texture = TextureLoader.getTexture("GIF", fileInput);
            System.out.println("Good texture");
            return toImage(texture);
        }
        catch(Exception e){
            System.out.println("Caught toImage(String)");
            e.printStackTrace();
            return null;
        }
    }
    public static Image toImage(Texture image) {
        try{return new Image(image);}
        catch(Exception e){
            System.out.println("Caught toImage(Texture)");
            e.printStackTrace();
            return null;
        }
       
    }
    public enum RoomObj {
        desk("images/desk.gif"),
        teacherDesk("images/teacher_desk.gif"),
        boy("images/male.gif"),
        girl ("images/female.gif");
        Image image;
        RoomObj(String a) {
            image = toImage(a);
        }
        public void draw(int x, int y){image.draw(x, y);}
    }
}
