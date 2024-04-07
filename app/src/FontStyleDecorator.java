import java.awt.Font;

// A decorator that changed font family of a style
public class FontStyleDecorator extends StyleWrapper {
  private Font newFont;

  public FontStyleDecorator(StyleComponent wrappee, Font newFont) {
      super(wrappee);
      this.newFont = newFont;
  }

  @Override
  public void createStyle() {
      super.createStyle();
      Style baseStyle = ((ConcreteStyle) wrappee).getStyle();
      baseStyle.setFont(newFont);
  }
}
