package Accessors;

import Presentation.Presentation;
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
import java.io.IOException;

/**
 * <p>* An Accessor makes it possible to write or read data for a presentation</p>
 * <p>Non-abstract subclasses must implement the load and the save method.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

public abstract class Accessor {
  public static final String DEMO_NAME = "Demonstration presentation";
  public static final String DEFAULT_EXTENSION = ".xml";

  public static Accessor getDemoAccessor() {
    return new DemoPresentation();
  }

  public Accessor() {
  }

  abstract public void loadFile(Presentation p, String fn) throws IOException;
  abstract public void saveFile(Presentation p, String fn) throws IOException;
}
