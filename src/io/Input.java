package io;
import frame.Classroom;
import java.awt.Font;
import java.util.Scanner;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
//import org.newdawn.slick.gui.TextField;
public class Input extends AbstractComponent {
    private static Scanner scan = new Scanner(System.in);
    private int width, height, x, y;
    private TextField chatInput, chatOutput;
    private ComboBox target;
    private Classroom room;
    public Input(GameContainer gc) {
        super(gc);
    }
    public int getHeight() {return height;}
    public int getWidth() {return width;}
    public int getX(){return x;}
    public int getY(){return y;}
    public TextField getTextField(){return chatInput;}
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setHeight(int l){height = l;}
    public void setWidth(int l){width = l;}
    public void init(GUIContext gui, Classroom clsrm) {
        int size = height / 25;
        TrueTypeFont rockwell = new TrueTypeFont(new Font("Rockwell", Font.PLAIN, size - 5), true);
        chatInput = new TextField(gui, rockwell, x, height - size, width, size);
        chatOutput = new TextField(gui, rockwell, x, y + height / 2, width, height / 2 - size);
        System.out.println("Y: " + y + "\nHeight: " + height);
        chatInput.setBackgroundColor(Color.decode("#6DB087"));
        chatInput.setBorderColor(Color.decode("#3A3B3A"));
        chatInput.setAlwaysFocused(true);
        chatOutput.setBackgroundColor(Color.white);
        chatOutput.setTextColor(Color.black);
        chatOutput.setBorderColor(Color.decode("#3A3B3A"));
        chatOutput.setMultiLine(true);
        room = clsrm;
        target = new ComboBox(gui, rockwell, x, y, width, height / 2);
        for(frame.Character person: room.classmates())
            target.addItem(person.toString());
        
    }
    
    public void update(GameContainer gc, int i) throws SlickException {
        String entered = chatInput.getEntered();
        if (entered.length() != 0) {
            chatOutput.setText(chatOutput.getText() + "\n" + entered);
        }
    }
    
    @Override
    public void render(GUIContext gui, Graphics g){
        chatInput.render(gui, g);
        chatOutput.render(gui, g);
        target.render(gui, g);
    }
    public static int receiveInput () {
        System.out.print("Who do you want to target? ");
        
        return scan.nextInt();
    }
    public void mousePressed(int button, int x, int y) {
        if (x >= chatInput.x && x <= x + chatInput.getWidth() && y <= height && y >= height - chatInput.getHeight())
            chatInput.setFocus(true);
        
    }
    
}
