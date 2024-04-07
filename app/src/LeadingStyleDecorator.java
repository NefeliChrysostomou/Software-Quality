// A decorator that adds space the the top of a style
public class LeadingStyleDecorator extends StyleWrapper {
  private int newLeading;

  public LeadingStyleDecorator(StyleComponent wrappee, int newLeading) {
      super(wrappee);
      this.newLeading = newLeading;
  }

  @Override
  public void createStyle() {
      super.createStyle();
      Style baseStyle = ((ConcreteStyle) wrappee).getStyle();
      baseStyle.setLeading(newLeading);
  }
}
