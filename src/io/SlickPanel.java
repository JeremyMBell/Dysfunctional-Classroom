package io;

import java.util.List;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

public interface SlickPanel {
    /**
     * Renders the panel.
     * @param gc The game container for the game.
     * @param g The graphics to draw to.
     * @throws org.newdawn.slick.SlickException
     */
    public void render(GUIContext gc, Graphics g) throws SlickException;
    /**
     * Gives the width of the panel.
     * @return The Panel Width
     */
    public int getWidth();
    /**
     * Gives the height of the panel.
     * @return The Panel Height.
     */
    public int getHeight();
    /**
     * Gives the component at the selected index.
     * @param i The index to look for a component.
     * @return The component located at the index given.
     */
    public AbstractComponent getComponent(int i);
    /**
     * Gives the color of the background.
     * @return The background color.
     */
    public Color getBackgroundColor();
    /**
     * Gives the color of the border.
     * @return The border color.
     */
    public Color getBorderColor();
    /**
     * Gives the width of the border.
     * @return The border width;
     */
    public int getBorderWidth();
    /**
     * Gives all the components in this panel.
     * @return List of AbstractComponents that the panel is responsible for.
     */
    public List<AbstractComponent> getComponents();
    /**
     * Sets the width of the panel.
     * @param width The new width.
     */
    public void setWidth(int width);
    /**
     * Sets the height of the panel.
     * @param height The new height.
     */
    public void setHeight(int height);
    /**
     * Sets the x-coordinate of the panel.
     * @param x The new x-coordinate.
     */
    public void setX(int x);
    /**
     * Sets the y-coordinate of the panel.
     * @param y The new y-coordinate.
     */
    public void setY(int y);
    /**
     * Sets the new location of the panel.
     * @param x The new x-coordinate of the panel.
     * @param y The new y-coordinate of the panel.
     */
    public void setLocation(int x, int y);
    /**
     * Changes the background color to a new one.
     * @param newColor The replacement color for the background.
     */
    public void setBackgroundColor(Color newColor);
    /**
     * Changes the border color to a new one.
     * @param newColor The replacement color for the border.
     */
    public void setBorderColor(Color newColor);
    /**
     * Changes the border's width to a new one.
     * @param newWidth The new width of the border.
     */
    public void setBorderWidth(int newWidth);
    
    /**
     * Adds a component to the panel.
     * @param comp The new component.
     */
    public void addComponent(AbstractComponent comp);
    
    /**
     * Removes the component at the index.
     * @param i The index to remove the component from.
     */
    public void removeComponent(int i);
    /**
     * Removes the first instance of this component.
     * @param comp The component to remove.
     * @return True if it found one to remove. False if nothing was removed.
     */
    public boolean removeComponent(AbstractComponent comp);
}
