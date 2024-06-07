import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

/** The class for a Bitmap item
 *@author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

public class BitmapItem extends SlideItem {
  private ImageIcon imageIcon;
  private final String IMAGENAME;
  protected static final String FILE = "File ";
  protected static final String NOTFOUND = " not found";

  // Constructor
  public BitmapItem(int level, String name) {
    super(level);
    IMAGENAME = name;
    try {
      imageIcon = new ImageIcon(IMAGENAME);
    } catch (Exception e) {
      System.err.println(FILE + IMAGENAME + NOTFOUND);
    }
  }

  // Get the filename of the image
  public String getName() {
    return IMAGENAME;
  }

  // Get the bounding box of the image
  public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
    if (imageIcon != null) {
      Image img = imageIcon.getImage();
      return new Rectangle((int) (myStyle.getIndent() * scale), 0,
          (int) (img.getWidth(observer) * scale),
          ((int) (myStyle.getLeading() * scale)) +
              (int) (img.getHeight(observer) * scale));
    } else {
      return new Rectangle(0, 0, 0, 0);
    }
  }

  // Draw the image
  public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {
    if (imageIcon != null) {
      Image img = imageIcon.getImage();
      int width = x + (int) (myStyle.getIndent() * scale);
      int height = y + (int) (myStyle.getLeading() * scale);
      g.drawImage(img, width, height, (int) (img.getWidth(observer) * scale),
          (int) (img.getHeight(observer) * scale), observer);
    }
  }

  public String toString() {
    return "BitmapItem[" + getLevel() + "," + IMAGENAME + "]";
  }
}
