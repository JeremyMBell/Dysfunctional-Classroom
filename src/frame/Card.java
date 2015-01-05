package frame;
public class Card {
    private final boolean isBlack;
    private short cardsPlay;
    private final String text;
    public Card(String a, boolean b) {
        isBlack = b;
        cardsPlay = 0;
        if (isBlack) {
            for (short i = 0; i < a.length(); i++) {
                if (!("" + a.charAt(i)).equals("\t")) {
                    cardsPlay = i;
                    break;
                }
            }
        }
        text = a.substring(cardsPlay);
    }
    
}
