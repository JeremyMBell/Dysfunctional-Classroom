package io;

import java.awt.Dimension;
import java.awt.Point;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;

public interface Drawable {
    
    /**
     * Sets the SpriteSheet based on the SpriteSheets location.
     * @param location The location of the SpriteSheet image
     * @param blockWidth How wide each block of the SpriteSheet is.
     * @param blockHeight How tall each block of the SpriteSheet is.
     */
    public void setSpriteSheet(String location, int blockWidth, int blockHeight);
    /**
     * Replaces the current SpriteSheet with a new one.
     * @param sheet The new SpriteSheet
     */
    public void setSpriteSheet(SpriteSheet sheet);
    
    /**
     * Returns sprites used for this drawable.
     * @return Sprites used for this drawable.
     */
    public SpriteSheet getSpriteSheet();
    
    /**
     * Draws to the (x,y) coordinate.
     * @param g Graphics object to draw on.
     * @param x X Coordinate to draw to.
     * @param y Y Coordinate to draw to.
     */
    public void draw(Graphics g, int x, int y);
    
    /**
     * Draws to the (x,y) coordinate with width and height in mind.
     * @param g Graphics object to draw on.
     * @param x X Coordinate to draw to.
     * @param y Y Coordinate to draw to.
     * @param width Width of image to be drawn.
     * @param height Height of image to be drawn.
     */
    public void draw(Graphics g, int x, int y, int width, int height);
    
    /**
     * Draws to the point given.
     * @param g Graphics object to draw on.
     * @param point (x,y) Coordinate to draw to.
     */
    public void draw(Graphics g, Point point);
    
    /**
     * Draws to the point given with dimensions in mind.
     * @param g Graphics object to draw on.
     * @param point (x,y) Coordinate to draw to.
     * @param dimensions Dimensions of the image.
     */
    public void draw (Graphics g, Point point, Dimension dimensions);
    @Override
    public String toString();
}
