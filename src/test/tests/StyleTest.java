import java.awt.Color;
import java.awt.Font;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Decorator.ColorStyleDecorator;
import Decorator.ConcreteStyle;
import Decorator.FontSizeStyleDecorator;
import Decorator.FontStyleDecorator;
import Decorator.IndentStyleDecorator;
import Decorator.Style;
import Decorator.StyleComponent;
import Decorator.LeadingStyleDecorator;

public class StyleTest {
  private StyleComponent concreteStyle;

  @BeforeEach
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
    ConcreteStyle concreteStyle = new ConcreteStyle(Color.BLACK, new Font("Serif", Font.PLAIN, 22), 14, 2, 2);
    Font expectedFont = new Font("Arial", Font.PLAIN, 14);
    FontStyleDecorator fontStyleDecorator = new FontStyleDecorator(concreteStyle, expectedFont);
    fontStyleDecorator.createStyle();
    Style style = concreteStyle.getStyle();
    assertEquals(expectedFont, style.getFont(1.0f));
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

    // Apply FontSizeStyleDecorator
    StyleComponent fontSizeDecorated = new FontSizeStyleDecorator(concreteStyle, 14);
    fontSizeDecorated.createStyle();

    // Apply FontStyleDecorator
    StyleComponent fontStyleDecorated = new FontStyleDecorator(fontSizeDecorated, newFont);
    fontStyleDecorated.createStyle();

    // Assert
    Style style = ((ConcreteStyle) concreteStyle).getStyle(); // Get the Style object from concreteStyle
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
