package io;

import frame.Card;
import frame.Deck;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
public class Initializer {
    private final JFrame parent = new JFrame("DC Initializer");
    private final JPanel container = new JPanel(), playerCount = new JPanel(),names = new JPanel();
    private final JTextField numNames = new JTextField();
    private final JButton addPack = new JButton("Go"), submit = new JButton("Submit");
    private final JLabel numPlyrs = new JLabel("# of Players: ");
    private final JComboBox numPlayers = new JComboBox();
    private final Deck gameDeck = new Deck(new Card[0], new Card[0]);
    int num = 0;
    public Initializer(int x, int y, int width, int height) {
        numNames.setPreferredSize(new Dimension(width / 3, 18));
        addPack.addActionListener(new AddPack());
        submit.addActionListener(new Submit());
        playerCount.add(numPlayers);
        playerCount.add(numNames);
        playerCount.add(addPack);
        parent.setLocation(new Point(x, y));
        parent.setPreferredSize(new Dimension(width, height));
        names.setLayout(new BoxLayout(names, BoxLayout.Y_AXIS));
        JPanel submitBtn = new JPanel();
        submitBtn.add(submit);
        
        container.add(playerCount);
        container.add(names);
        container.add(submitBtn);
        parent.add(container);
        parent.pack();
        parent.setVisible(true);
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public class AddPack implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            
        }
        
    }
    public class Submit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            
            parent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            parent.dispatchEvent(new WindowEvent(parent, WindowEvent.WINDOW_CLOSING));
            try {
                AppGameContainer myGame = new AppGameContainer(new Output("Dysfunctional Classroom"));
                myGame.setDisplayMode(1000, 600, false);
                myGame.start();
            }
            catch (SlickException e) {
                e.printStackTrace();
                System.out.println("Game launch failed.");
            }
            
            
        }
    }
    
}
