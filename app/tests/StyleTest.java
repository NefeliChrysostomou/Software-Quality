import org.junit.Before;
import java.awt.Color;
import java.awt.Font;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class StyleTest {
    private StyleComponent concreteStyle;

    @Before
    public void setUp() {
        concreteStyle = new ConcreteStyle(Color.black, new Font("Arial", Font.PLAIN, 12), 12, 0, 10);
    }



    @Test
    public void testConcreteStyleColor() {
        Style style = ((ConcreteStyle) concreteStyle).getStyle();
        assertEquals(Color.black, style.getColor());
    }

    @Test
    public void testConcreteStyleFont() {
        Style style = ((ConcreteStyle) concreteStyle).getStyle();
        assertEquals(new Font("Arial", Font.PLAIN, 12), style.getFont(1.0f));
    }

    @Test
    public void testConcreteStyleFontSize() {
        Style style = ((ConcreteStyle) concreteStyle).getStyle();
        assertEquals(12, style.getFontSize());
    }

    @Test
    public void testConcreteStyleIndent() {
        Style style = ((ConcreteStyle) concreteStyle).getStyle();
        assertEquals(0, style.getIndent());
    }

    @Test
    public void testConcreteStyleLeading() {
        Style style = ((ConcreteStyle) concreteStyle).getStyle();
        assertEquals(10, style.getLeading());
    }

    @Test
    public void testColorStyleDecorator() {
        StyleComponent colorDecorated = new ColorStyleDecorator(concreteStyle, Color.blue);
        colorDecorated.createStyle();
        Style style = ((ConcreteStyle) concreteStyle).getStyle();
        assertEquals(Color.blue, style.getColor());
    }

    @Test
    public void testFontSizeStyleDecorator() {
        StyleComponent fontSizeDecorated = new FontSizeStyleDecorator(concreteStyle, 16);
        fontSizeDecorated.createStyle();
        Style style = ((ConcreteStyle) concreteStyle).getStyle();
        assertEquals(16, style.getFontSize());
    }

    @Test
    public void testFontStyleDecorator() {
        Font newFont = new Font("Times New Roman", Font.BOLD, 14);
        StyleComponent fontStyleDecorated = new FontStyleDecorator(concreteStyle, newFont);
        fontStyleDecorated.createStyle();
        Style style = ((ConcreteStyle) concreteStyle).getStyle();
        assertEquals(newFont, style.getFont(1.0f));
    }

    @Test
    public void testIndentStyleDecorator() {
        StyleComponent indentDecorated = new IndentStyleDecorator(concreteStyle, 10);
        indentDecorated.createStyle();
        Style style = ((ConcreteStyle) concreteStyle).getStyle();
        assertEquals(10, style.getIndent());
    }

    @Test
    public void testLeadingStyleDecorator() {
        StyleComponent leadingDecorated = new LeadingStyleDecorator(concreteStyle, 15);
        leadingDecorated.createStyle();
        Style style = ((ConcreteStyle) concreteStyle).getStyle();
        assertEquals(15, style.getLeading());
    }
}