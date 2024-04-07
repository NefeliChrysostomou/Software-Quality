import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OpenCommand extends Command {
  public OpenCommand(Frame parent, Presentation presentation) {
    super(parent, presentation);
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public void execute() {
    presentation.clear();
    Accessor xmlAccessor = new XMLAccessor();
    try {
      xmlAccessor.loadFile(presentation, "test.xml");
      presentation.setSlideNumber(0);
    } catch (IOException exc) {
      JOptionPane.showMessageDialog(parent, "IO Exception: " + exc, "Load Error", JOptionPane.ERROR_MESSAGE);
    }
    parent.repaint();
  }
}
