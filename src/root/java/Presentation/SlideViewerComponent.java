package Presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
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

/** <p>SlideViewerComponent is a graphical component that can show slides.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

public class SlideViewerComponent extends JComponent {

  private Slide slide; // current slide
  private final Font LABELFONT; // font for labels
  private Presentation presentation; // the presentation
  private final JFrame FRAME;

  private static final Color BGCOLOR = Color.white;
  private static final Color COLOR = Color.black;
  private static final String FONTNAME = "Dialog";
  private static final int FONTSTYLE = Font.BOLD;
  private static final int FONTHEIGHT = 10;
  private static final int XPOS = 1100;
  private static final int YPOS = 20;

  public SlideViewerComponent(Presentation pres, JFrame frame) {
    setBackground(BGCOLOR);
    presentation = pres;
    LABELFONT = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
    this.FRAME = frame;
  }

  public Dimension getPreferredSize() {
    return new Dimension(Slide.WIDTH, Slide.HEIGHT);
  }

  public void update(Presentation presentation, Slide data) {
    if (data == null) {
      repaint();
      return;
    }
    this.presentation = presentation;
    this.slide = data;
    repaint();
    FRAME.setTitle(presentation.getTitle());
  }

  // draw the slide
  public void paintComponent(Graphics g) {
    g.setColor(BGCOLOR);
    g.fillRect(0, 0, getSize().width, getSize().height);
    if (presentation.getCurrentSlideNumber() < 0 || slide == null) {
      return;
    }
    g.setFont(LABELFONT);
    g.setColor(COLOR);
    g.drawString("Slide " + (1 + presentation.getCurrentSlideNumber()) + " of " +
        presentation.getSize(), XPOS, YPOS);
    Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
    slide.draw(g, area, this);
  }
}
