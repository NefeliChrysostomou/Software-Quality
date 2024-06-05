import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.HashMap;
import java.util.Map;

/**@author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

public class KeyController extends KeyAdapter {
  private final Presentation presentation;

  public KeyController(Presentation p) {
    presentation = p;
  }

  private final Map<Integer, Command> keyBindings = new HashMap<>();

  public void addKeyBinding(int keyCode, Command command) {
    keyBindings.put(keyCode, command);
  }

  public void keyPressed(KeyEvent keyEvent) {
    switch(keyEvent.getKeyCode()) {
      case KeyEvent.VK_SPACE:
      case KeyEvent.VK_RIGHT:
      case KeyEvent.VK_ENTER:
      case '+':
        presentation.nextSlide();
        break;
      case KeyEvent.VK_SHIFT:
      case KeyEvent.VK_BACK_SPACE:
      case KeyEvent.VK_LEFT:
      case '-':
        presentation.prevSlide();
        break;
      case 'q':
      case 'Q':
      case KeyEvent.VK_ESCAPE:
        System.exit(0);
        break; // Probably never reached!!
      default:
        break;
    }
  }
}
