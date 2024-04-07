import java.awt.Color;
import java.awt.Font;

// Creates style instances
public class ConcreteStyle implements StyleComponent {
  private Style style;

  public ConcreteStyle(Color color, Font font, int fontSize, int indent, int leading) {
    style = new Style(indent, color, fontSize, leading);
  }

  public Style getStyle() {
    return style;
  }

  @Override
  public void createStyle() {
    // No operation needed here, as style is already created in the constructor
  }
}
