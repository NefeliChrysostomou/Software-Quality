import javax.swing.JOptionPane;
import java.awt.*;
import java.io.IOException;
import java.awt.event.KeyEvent;

/**@author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

// The Main Class
public class JabberPoint {
  protected static final String IOERR = "IO Error: ";
  protected static final String JABERR = "Jabberpoint Error ";
  protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

  public static void main(String argv[]) {
    Presentation presentation = new Presentation();
    SlideViewerFrame slideViewerFrame = new SlideViewerFrame(JABVERSION, presentation);

    // Create and register the new style
    Style.createStyle(5, 30, Color.pink, 24, 10);
    presentation.addStyle("newStyle", Style.getStyle(5));

    // Add the extra slide to the presentation
    Slide extraSlide = new Slide();
    extraSlide.appendSlideItem(new TextItem(5, "").setStyle("This is an extra slide. Epilepsy warning regarding slide 4.")); // Put the text that you want to show in the setStyle()
    presentation.append(extraSlide);

    // Load the presentation file
    try {
      if (argv.length == 0) { // a demo presentation
        Accessor.getDemoAccessor().loadFile(presentation, "");
      } else {
        new XMLAccessor().loadFile(presentation, argv[0]);
      }
      presentation.setSlideNumber(0);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
    }

    // Instantiate controllers
    Frame frame = new Frame();
    MenuController menuController = new MenuController(frame, presentation);
    KeyController keyController = new KeyController(presentation);

    // Bind commands to controllers
    bindCommands(menuController, keyController, presentation);
  }

  private static void bindCommands(MenuController menuController, KeyController keyController, Presentation presentation) {
    // Bind menu commands
    menuController.bindCommand(new NextSlideCommand(presentation), "Next");
    menuController.bindCommand(new PrevSlideCommand(presentation), "Prev");
    menuController.bindCommand(new ExitCommand(presentation), "Exit");

    // Bind key commands
    keyController.addKeyBinding(KeyEvent.VK_RIGHT, new NextSlideCommand(presentation));
    keyController.addKeyBinding(KeyEvent.VK_LEFT, new PrevSlideCommand(presentation));
    keyController.addKeyBinding(KeyEvent.VK_ESCAPE, new ExitCommand(presentation));
  }
}
