package io;

import frame.Lobby;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
public class Initializer {
    private JFrame parent = new JFrame("DC Initializer");
    private JPanel container = new JPanel(), playerCount = new JPanel(),names = new JPanel();
    private JTextField numNames = new JTextField();
    private JButton go = new JButton("Go"), submit = new JButton("Submit");
    private JLabel numPlayers = new JLabel("# of Players: ");
    private final ArrayList<JTextField> playerNames = new ArrayList<>();
    int num = 0;
    public Initializer(int x, int y, int width, int height) {
        numNames.setPreferredSize(new Dimension(width / 3, 18));
        go.addActionListener(new PlayerCount());
        submit.addActionListener(new Submit());
        playerCount.add(numPlayers);
        playerCount.add(numNames);
        playerCount.add(go);
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
    public class PlayerCount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            names.removeAll();
            try {
                num = Integer.decode(numNames.getText());
                int difference = playerNames.size() - num;
                if (num <= 15 && num >= 1) {
                    if (difference < 0)
                        for (int i = 0; i < difference * -1; i++)
                            playerNames.add(new JTextField());
                    else if (difference > 0)
                        for (int i = 0; i < difference; i++)
                            playerNames.remove(playerNames.size() - 1);
                    for (JTextField player: playerNames) {
                        JPanel name = new JPanel();
                        player.setPreferredSize(numNames.getPreferredSize());
                        name.add(new JLabel("Player Name: "));
                        name.add(player);
                        names.add(name);
                    }
                } else throw new StringIndexOutOfBoundsException("Bad number value.");
                
            }
            catch (NumberFormatException e){
                names.add(new JLabel("Please enter a comprehensible integer."));
            }
            catch (StringIndexOutOfBoundsException e) {
                names.add(new JLabel(e.getMessage()));
                names.add(new JLabel("Please enter an integer between 1 and 15"));
                
            }
            parent.revalidate();
        }
        
    }
    public class Submit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            String[] plyrNames = new String[playerNames.size()];
            for (int i = 0; i < playerNames.size(); i++)
                if (playerNames.get(i).getText().length() > 0)
                    plyrNames[i] = playerNames.get(i).getText();
            parent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            parent.dispatchEvent(new WindowEvent(parent, WindowEvent.WINDOW_CLOSING));
            Output game = new Output("My Game");
            
        }
    }
    
}
