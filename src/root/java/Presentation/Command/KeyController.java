package Presentation.Command;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.HashMap;
import java.util.Map;

import Accessors.Accessor;
import Accessors.DemoPresentation;
import Accessors.XMLAccessor;
import Decorator.ColorStyleDecorator;
import Decorator.ConcreteStyle;
import Decorator.FontSizeStyleDecorator;
import Decorator.FontStyleDecorator;
import Decorator.IndentStyleDecorator;
import Decorator.Style;
import Decorator.StyleComponent;
import Decorator.StyleWrapper;
import Jabberpoint.JabberPoint;
import Presentation.Command.AboutBox;
import Presentation.Command.Command;
import Presentation.Command.ExitCommand;
import Presentation.Command.KeyController;
import Presentation.Command.MenuController;
import Presentation.Command.NewCommand;
import Presentation.Command.NextSlideCommand;
import Presentation.Command.OpenCommand;
import Presentation.Command.PrevSlideCommand;
import Presentation.Command.Receiver;
import Presentation.Command.SaveCommand;
import Presentation.Composite.SlideComponent;
import Presentation.Composite.Slide;
import Presentation.Presentation;
import Presentation.BitmapItem;
import Presentation.SlideItem;
import Presentation.SlideViewerComponent;
import Presentation.SlideViewerFrame;
import Presentation.TextItem;

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
  private final Presentation PRESENTATION;

  public KeyController(Presentation p) {
    PRESENTATION = p;
  }

  private final Map<Integer, Command> KEYBINDINGS = new HashMap<>();

  public void addKeyBinding(int keyCode, Command command) {
    KEYBINDINGS.put(keyCode, command);
  }

  public void keyPressed(KeyEvent keyEvent) {
    switch(keyEvent.getKeyCode()) {
      case KeyEvent.VK_SPACE:
      case KeyEvent.VK_RIGHT:
      case KeyEvent.VK_ENTER:
      case '+':
        NextSlideCommand next = new NextSlideCommand(PRESENTATION);
        next.execute();
        break;
      case KeyEvent.VK_SHIFT:
      case KeyEvent.VK_BACK_SPACE:
      case KeyEvent.VK_LEFT:
      case '-':
        PrevSlideCommand prev = new PrevSlideCommand(PRESENTATION);
        prev.execute();
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
