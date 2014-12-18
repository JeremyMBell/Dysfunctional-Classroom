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
    String selectedTarget = null;
    public Input(GameContainer gc) {
        super(gc);
    }
    @Override
    public int getHeight() {return height;}
    @Override
    public int getWidth() {return width;}
    @Override
    public int getX(){return x;}
    @Override
    public int getY(){return y;}
    public TextField getTextField(){return chatInput;}
    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setHeight(int l){height = l;}
    public void setWidth(int l){width = l;}
    public void init(GUIContext gui, Classroom clsrm) {
        int size = height / 25;
        TrueTypeFont rockwell = new TrueTypeFont(new Font("Rockwell", Font.PLAIN, size - 5), true);
        TrueTypeFont smallRockwell = new TrueTypeFont(new Font("Rockwell", Font.PLAIN, height / 40), true); 
        chatInput = new TextField(gui, rockwell, x, height - size, width, size);
        chatOutput = new TextField(gui, smallRockwell, x, y + height / 2, width, height / 2 - size);
        System.out.println("Y: " + y + "\nHeight: " + height);
        chatInput.setBackgroundColor(Color.decode("#6DB087"));
        chatInput.setBorderColor(Color.decode("#3A3B3A"));
        chatInput.setAlwaysFocused(true);
        chatOutput.setBackgroundColor(Color.white);
        chatOutput.setTextColor(Color.black);
        chatOutput.setBorderColor(Color.decode("#3A3B3A"));
        chatOutput.setMultiLine(true);
        room = clsrm;
        target = new ComboBox(gui, smallRockwell, x, y, width / 2, height / 2);
        target.setBackgroundColor(Color.decode("#3A3B3A"));
        target.setTextColor(Color.white);
        
        for(frame.Character person: room.classmates())
            target.addItem(person.toString());
        
    }
    
    public void update(GameContainer gc, int i) throws SlickException {
        String enteredChat = chatInput.getEntered();
        String enteredInput = target.getSelectedItem();
        if (enteredChat.length() != 0) {
            chatOutput.setText(chatOutput.getText() + "\n" + enteredChat);
        }
        if (enteredInput == null && selectedTarget != null) {
            chatOutput.setText("You are no longer targetting " + selectedTarget);
            selectedTarget = null;
        }
        else if (enteredInput != null && !enteredInput.equals(selectedTarget)) {
            selectedTarget = enteredInput;
            chatOutput.setText("You have decided to target " + selectedTarget);
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
