import java.awt.Color;

// A decorator that applies color to a style
public class ColorStyleDecorator extends StyleWrapper {
  private Color newColor;

  public ColorStyleDecorator(StyleComponent wrappee, Color newColor) {
    super(wrappee);
    this.newColor = newColor;
  }

  @Override
  public void createStyle() {
    super.createStyle();
    Style baseStyle = ((ConcreteStyle) wrappee).getStyle();
    baseStyle.setColor(newColor);
  }
}
