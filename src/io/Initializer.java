package io;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;
public class Initializer {
    private JFrame parent = new JFrame("DC Initializer");
    private JPanel container = new JPanel(), playerCount = new JPanel(),names = new JPanel();
    private JTextField numNames = new JTextField();
    private JButton go = new JButton("Go"), submit = new JButton("Submit");
    private JLabel numPlayers = new JLabel("# of Players: ");
    private ArrayList<JTextField> playerNames = new ArrayList<>();
    int num = 0;
    public Initializer(int x, int y, int width, int height) {
        numNames.setPreferredSize(new Dimension(width / 3, 18));
        go.addActionListener(new PlayerCount());
        playerCount.add(numPlayers);
        playerCount.add(numNames);
        playerCount.add(go);
        parent.setLocation(new Point(x, y));
        parent.setPreferredSize(new Dimension(width, height));
        
        container.add(playerCount);
        container.add(names);
        parent.add(container);
        parent.pack();
        parent.setVisible(true);
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public class PlayerCount implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            try {
                num = Integer.decode(numNames.getText());
                int difference = playerNames.size() - num;
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
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
}
