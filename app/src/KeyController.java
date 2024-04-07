import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.HashMap;
import java.util.Map;

public class KeyController extends KeyAdapter {
  private Presentation presentation;

  public KeyController(Presentation p) {
    presentation = p;
  }

  private Map<Integer, Command> keyBindings = new HashMap<>();

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
