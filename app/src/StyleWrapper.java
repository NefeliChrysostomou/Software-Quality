// Wrapping style components
public abstract class StyleWrapper implements StyleComponent {
  protected StyleComponent wrappee;

  public StyleWrapper(StyleComponent wrappee) {
    this.wrappee = wrappee;
  }

  @Override
  public void createStyle() {
    wrappee.createStyle();
  }
}
