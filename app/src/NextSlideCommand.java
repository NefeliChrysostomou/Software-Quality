public class NextSlideCommand extends Command {
  private Presentation presentation;

  public NextSlideCommand(Presentation presentation) {
    this.presentation = presentation;
  }

  @Override
  public String getName() {
    return "Next";
  }

  @Override
  public void execute() {
    presentation.nextSlide();
  }
}
