import java.awt.*;

/**@author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

public abstract class Command {
  protected Presentation presentation;
  protected Frame parent;

  public Command() {}

  public Command(Frame parent, Presentation presentation) {
    this.parent = parent;
    this.presentation = presentation;
  }

  public abstract String getName();

  public abstract void execute();
}
