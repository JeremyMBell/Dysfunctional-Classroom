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
import org.newdawn.slick.gui.TextField;
public class Output extends BasicGame
{
    private Classroom room;
    private Image BACKGROUND;
    private OPerson[] people;
    private TrueTypeFont deflt;
    private final int BLOCK_SIZE = 150;
    private Input chatTarget;
        
    public Output(String gamename)
    {
            super(gamename);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        BACKGROUND = toImage("src/images/background.gif");
        chatTarget = new Input(gc);
        chatTarget.setHeight(600);
        chatTarget.setWidth(500);
        chatTarget.setLocation(900, 0);
        Character[] classmates = room.classmates();
        people = new OPerson[classmates.length];
        //3 rows of students - 5 columns of students - 15 max students
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 5 && i * 5 + i2 < classmates.length; i2++) {
                Point curr;
                
                //The index in the array will be a combination of both indices
                int i3 = i * 5 + i2;
                
                //If the classmate isn't a teacher - place them in normal seating
                if (classmates[i3].getRole() != Character.Role.teacher)
                    curr = new Point(i2 * (BLOCK_SIZE + 30), i * (BLOCK_SIZE));
                
                //Otherwise, the teacher gets a front desk
                else
                    curr = new Point (BLOCK_SIZE, gc.getHeight() - BLOCK_SIZE * 2 / 3);
                
                people[i3] = new OPerson(classmates[i3], curr, BLOCK_SIZE);
                
            }
            
        }
        //gc.setShowFPS(false);
        deflt = new TrueTypeFont(new Font("Cambria", Font.PLAIN, 12), true);
        chatTarget.init(gc);
        chatTarget.setWidth(gc.getWidth() - BACKGROUND.getWidth());
        chatTarget.setLocation(BACKGROUND.getWidth(), BACKGROUND.getHeight() - 40);
        
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {}

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        BACKGROUND.draw(0, 0);
        g.setFont(deflt);//Cambria size 12
        for(OPerson person:people)
            person.draw(g);
        chatTarget.render(gc, g);
        
    }
    public void setClassroom(Classroom clsrm) {room = clsrm;}
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
