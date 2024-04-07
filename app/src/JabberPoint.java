import javax.swing.JOptionPane;
import java.awt.Color;
import java.io.IOException;
// import javax.swing.JOptionPane;
// import java.awt.Color;
// import java.io.IOException;

// Main class
public class JabberPoint {
  protected static final String IOERR = "IO Error: ";
  protected static final String JABERR = "Jabberpoint Error ";
  protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

  public static void main(String argv[]) {
    Presentation presentation = new Presentation();
    new SlideViewerFrame(JABVERSION, presentation);

    // Create and register the new style
    Style.createStyle(5, 30, Color.pink, 24, 10);
    presentation.addStyle("newStyle", Style.getStyle(5));

    // Add the extra slide to the presentation
    Slide extraSlide = new Slide();
    extraSlide.appendSlideItem(new TextItem(5, "").setStyle("This is an extra slide!")); //Put text in .setStyle("")
    presentation.append(extraSlide);

    // Load the presentation file
    try {
      if (argv.length == 0) { // a demo presentation
        Accessor.getDemoAccessor().loadFile(presentation, "");
      } else {
        new XMLAccessor().loadFile(presentation, argv[0]);
      }
      presentation.setSlideNumber(0);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null,
          IOERR + ex, JABERR,
          JOptionPane.ERROR_MESSAGE);
    }
  }
}
