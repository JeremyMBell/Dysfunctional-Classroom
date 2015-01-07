package frame;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class Deck {
    private final ArrayList<Card> blackCards;
    private final ArrayList<Card> whiteCards;
    public Deck(Card[] black, Card[] white) {
        blackCards = new ArrayList<>(Arrays.asList(black));
        whiteCards = new ArrayList<>(Arrays.asList(white));
    }
    /**
     * Adds a black card to the deck.
     * @param card - A black card to be added.
     */
    public void addBlack(Card card) {
        blackCards.add(card);
    }
    
    /**
     * Adds a white card to the deck.
     * @param card - A white card to be added.
     */
    public void addWhite(Card card) {
        whiteCards.add(card);
    }
    /**
     * Loads a deck based on a directory.
     * @param folderLocation - The folder containing the black and white cards
     * @return A deck with these cards.
     */
    public static Deck PackLoader(File folderLocation) {
        
        //If folder doesn't exist return an empty deck
        if (!folderLocation.isDirectory()) return new Deck(new Card[0], new Card[0]);
        File black = new File(folderLocation.getAbsolutePath() + "black");
        File white = new File(folderLocation.getAbsolutePath() + "white");
        Deck returnDeck = new Deck(new Card[0], new Card[0]);
        
        //If there's a black file, investigate.
        if (black.exists() && black.canRead()) {
            try {
                for(String line:Files.readAllLines(black.toPath()))
                    returnDeck.addBlack(new Card(line, true));//Add to deck
            }
            catch(Exception e){System.out.println("Error loading black cards.");}
        }
        
        //If there's a white file, investigate.
        if (white.exists() && white.canRead()) {
            try {
                for (String line:Files.readAllLines(white.toPath()))
                    returnDeck.addWhite(new Card(line, false));//Add to deck
            }
            catch (Exception e){System.out.println("Error loading white cards.");}
        }
        return returnDeck;
    }
    
    public static void makePack(ArrayList<String> black, ArrayList<String> white, File location) {
        String blackFile = "";
        String whiteFile = "";
        for (String blackCard: black)
            blackFile += blackCard + "\n";
        for (String whiteCard:white)
            whiteFile += whiteCard + "\n";
        location.mkdir();
        if (whiteFile.length() > 0) {
            File whitePath = new File(location.getAbsolutePath() + "white");
            whitePath.createNewFile();
            whitePath.
            PrintWriter writer = new PrintWriter(location.getAbsolutePath() + "white", "UTF-8");
            writer.print(whiteFile.substring(0, whiteFile.length() - 1));
        }
        
        
        
    }
    
}
