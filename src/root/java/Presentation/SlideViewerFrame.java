package Presentation;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

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

/**
 * <p>The application window for a SlideViewerComponent</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

public class SlideViewerFrame extends JFrame {
  private static final String JABTITLE = "Jabberpoint 1.7 - NHL Stenden";
  public final static int WIDTH = 1200;
  public final static int HEIGHT = 800;

  public SlideViewerFrame(String title, Presentation presentation) {
    super(title);
    SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, this);
    presentation.setShowView(slideViewerComponent);
    setupWindow(slideViewerComponent, presentation);
  }

  // Setup GUI
  public void setupWindow(SlideViewerComponent
                              slideViewerComponent, Presentation presentation) {
    setTitle(JABTITLE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    getContentPane().add(slideViewerComponent);
    addKeyListener(new KeyController(presentation)); // add a controller
    setMenuBar(new MenuController(this, presentation));	// add another controller
    setSize(new Dimension(WIDTH, HEIGHT)); // Same sizes as Slide has.
    setVisible(true);
  }
}
