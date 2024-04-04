import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

public class Style {
    private static Map<Integer, Style> styles = new HashMap<>();
    private static final int DEFAULT_STYLE_KEY = 0;
    private static final String FONTNAME = "Helvetica";

    private int indent;
    private Color color;
    private Font font;
    private int fontSize;
    private int leading;

    public Style(int indent, Color color, int size, int leading) {
        this.indent = indent;
        this.color = color;
        font = new Font(FONTNAME, Font.BOLD, fontSize = size);
        this.leading = leading;
    }

    public static void createStyle(int key, int indent, Color color, int size, int leading) {
        styles.put(key, new Style(indent, color, size, leading));
    }

    public static Style getStyle(int key) {
        return styles.getOrDefault(key, styles.get(DEFAULT_STYLE_KEY));
    }

    public int getIndent() {
        return indent;
    }

    public void setIndent(int indent) {
        this.indent = indent;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Font getFont(float scale) {
        return font.deriveFont(fontSize * scale);
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getFontSize(){
        return fontSize;
    }

    public int getLeading() {
        return leading;
    }

    public void setLeading(int leading) {
        this.leading = leading;
    }

    static {
        createStyles();
    }

    private static void createStyles() {
        styles.put(DEFAULT_STYLE_KEY, new Style(0, Color.black, 12, 10));
        styles.put(0, new Style(0, Color.red, 48, 20));   // style for item-level 0
        styles.put(1, new Style(20, Color.blue, 40, 10)); // style for item-level 1
        styles.put(2, new Style(50, Color.black, 36, 10)); // style for item-level 2
        styles.put(3, new Style(70, Color.black, 30, 10)); // style for item-level 3
        styles.put(4, new Style(90, Color.black, 24, 10)); // style for item-level 4
    }
}
