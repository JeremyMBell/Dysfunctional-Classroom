package frame;

public class Player {
    private final String name;//Name of Person
    static final int MAX_CARDS = 10;//Capacity of a Hand
    private final Card[] hand = new Card[MAX_CARDS];//Hand of Cards to Play
    private int handSize = 0;//How Many Cards are In Hand
    public Player(String a) {
        name = a;
    }
    
    /**
     * Adds a card to the player's hand 
     * @param card  Card to be entered into hand
     *
    */
    public void addCard(Card card) {
        if (handSize >= MAX_CARDS) throw new ArrayIndexOutOfBoundsException();
        hand[handSize] = card;
        handSize++;
    }
    
    /**
     * Returns a card the player has.
     * @param i     The index to grab
     * @return      Card the player request via index
     */
    public Card getCard(int i) {
        if (i >= handSize) throw new ArrayIndexOutOfBoundsException();
        return hand[i];
    }
    
    /**
     * Gives the hand the player currently has.
     * @return The hand the player has.
     */
    public Card[] getHand()  {
        return hand;
    }
    /**
     * Removes a card based on index.
     * @param i     The index of the card to remove
     */
    public void removeCard(int i) {
        if (i >= handSize) throw new ArrayIndexOutOfBoundsException();
        
        //Overwrites by sliding each index over to the left by one
        for (int i2 = i; i2 < handSize - 1; i2++)
            hand[i2] = hand[i2 + 1];
       
        
        //Makes the last line of the list null
        handSize--;
         hand[handSize] = null;
    }
    
    /**
     * Gives the name.
     * @return A name to identify the Player in String format.
     * 
     */
    @Override
    public String toString() {
        return name;
    }
    
    
    
    
}
