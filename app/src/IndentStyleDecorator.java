// A decorator that applies additonal indentation to a style
public class IndentStyleDecorator extends StyleWrapper {
  private int extraIndent;
  
  public IndentStyleDecorator(StyleComponent wrappee, int extraIndent) {
      super(wrappee);
      this.extraIndent = extraIndent;
  }

  @Override
  public void createStyle() {
      super.createStyle();
      Style baseStyle = ((ConcreteStyle) wrappee).getStyle();
      baseStyle.setIndent(baseStyle.getIndent() + extraIndent);
  }
}
