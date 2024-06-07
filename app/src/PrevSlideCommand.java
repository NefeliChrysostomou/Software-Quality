/**@author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

public class PrevSlideCommand extends Command {
  private final Presentation PRESENTATION;

  public PrevSlideCommand(Presentation PRESENTATION) {
    this.PRESENTATION = PRESENTATION;
  }

  @Override
  public String getName() {
    return "Prev";
  }

  @Override
  public void execute() {
    if (PRESENTATION.getCurrentSlideNumber() > 0) {
      PRESENTATION.setSlideNumber(PRESENTATION.getCurrentSlideNumber() - 1);
    }
  }
}
