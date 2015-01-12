/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

public abstract class SlickInteractablePanel extends AbstractComponent implements SlickPanel {
    private int x, y, width, height;
    private final List<AbstractComponent> components;
    public SlickInteractablePanel(GUIContext gui, int x, int y, int width, int height) {
        super(gui);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        components = new ArrayList<>();
    }

    @Override
    public void render(GUIContext guic, Graphics grphcs) throws SlickException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public void addComponent(AbstractComponent comp) {
        components.add(comp);
    }
    
    @Override
    public List<AbstractComponent> getComponents() {
        return components;
    }
    @Override
    public AbstractComponent getComponent(int i) {
        return components.get(i);
    }
    @Override
    public void removeComponent(int i) {
        components.remove(i);
    }
    @Override
    public boolean removeComponent(AbstractComponent comp) {
        return components.remove(comp);
    }
    
}
