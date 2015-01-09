package io;

import org.newdawn.slick.Color;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.Font;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.ComponentListener;

public class SlickList extends AbstractComponent {
    private int height, width, x, y;
    private Font font;
    private String[] items;
    private Color background, text;
    private int selectedIndex = -1;
    public SlickList(GUIContext container, Font font, int x, int y, int width,
                    int height, String[] items) {
        super(container);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.font = font;
        this.items = items;
        background = Color.white;
        text = Color.black;
        
    }
    public SlickList(GUIContext container, Font font, int x, int y, int width,
                    int height) {
        this(container, font, x, y, width, height, new String[0]);
        
    }
    @Override
    public int getHeight(){return height;}
    @Override
    public int getWidth(){return width;}
    @Override
    public int getX(){return x;}
    @Override
    public int getY(){return y;}
    
    /** Returns the whole list of the combo box
     * @return  Returns all items in a array of strings.
     */
    public String[] getItems() {
        return items;
    }
    /**
     * Returns an item at the index.
     * @param i - an index to grab from.
     * @return Item at the index. May throw error if the grab wasn't accepted.
     */
    public String getItem(int i) {
        return items[i];
    }
    /**
     * Adds an item to the end of the array
     * @param item
     *          Item to be added.
     */
    public void addItem(String item) {
        String[] temp = items;
        items = new String[items.length + 1];
        for (int i = 0; i < temp.length; i++)
            items[i] = temp[i];
        items[items.length - 1] = item;
    }
    
    /**
     * Replaces current items with a new set of items.
     * @param items 
     *          Array that will replace the current items.
     */
    public void setItems(String[] items) {
        this.items = items;
    }
    /**
     * Sets the color for the text to display.
     * @param clr 
     *          Color the text should be.
     */
    public void setTextColor(Color clr) {
        text = clr;
    }
    /**
     * Sets the color for the background to display.
     * @param clr 
     *          Color the background should be.
     */
    public void setBackgroundColor(Color clr) {
        background = clr;
    }
    /**
     * Retrieves the item the combobox selected
     * @return The selected item in the SlickList. Returns null if nothing is selected.
     */
    public String getSelectedItem() {
        if (selectedIndex >= 0 &&  selectedIndex < items.length)
            return items[selectedIndex];
        return null;
    }
    /**
     * Sets the index of the item in the SlickList
     * @param i - the index to be selected.
     */
    public void setSelectedItem(int i) {
        selectedIndex = i;
    }
    
    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void render(GUIContext gui, Graphics g) {
        Color tempColor = g.getColor();
        g.setFont(font);
        g.setColor(background);
        g.fillRect(x, y, width, height);
        int lineHeight = font.getHeight("|");
        int selectedY = lineHeight * selectedIndex;
        g.setColor(text);
        if (selectedIndex < items.length && selectedIndex >= 0)
            g.fillRect(x, selectedY, width, lineHeight);
        for (int i = 0; i < items.length; i++)
            g.drawString(i + ".) " + items[i], x + width / 10, y + i * lineHeight);
        
        
        g.setColor(tempColor);
    }
    
}
