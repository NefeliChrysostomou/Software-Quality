public class PrevSlideCommand extends Command {
  private Presentation presentation;

  public PrevSlideCommand(Presentation presentation) {
    this.presentation = presentation;
  }

  @Override
  public String getName() {
    return "Prev";
  }

  @Override
  public void execute() {
    presentation.prevSlide();
  }
}
