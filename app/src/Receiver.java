public abstract class Receiver {

  public Command executeCommand() {
    return null;
  }

  public abstract void executeKeyCommand(Command command);
}
