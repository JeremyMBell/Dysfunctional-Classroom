package io;
import frame.Deck;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
public class Initializer {
    private final JFrame parent = new JFrame("Dysfunctional Classroom");
    private final JPanel container = new JPanel(), createLobby = new JPanel(), joinLobby = new JPanel();
    private final JComboBox numPlyrs = new JComboBox();
    private final JTextField dsplyName = new JTextField(), lobbyIP = new JTextField();
    private final JButton createNewLobby = new JButton("Create Lobby"), joinCurrentLobby = new JButton("Join Lobby"), packs = new JButton("Packs");
    private final int MIN_PLYRS = 3, MAX_PLYRS = 6;
    public Initializer(int x, int y, int width, int height) {
        for (int i = MIN_PLYRS; i <= MAX_PLYRS; i++)
            numPlyrs.addItem(i);
        
        createNewLobby.addActionListener(new Create());
        joinCurrentLobby.addActionListener(new Join());
        packs.addActionListener(new Packs());
        
        createLobby.setPreferredSize(new Dimension(350, 130));
        createLobby.setLayout(new BoxLayout(createLobby, BoxLayout.PAGE_AXIS));
        createLobby.add(new JLabel("================Create a Lobby================"));
        createLobby.add(new JLabel("# Players"));
        createLobby.add(numPlyrs);
        createLobby.add(packs);
        createLobby.add(createNewLobby);
        createLobby.setBackground(Color.white);
        createLobby.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        
        joinLobby.setPreferredSize(new Dimension(350, 100));
        joinLobby.setLayout(new BoxLayout(joinLobby, BoxLayout.PAGE_AXIS));
        joinLobby.add(new JLabel("================Join a Lobby================"));
        joinLobby.add(new JLabel("Lobby IP"));
        joinLobby.add(lobbyIP);
        joinLobby.setBackground(Color.white);
        joinLobby.add(joinCurrentLobby);
        joinLobby.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        
        dsplyName.setPreferredSize(new Dimension(300, 20));
        container.add(new JLabel("Display Name: "));
        container.add(dsplyName);
        container.add(createLobby);
        container.add(joinLobby);
        
        parent.add(container);
        parent.setPreferredSize(new Dimension(500, 300));
        parent.pack();
        parent.setVisible(true);
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public class Packs implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
        }
        
    }
    public class Create implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            
        }
    }
    public class Join implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            
        }
    }
    
}
