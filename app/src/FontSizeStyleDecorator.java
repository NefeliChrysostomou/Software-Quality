// A decorator that changes font size of a style
public class FontSizeStyleDecorator extends StyleWrapper {
  private int newFontSize;

  public FontSizeStyleDecorator(StyleComponent wrappee, int newFontSize) {
      super(wrappee);
      this.newFontSize = newFontSize;
  }

  @Override
  public void createStyle() {
      super.createStyle();
      Style baseStyle = ((ConcreteStyle) wrappee).getStyle();
      baseStyle.setFontSize(newFontSize);
  }
}
