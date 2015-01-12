package frame;
import io.MutableFont;
import io.Output;
import java.awt.Point;
import java.util.LinkedList;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Font;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;
public class Card extends AbstractComponent {
    
    /**
     * Is this a black card?
     */
    private final boolean isBlack;
    
    /**
     * Is the card selected?
     */
    private boolean selected = false;
    
    /**
     * How many cards are needed to be played for this card?
     */
    private short cardsPlay;
    
    /**
     * What does the card say?
     */
    private final String text;
    
    /**
     * this.text, but wrapped for drawing.
     */
    private final LinkedList<String> wrappedText = new LinkedList<>();
    
    /**
     * What is the width and height of each SpriteSheet block?
     */
    public static final int CARD_WIDTH = 300, CARD_HEIGHT = 500;
    
    /**
     * A SpriteSheet of the cards' backgrounds
     */
    public final static SpriteSheet cardSprites = new SpriteSheet(
                Output.toImage("src/images/cardSpriteSheet.gif"),
                CARD_WIDTH, CARD_HEIGHT);
    
    /**
     * What will be behind the text when drawn.
     */
    private Image background;
    /**
     * What is the width and height of the card when it's drawn?
     */
    private int drawWidth, drawHeight;
    /**
     * Where is the card located in the window?
     */
    private final Point location;
    
    /**
     * What font will the text be displayed as?
     */
    MutableFont font;
    public Card(String content, boolean isBlackCard, GUIContext gui) {
        super(gui);
        isBlack = isBlackCard;
        cardsPlay = 0;
        font = Output.deflt;
        if (isBlack) {
            
            //Reading the black card line.
            //Syntax: Begins with Tabs (# of Tabs = number of cards to play) Then card content.
            for (short i = 0; i < content.length(); i++) {
                //There's no more tabs, so stop.
                if (!("" + content.charAt(i)).equals("\t")) {
                    cardsPlay = i;
                    break;
                }
            }
            //Black sprite
            background = cardSprites.getSprite(0, 0);
        }
        else background = cardSprites.getSprite(1, 0);//White sprite
        text = content.substring(cardsPlay);//Getting rid of tabs (if any)
        int lastStop = 0;
        
        //Finding where the string clips the boundry and applying word wrap.
        for (int i = 0; i < text.length(); i++)
            if (font.getWidth(text.substring(lastStop, i)) > CARD_WIDTH * 4 / 5) {//Text centered at a width of 80%
                wrappedText.add(text.substring(lastStop, i));
                lastStop = i;
            }
        
        //By default, we want to draw at half of what the sprites are drawn at
        drawWidth = Math.round(CARD_WIDTH  * .5f);
        drawHeight = Math.round(CARD_HEIGHT  * .5f);
        
        //We were not given a location.
        location = new Point(0, 0);
    }
    
    @Override
    public String toString() {return text;}
    
    /**
     * Gives the number of cards needed to be played for this card.
     * @return Number of Cards needed to play.
     */
    public short numCardsNeeded() {return cardsPlay;}
    
    /**
     * Tells if the card is a black card.
     * @return True if black.
     */
    public boolean isBlack() {return isBlack;}
    
    /**
     * Selects card for selection.
     */
    public void select() {
        if (!isBlack && !selected) {
            selected = true;
            background = cardSprites.getSprite(2, 0);
        }
    }
    
    /**
     * Makes a card no longer selected.
     */
    public void deselect() {
        if (!isBlack && selected) {
            selected = false;
            background = cardSprites.getSprite(1, 0);
        }
    }
    /**
     * Proportionally scale the card.
     * @param scale A multiplier e.g. A 200% (doubling) scale would be 2.0
     */
   public void scale(float scale) {
       drawWidth *= scale;
       drawHeight *= scale;
       font.setSize(Math.round(font.getSize() * scale));
   }
   
   /**
    * Proportionally scale the card to a new width;
    * @param newWidth The new width of the card.
    */
   public void scaleWidth(float newWidth) {
       float scale = newWidth / drawWidth;
       scale(scale);
   }
   /**
    * Proportionally scale the card to a new height;
    * @param newHeight The new height of the card.
    */
   public void scaleHeight(float newHeight) {
       float scale = newHeight / drawWidth;
       scale(scale);
   }

    @Override
    public void render(GUIContext gc, Graphics g) throws SlickException {
        background.draw(location.x, location.y, drawWidth, drawHeight);
        
        //Backing up overwritten stuff for seamless drawing
        Font savedFont = g.getFont();
        Color savedColor = g.getColor();
        
        //Setting the color and font for drawing text
        if(isBlack) g.setColor(Color.white);
        else g.setColor(Color.black);
        g.setFont(font);
        
        //Drawing line by line (some padding is added).
        for(int i = 0; i < wrappedText.size(); i++)
            g.drawString(wrappedText.get(i), location.x + drawWidth / 10, location.y + drawWidth / 10 + i * font.getLineHeight());
        
        //Setting the color and font back for seamless drawing
        g.setColor(savedColor);
        g.setFont(savedFont);
            
    }

    @Override
    public void setLocation(int x, int y) {
        location.x = x;
        location.y = y;
    }

    @Override
    public int getX() {
        return location.x;
    }

    @Override
    public int getY() {
        return location.y;
    }

    @Override
    public int getWidth() {
        return drawWidth;
    }

    @Override
    public int getHeight() {
        return drawHeight;
    }
}
