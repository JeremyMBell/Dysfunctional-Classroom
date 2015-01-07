package io;

import java.awt.Point;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Graphics;
import frame.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class OPerson {
    private final Point coordinates;
    private final Player person;
    private final int blockSize;
    private Image[] sprite;
    public OPerson(Player rep, Point location, int size) {
        coordinates = location;
        person = rep;
        blockSize = size;
    }
    
    public void draw(Graphics g) {
        
        //Drawing sprites block by block
        for (int i = 0; i < sprite.length; i++)
            g.drawImage(sprite[i], coordinates.x + i * blockSize, coordinates.y);
        
        
    }
    
}
