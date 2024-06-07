package Presentation.Composite;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

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

/** <p> A slide. This class has a drawing functionality.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

public class Slide implements SlideComponent {
  public final static int WIDTH = 1200;
  public final static int HEIGHT = 800;
  protected String title; // title is saved separately
  protected Vector<SlideItem> items; // slide items are saved in a Vector

  public Slide() {
    items = new Vector<>();
  }

  // Add a slide item
  public void appendSlideItem(SlideItem anItem) {
    items.addElement(anItem);
  }

  // give the title of the slide
  public String getTitle() {
    return title;
  }

  // change the title of the slide
  public void setTitle(String newTitle) {
    title = newTitle;
  }

  // Create TextItem of String, and add the TextItem
  public void appendTextItem(int level, String message) {
    appendSlideItem(new TextItem(level, message));
  }

  // give all SlideItems in a Vector
  public Vector<SlideItem> getSlideItems() {
    return items;
  }

  // give the size of the Slide
  public int getSize() {
    return items.size();
  }

  // draw the slide
  public void draw(Graphics g, Rectangle area, ImageObserver view) {
    float scale = getScale(area);
    int y = area.y;
    // Title is handled separately
    SlideItem slideItem = new TextItem(0, getTitle());
    Style style = Style.getStyle(slideItem.getLevel());
    slideItem.draw(area.x, y, scale, g, style, view);
    y += slideItem.getBoundingBox(g, view, scale, style).height;
    for (int number=0; number<getSize(); number++) {
      slideItem = getSlideItems().elementAt(number);
      style = Style.getStyle(slideItem.getLevel());
      slideItem.draw(area.x, y, scale, g, style, view);
      y += slideItem.getBoundingBox(g, view, scale, style).height;
    }
  }

  // Give the scale for drawing
  private float getScale(Rectangle area) {
    return Math.min(((float)area.width) / ((float)WIDTH), ((float)area.height) / ((float)HEIGHT));
  }

  @Override
  public void append(SlideComponent slide) {
    throw new UnsupportedOperationException("Cannot append slide to leaf component");
  }
}
