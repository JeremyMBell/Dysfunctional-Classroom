package io;
import java.awt.Font;
import java.util.Scanner;
import org.newdawn.slick.Color;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.TrueTypeFont;
public class Input extends AbstractComponent {
    private static Scanner scan = new Scanner(System.in);
    private int width, height, x, y;
    private TextField chatInput;
    public Input(GameContainer gc) {
        super(gc);
    }
    public int getHeight() {return height;}
    public int getWidth() {return width;}
    public int getX(){return x;}
    public int getY(){return y;}
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setHeight(int l){height = l;}
    public void setWidth(int l){width = l;}
    public void init(GUIContext gui) {
        chatInput = new TextField(gui, new TrueTypeFont(new Font("Rockwell", Font.PLAIN, 14), true), x, gui.getHeight() - 20, width, 20);
    }
    public void render(GUIContext gui, Graphics g){
        chatInput.render(gui, g);
    }
    public static int receiveInput () {
        System.out.print("Who do you want to target? ");
        return scan.nextInt();
    }
    
}
