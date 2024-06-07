package Accessors;

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



/** A built-in demo-presentation
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

/** This class does not follow the Single Responsibility Principle
 * as the presentation created in it is simply for testing purposes
 * and does not reflect the functionality of the rest of the application
 */

// Default presentation provided on start-up
public class DemoPresentation extends Accessor {

  public void loadFile(Presentation presentation, String unusedFilename) {
    presentation.setTitle("Demo Presentation");
    Slide slide;
    slide = new Slide();
    slide.setTitle("JabberPoint");
    slide.appendTextItem(1, "The Java Presentation Tool");
    slide.appendTextItem(2, "Copyright (c) 1996-2000: Ian Darwin");
    slide.appendTextItem(2, "Copyright (c) 2000-now:");
    slide.appendTextItem(2, "Gert Florijn andn Sylvia Stuurman");
    slide.appendTextItem(4, "Starting JabberPoint without a filename");
    slide.appendTextItem(4, "shows this presentation");
    slide.appendTextItem(1, "Navigate:");
    slide.appendTextItem(3, "Next slide: right-arrow, Space or Enter");
    slide.appendTextItem(3, "Previous slide: left-arrow, Backspace or Shift");
    slide.appendTextItem(3, "Quit: Q or Esc");
    presentation.append(slide);

    slide = new Slide();
    slide.setTitle("Demonstration of levels and styles");
    slide.appendTextItem(1, "Level 1");
    slide.appendTextItem(2, "Level 2");
    slide.appendTextItem(1, "Again level 1");
    slide.appendTextItem(1, "Level 1 has style number 1");
    slide.appendTextItem(2, "Level 2 has style number  2");
    slide.appendTextItem(3, "This is how level 3 looks like");
    slide.appendTextItem(4, "And this is level 4");
    presentation.append(slide);

    slide = new Slide();
    slide.setTitle("The third slide");
    slide.appendTextItem(1, "To open a new presentation,");
    slide.appendTextItem(2, "use File->Open from the menu.");
    slide.appendTextItem(1, " ");
    slide.appendTextItem(1, "This is the end of the presentation.");
     slide.appendSlideItem(new BitmapItem(1, "JabberPoint.gif"));
    presentation.append(slide);
  }

  public void saveFile(Presentation presentation, String unusedFilename) {
    throw new IllegalStateException("Save As->Demo! called");
  }
}
