import java.awt.*;

public abstract class Command {
    protected Presentation presentation;
    protected Frame parent;

    public Command() {
        // Default constructor
    }

    public Command(Frame parent, Presentation presentation) {
        this.parent = parent;
        this.presentation = presentation;
    }

    public abstract String getName();

    public abstract void execute();
}
