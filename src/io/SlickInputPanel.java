package io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

public class SlickInputPanel extends ObjectInputStream implements SlickPanel, MouseListener {
    private int renderX, renderY, renderWidth, renderHeight, borderWidth, windowWidth, windowHeight;
    private float x, y, width, height;
    private final List<SlickPanel> components;
    private Color backgroundColor, borderColor;
    private SlickPanel parent;
    
    private boolean loop;
    public SlickInputPanel(float x, float y, float width, float height) throws IOException {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        components = new ArrayList<>();
        backgroundColor = Color.transparent;
        borderColor = Color.transparent;
        parent = null;
        loop = true;
    }
    @Override
    public void init(GUIContext gc, Graphics g) {
        windowWidth = gc.getWidth();
        windowHeight = gc.getHeight();
        renderX = Math.round(windowWidth * x);
        renderY = Math.round(windowHeight * y);
        renderWidth = Math.round(windowWidth * width);
        renderHeight = Math.round(windowHeight * height);
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
        if (parent == null)renderWidth = Math.round(windowWidth * width);
        else renderWidth = Math.round(width * parent.getWidth());
    }
    @Override
    public void setHeight(float height) {
        this.height = height;
        if (parent == null) renderHeight = Math.round(windowHeight * height);
        else renderHeight = Math.round(height * parent.getHeight());
    }
    @Override
    public void setX(float x) {
        this.x = x;
        if (parent == null) renderX = Math.round(windowWidth * x);
        else renderX = Math.round(x * parent.getWidth());
    }
    @Override
    public void setY(float y) {
        this.y = y;
        if (parent == null) renderY = Math.round(windowHeight * y);
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
            renderX = Math.round(windowWidth * x);
            renderY = Math.round(windowHeight * y);
        }
        else {
            renderX = Math.round(x * parent.getHeight());
            renderY = Math.round(y * parent.getHeight());
        }
    }
    @Override
    public void mousePressed(int button, int x, int y) {
        System.out.println("Clicky");
        if (button == 0 && x >= renderX && x <= renderX + renderWidth && y >= renderY && y <= renderY + renderHeight) {
            System.out.println("Click2");
            loop = false;
        }
        
    }

    @Override
    public void mouseWheelMoved(int i) {}

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {}

    @Override
    public void mouseReleased(int i, int i1, int i2) {}

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {}

    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {}

    @Override
    public void setInput(Input input) {}

    @Override
    public boolean isAcceptingInput() {return false;}

    @Override
    public void inputEnded() {}

    @Override
    public void inputStarted() {}
}
