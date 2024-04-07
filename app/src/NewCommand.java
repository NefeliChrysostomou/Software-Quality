import java.awt.*;

public class NewCommand extends Command {
  public NewCommand(Frame parent, Presentation presentation) {
    super(parent, presentation);
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public void execute() {
    presentation.clear();
    parent.repaint();
  }
}
