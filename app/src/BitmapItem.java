import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/** The class for a Bitmap item */
public class BitmapItem extends SlideItem {
  private ImageIcon imageIcon;
  private String imageName;
  protected static final String FILE = "File ";
  protected static final String NOTFOUND = " not found";

  // Constructor
  public BitmapItem(int level, String name) {
    super(level);
    imageName = name;
    try {
      imageIcon = new ImageIcon(imageName);
    } catch (Exception e) {
      System.err.println(FILE + imageName + NOTFOUND);
    }
  }

  // An empty bitmap-item
  public BitmapItem() {
    this(0, null);
  }

  // Get the filename of the image
  public String getName() {
    return imageName;
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

  // Override toString method
  public String toString() {
    return "BitmapItem[" + getLevel() + "," + imageName + "]";
  }
}
