import java.awt.*;

public class ExitCommand extends Command {
    private Presentation presentation;

    public ExitCommand(Presentation presentation) {
        this.presentation = presentation;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void execute() {
        presentation.exit(0);
    }
}
