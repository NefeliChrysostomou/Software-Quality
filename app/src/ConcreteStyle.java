import java.awt.Color;
import java.awt.Font;

/**@author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

// Creates style instances
public class ConcreteStyle implements StyleComponent {
  private final Style STYLE;

  public ConcreteStyle(Color color, Font font, int fontSize, int indent, int leading) {
    STYLE = new Style(indent, color, fontSize, leading);
  }

  public Style getStyle() {
    return STYLE;
  }

  @Override
  public void createStyle() {
    // No operation needed here, as style is already created in the constructor
  }
}