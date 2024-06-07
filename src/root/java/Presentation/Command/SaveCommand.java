package Presentation.Command;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import Accessors.Accessor;
import Accessors.XMLAccessor;
import Presentation.Presentation;

/**@author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

public class SaveCommand extends Command {
  public SaveCommand(Frame parent, Presentation presentation) {
    super(parent, presentation);
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public void execute() {
    Accessor xmlAccessor = new XMLAccessor();
    try {
      xmlAccessor.saveFile(presentation, "dump.xml");
    } catch (IOException exc) {
      JOptionPane.showMessageDialog(parent, "IO Exception: " + exc, "Save Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
