package io;

import java.awt.Point;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Graphics;
import frame.Character;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class OPerson {
    private final Point coordinates;
    private final Character person;
    private final int blockSize;
    private Image[] sprite;
    public OPerson(Character rep, Point location, int size) {
        coordinates = location;
        person = rep;
        blockSize = size;
        try {
            SpriteSheet studentDesk = new SpriteSheet("src/images/desksheet.png", size, size);
            if (rep.getRole() == Character.Role.teacher) {//Adding the teacher's desk
                sprite = new Image[3];
                sprite[0] = studentDesk.getSprite(2, 0);
                sprite[1] = studentDesk.getSprite(3, 0);
            }
            else sprite = new Image[1];//Otherwise, a student

            if (sprite.length == 3 && rep.isMale()) //Male teacher gets male sprite
                sprite[2] = studentDesk.getSprite(5, 0);
            else if (sprite.length == 3)//Female teacher gets female sprite
                sprite[2] = studentDesk.getSprite(4, 0);
            else if (rep.isMale())//Male student gets male student & desk sprite
                sprite[0] = studentDesk.getSprite(1, 0);
            else//Female student gets female student & desk sprite
                sprite[0] = studentDesk.getSprite(0, 0);
        }
        catch(Exception e){
            //Catch: load the images individual == slower approach
            System.out.println("Caught OPerson constructor.");
            e.printStackTrace();//Tell me what's wrong!
            
            //If statements point to the same as above.
            if (rep.getRole() == Character.Role.teacher) {
                sprite = new Image[3];
                sprite[0] = Output.toImage("src/images/teacher_desk_left.gif");
                sprite[1] = Output.toImage("src/images/teacher_desk_right.gif");
            }
            else sprite = new Image[0];
            if (sprite.length == 3 && rep.isMale())
                sprite[2] = Output.toImage("src/images/teacher_boy.gif");
            else if (sprite.length == 3)
                sprite[2] = Output.toImage("src/images/teacher_girl.gif");
            else if (rep.isMale())
                sprite[0] = Output.toImage("src/images/boy_desk.gif");
            else
                sprite[0] = Output.toImage("src/images/girl_desk.gif");
        }
    }
    
    public void draw(Graphics g) {
        
        //Drawing sprites block by block
        for (int i = 0; i < sprite.length; i++)
            g.drawImage(sprite[i], coordinates.x + i * blockSize, coordinates.y);
        
        //Setting the color - if person transferred - red, otherwise, black
        if (person.hasFailed()) g.setColor(Color.red);
        else g.setColor(Color.black);
        
        //Adding the name and role if it failed (other than teacher)
        if (person.getRole() == Character.Role.teacher)//Teacher has different positioning for drawing names
            g.drawString(person.toString(), coordinates.x + 5 * blockSize / 32, coordinates.y + blockSize / 8);
        else if (person.hasFailed())//Adding role if a nonteacher transferred
            g.drawString(person.getRole().toString(), coordinates.x + 5 * blockSize / 32, coordinates.y + 3 * blockSize / 4);
        if (person.getRole() != Character.Role.teacher)
            g.drawString(person.toString(), coordinates.x + 5 * blockSize / 32, coordinates.y + 5 * blockSize / 8);
        
    }
    
}
