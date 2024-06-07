package Presentation;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import Decorator.Style;
import Presentation.Composite.Slide;

/**@author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

public class TextItem extends SlideItem {
  private String text;

  public TextItem(int level, String string) {
    super(level);
    text = string;
  }

  public String getText() {
    return text == null ? "" : text;
  }

  public AttributedString getAttributedString(Style style, float scale) {
    AttributedString attrStr = new AttributedString(getText());
    attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, getText().length());
    return attrStr;
  }

  public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
    List<TextLayout> layouts = getLayouts(g, myStyle, scale);
    int xsize = 0, ysize = (int) (myStyle.getLeading() * scale);
    for (TextLayout layout : layouts) {
      Rectangle2D bounds = layout.getBounds();
      if (bounds.getWidth() > xsize) {
        xsize = (int) bounds.getWidth();
      }
      if (bounds.getHeight() > 0) {
        ysize += (int) bounds.getHeight();
      }
      ysize += (int) (layout.getLeading() + layout.getDescent());
    }
    return new Rectangle((int) (myStyle.getIndent() * scale), 0, xsize, ysize);
  }

  public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver o) {
    if (text == null || text.isEmpty()) {
      return;
    }
    List<TextLayout> layouts = getLayouts(g, myStyle, scale);
    Point pen = new Point(x + (int) (myStyle.getIndent() * scale), y + (int) (myStyle.getLeading() * scale));
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(myStyle.getColor());
    for (TextLayout layout : layouts) {
      pen.y += (int) layout.getAscent();
      layout.draw(g2d, pen.x, pen.y);
      pen.y += (int) layout.getDescent();
    }
  }

  private List<TextLayout> getLayouts(Graphics g, Style s, float scale) {
    List<TextLayout> layouts = new ArrayList<>();
    String textToUse = getText() != null ? getText() : "";
    if (textToUse.isEmpty()) {
      return layouts;
    }
    AttributedString attrStr = getAttributedString(s, scale);
    Graphics2D g2d = (Graphics2D) g;
    FontRenderContext frc = g2d.getFontRenderContext();
    LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
    float wrappingWidth = (Slide.WIDTH - s.getIndent()) * scale;
    while (measurer.getPosition() < textToUse.length()) {
      TextLayout layout = measurer.nextLayout(wrappingWidth);
      layouts.add(layout);
    }
    return layouts;
  }

  public String toString() {
    return "TextItem[" + getLevel() + "," + getText() + "]";
  }

  public TextItem setStyle(String key) {
    this.text = key;
    return this;
  }
}
