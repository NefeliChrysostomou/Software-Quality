import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SaveCommand extends Command {
  public SaveCommand(Frame parent, Presentation presentation) {
    super(parent, presentation);
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public void execute() {
    Accessor xmlAccessor = new XMLAccessor();
    try {
      xmlAccessor.saveFile(presentation, "dump.xml");
    } catch (IOException exc) {
      JOptionPane.showMessageDialog(parent, "IO Exception: " + exc, "Save Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
