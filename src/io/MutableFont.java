package io;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.TrueTypeFont;
public class MutableFont implements Font {
    private TrueTypeFont drawFont;
    private java.awt.Font editFont;
    private String fontFamily;
    private int fontSize, fontStyle;
    private boolean antiAlias;
    private char[] additionalChars;
    
    public MutableFont(java.awt.Font font, boolean antiAlias, char[] additionalChars) {
        drawFont = new TrueTypeFont(font, antiAlias, additionalChars);
        editFont = font;
        this.antiAlias = antiAlias;
        this.additionalChars = additionalChars;
        fontFamily = font.getFamily();
        fontStyle = font.getStyle();
        fontSize = font.getSize();
    }
    public MutableFont(java.awt.Font font, boolean antiAlias) {
        drawFont = new TrueTypeFont(font, antiAlias);
        editFont = font;
        this.antiAlias = antiAlias;
        fontFamily = font.getFamily();
        fontStyle = font.getStyle();
        fontSize = font.getSize();
    }
    /**
     * Since the java.awt.Font and TrueTypeFont classes aren't Mutable, we
     * imitate it by creating new objects which is inefficient if they're
     * recreated rapidly. This method will make those new Objects when called
     * (usually after changes).
     */
    private void refreshFont() {
        editFont = new java.awt.Font(fontFamily, fontStyle, fontSize);
        if (additionalChars.length > 0)
            drawFont = new TrueTypeFont(editFont, antiAlias, additionalChars);
        else drawFont = new TrueTypeFont(editFont, antiAlias);
    }
    
    /**
     * Sets the size of the font.
     * @param size New size of the font.
     */
    public void setSize(int size) {
        fontSize = size;
        refreshFont();
    }
    /**
     * Sets the font style.
     * @param style New font style (based off of java.awt.Font)
     */
    public void setStyle(int style) {
        fontStyle = style;
        refreshFont();
    }
    /**
     * Sets the font family.
     * @param family The new family.
     */
    public void setFamily(String family) {
        fontFamily = family;
        refreshFont();
    }
    /**
     * Sets if the font will have aliasing.
     * @param antiAlias True to have anti-alias on.
     */
    public void setAntiAlias(boolean antiAlias) {
        this.antiAlias = antiAlias;
        refreshFont();
    }
    /**
     * Sets the characters to render in addition to the original 256.
     * @param additionalChars Array of characters to include with the basics.
     */
    public void setAdditionalChars(char[] additionalChars) {
        this.additionalChars = additionalChars;
        refreshFont();
    }
    
    /**
     * Gives the font size.
     * @return Font Size
     */
    public int getSize(){return fontSize;}
    /**
     * Gives the font style.
     * @return Font Style (according to java.awt.Font)
     */
    public int getStyle() {return fontStyle;}
    /**
     * Gives the font family.
     * @return Font Family
     */
    public String getFamily(){return fontFamily;}
    /**
     * Gives the additional characters.
     * @return Characters added to the font in addition to the basic 256
     */
    public char[] getAdditionalChars() {return additionalChars;}
    /**
     * Tells if anti-alias is on.
     * @return True if anti-alias is on.
     */
    public boolean hasAntiAlias(){return antiAlias;}
    

    @Override
    public int getWidth(String string) {
        return drawFont.getWidth(string);
    }

    @Override
    public int getHeight(String string) {
        return drawFont.getHeight(string);
    }

    @Override
    public int getLineHeight() {
        return drawFont.getLineHeight();
    }

    @Override
    public void drawString(float f, float f1, String string) {
        drawFont.drawString(f, f1, string);
    }

    @Override
    public void drawString(float f, float f1, String string, Color color) {
        drawFont.drawString(f, f1, string, color);
    }

    @Override
    public void drawString(float f, float f1, String string, Color color, int i, int i1) {
        drawFont.drawString(f, f1, string, color, i, i1);
    }
    
    
}
