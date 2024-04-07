import java.awt.Color;

/**@author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

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
