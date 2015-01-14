package io;

import java.util.List;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

public interface SlickPanel {
    /**
     * Initializes the panel.
     * @param gc The game container for the game.
     * @param g The graphics to draw to.
     */
    public void init(GUIContext gc, Graphics g);
    /**
     * Renders the panel.
     * @param gc The game container for the game.
     * @param g The graphics to draw to.
     * @throws org.newdawn.slick.SlickException
     */
    public void render(GUIContext gc, Graphics g) throws SlickException;
    /**
     * Gives the width of the panel in percentage.
     * @return The Panel Width
     */
    public float getPercentageWidth();
    /**
     * Gives the height of the panel in percentage.
     * @return The Panel Height.
     */
    public float getPercentageHeight();
    
    /**
     * Gives the rendering width.
     * @return The width it will be rendered at.
     */
    public int getWidth();
    /**
     * Gives the rendering height.
     * @return The height it will be rendered at.
     */
    public int getHeight();
    /**
     * Gets the percentage where this item is placed on the x-coordinate in its parent.
     * @return The percentage where this item is place in its parent x-coordinate.
     */
    public float getPercentageX();
    /**
     * Gets the percentage where this item is placed on the y-coordinate in its parent.
     * @return The percentage where this item is place in its parent y-coordinate.
     */
    public float getPercentageY();
    /**
     * Gets the physical placement where x is in the coordinate plane.
     * @return The exact x-coordinate in the coordinate plane.
     */
    public int getX();
    /**
     * Gets the physical placement where y is in the coordinate plane.
     * @return The exact y-coordinate in the coordinate plane.
     */
    public int getY();
    /**
     * Gives the component at the selected index.
     * @param i The index to look for a component.
     * @return The component located at the index given.
     */
    public SlickPanel getPanel(int i);
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
     * @return List of components that the panel is responsible for.
     */
    public List<SlickPanel> getPanels();
    /**
     * Gives the panel containing this panel.
     * @return The panel containing this panel. Null if it is the top panel.
     */
    public SlickPanel getParent();
    /**
     * Sets the width of the panel in percentage.
     * @param width The new width in percentage.
     */
    public void setWidth(float width);
    /**
     * Sets the height of the panel in percentage of the parent.
     * @param height The new height in percentage.
     */
    public void setHeight(float height);
    /**
     * Sets the x-coordinate of the panel.
     * @param x The new x-coordinate in percentage.
     */
    public void setX(float x);
    /**
     * Sets the y-coordinate of the panel in percentage.
     * @param y The new y-coordinate in percentage.
     */
    public void setY(float y);
    /**
     * Sets the x and y coordinates of the panel in percentage.
     * @param x The new x-coordinate in percentage
     * @param y The new y-coordinate in percentage
     */
    public void setLocation(float x, float y);
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
     * Sets a new parent for this panel and removes it from a previous one.
     * @param parent The new parent.
     */
    public void setParent(SlickPanel parent);
    /**
     * Adds a component to the panel.
     * @param comp The new component.
     */
    public void addPanel(SlickPanel comp);
    
    /**
     * Removes the component at the index.
     * @param i The index to remove the component from.
     */
    public void removePanel(int i);
    /**
     * Removes the first instance of this component.
     * @param comp The component to remove.
     * @return True if it found one to remove. False if nothing was removed.
     */
    public boolean removePanel(SlickPanel comp);
    /**
     * Sets the parent to be nothing.
     */
    public void removeParent();
}
