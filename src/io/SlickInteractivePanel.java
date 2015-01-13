package io;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

public class SlickInteractivePanel extends AbstractComponent implements SlickPanel {
    private int renderX, renderY, renderWidth, renderHeight, borderWidth;
    private float x, y, width, height;
    private final List<SlickPanel> components;
    private Color backgroundColor, borderColor;
    private SlickPanel parent;
    private final GUIContext gui;
    public SlickInteractivePanel(GUIContext gui, float x, float y, float width, float height) {
        super(gui);
        this.gui = gui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        renderX = Math.round(gui.getWidth() * x);
        renderY = Math.round(gui.getHeight() * y);
        renderWidth = Math.round(gui.getWidth() * width);
        renderHeight = Math.round(gui.getHeight() * height);
        components = new ArrayList<>();
        backgroundColor = Color.transparent;
        borderColor = Color.transparent;
        parent = null;
    }
    @Override
    public void render(GUIContext gc, Graphics g) throws SlickException {
        Color savedColor = g.getColor();
        
        g.setColor(borderColor);
        g.fillRect(renderX, renderY, renderWidth, renderHeight);
        g.setColor(backgroundColor);
        g.fillRect(renderX + borderWidth, renderY + borderWidth, renderWidth + borderWidth, renderHeight + borderWidth);
        
        g.setColor(savedColor);
        
        for(SlickPanel component: components)
            component.render(gc, g);
        
    }
    @Override
    public void setLocation(int x, int y) {
        this.x = renderX;
        this.y = renderY;
    }
    @Override
    public int getX() {return renderX;}
    @Override
    public int getY() {return renderY;}
    @Override
    public int getWidth() {return renderWidth;}
    @Override
    public int getHeight() {return renderHeight;}
    @Override
    public float getPercentageWidth() {return width;}
    @Override
    public float getPercentageHeight() {return height;}
    @Override
    public void setWidth(float width) {
        this.width = width;
        if (parent == null)renderWidth = Math.round(this.gui.getWidth() * width);
        else renderWidth = Math.round(width * parent.getWidth());
    }
    @Override
    public void setHeight(float height) {
        this.height = height;
        if (parent == null) renderHeight = Math.round(this.gui.getHeight() * height);
        else renderHeight = Math.round(height * parent.getHeight());
    }
    @Override
    public void setX(float x) {
        this.x = x;
        if (parent == null) renderX = Math.round(this.gui.getWidth() * x);
        else renderX = Math.round(x * parent.getWidth());
    }
    @Override
    public void setY(float y) {
        this.y = y;
        if (parent == null) renderY = Math.round(this.gui.getHeight() * y);
        else renderY = Math.round(y * parent.getHeight());
    }
    @Override
    public void addPanel(SlickPanel comp) {
        components.add(comp);
        comp.setParent(this);
    }
    @Override
    public List<SlickPanel> getPanels() {return components;}
    @Override
    public SlickPanel getPanel(int i) {return components.get(i);}
    @Override
    public void removePanel(int i) {
        components.get(i).removeParent();
        components.remove(i);
    }
    @Override
    public boolean removePanel(SlickPanel comp) {
        comp.removeParent();
        return components.remove(comp);
    }
    @Override
    public Color getBackgroundColor() {return backgroundColor;}
    @Override
    public Color getBorderColor() {return borderColor;}
    @Override
    public int getBorderWidth() {return borderWidth;}
    @Override
    public SlickPanel getParent() {return parent;}
    @Override
    public void setBackgroundColor(Color newColor) {backgroundColor = newColor;}
    @Override
    public void setBorderColor(Color newColor) {borderColor = newColor;}
    @Override
    public void setBorderWidth(int newWidth) {borderWidth = newWidth;}
    @Override
    public void setParent(SlickPanel parent) {
        this.parent.removePanel(this);
        this.parent = parent;
    }
    @Override
    public void removeParent() {parent = null;}

    @Override
    public float getPercentageX() {return x;}

    @Override
    public float getPercentageY() {return y;}

    @Override
    public void setLocation(float x, float y) {
        this.x = x;
        this.y = y;
        if (parent == null){
            renderX = Math.round(this.gui.getHeight() * x);
            renderY = Math.round(this.gui.getHeight() * y);
        }
        else {
            renderX = Math.round(x * parent.getHeight());
            renderY = Math.round(y * parent.getHeight());
        }
    }
}
