import java.awt.*;
import java.awt.font.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextItem extends SlideItem {
  private String text;
  private static final String EMPTY_TEXT = "No Text Given";

  public TextItem(int level, String string) {
    super(level);
    text = string;
  }

  public TextItem() {
    this(0, EMPTY_TEXT);
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
    Iterator<TextLayout> iterator = layouts.iterator();
    while (iterator.hasNext()) {
      TextLayout layout = iterator.next();
      Rectangle2D bounds = layout.getBounds();
      if (bounds.getWidth() > xsize) {
        xsize = (int) bounds.getWidth();
      }
      if (bounds.getHeight() > 0) {
        ysize += bounds.getHeight();
      }
      ysize += layout.getLeading() + layout.getDescent();
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
    Iterator<TextLayout> it = layouts.iterator();
    while (it.hasNext()) {
      TextLayout layout = it.next();
      pen.y += layout.getAscent();
      layout.draw(g2d, pen.x, pen.y);
      pen.y += layout.getDescent();
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
