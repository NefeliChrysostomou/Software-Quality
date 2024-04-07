import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class CommandTest {

  @Test
  public void testExitCommand() {
    Presentation presentation = new Presentation();
    Command exitCommand = new ExitCommand(presentation);
    assertEquals("Exit", exitCommand.getName());
  }

  //Doesn't run, stops but gives no error. very confused
  @Test
  public void testExecuteExitCommand() {
    Presentation presentation = new Presentation();
    Command exitCommand = new ExitCommand(presentation);
    // Ensure that calling execute exits the application without throwing exceptions
    assertDoesNotThrow(() -> exitCommand.execute());
  }

  @Test
  public void testOpenCommand() {
    Presentation presentation = new Presentation();
    Frame parent = new Frame();
    Command openCommand = new OpenCommand(parent, presentation);
    assertEquals(null, openCommand.getName());
  }

  @Test
  public void testExecuteOpenCommand() {
    Presentation presentation = new Presentation();
    Frame parent = new Frame();
    Command openCommand = new OpenCommand(parent, presentation);
    // Ensure that calling execute opens a file without throwing exceptions
    assertDoesNotThrow(() -> openCommand.execute());
  }

  @Test
  public void testNextSlideCommand() {
    Presentation presentation = new Presentation();
    Command nextSlideCommand = new NextSlideCommand(presentation);
    assertEquals("Next", nextSlideCommand.getName());
  }

  @Test
  public void testExecuteNextSlideCommand() {
    Presentation presentation = new Presentation();
    Command nextSlideCommand = new NextSlideCommand(presentation);
    // Ensure that calling execute moves to the next slide without throwing exceptions
    assertDoesNotThrow(() -> nextSlideCommand.execute());
  }

  @Test
  public void testPrevSlideCommand() {
    Presentation presentation = new Presentation();
    Command prevSlideCommand = new PrevSlideCommand(presentation);
    assertEquals("Prev", prevSlideCommand.getName());
  }

  @Test
  public void testExecutePrevSlideCommand() {
    Presentation presentation = new Presentation();
    Command prevSlideCommand = new PrevSlideCommand(presentation);
    // Ensure that calling execute moves to the previous slide without throwing exceptions
    assertDoesNotThrow(() -> prevSlideCommand.execute());
  }

  @Test
  public void testNewCommand() {
    Presentation presentation = new Presentation();
    Frame parent = new Frame();
    Command newCommand = new NewCommand(parent, presentation);
    assertEquals(null, newCommand.getName());
  }

  @Test
  public void testExecuteNewCommand() {
    Presentation presentation = new Presentation();
    Frame parent = new Frame();
    Command newCommand = new NewCommand(parent, presentation);
    // Ensure that calling execute clears the presentation without throwing exceptions
    assertDoesNotThrow(() -> newCommand.execute());
  }

  @Test
  public void testSaveCommand() {
    Presentation presentation = new Presentation();
    Frame parent = new Frame();
    Command saveCommand = new SaveCommand(parent, presentation);
    assertEquals(null, saveCommand.getName());
  }

  @Test
  public void testExecuteSaveCommand() {
    Presentation presentation = new Presentation();
    Frame parent = new Frame();
    Command saveCommand = new SaveCommand(parent, presentation);
    // Ensure that calling execute saves the presentation without throwing exceptions
    assertDoesNotThrow(() -> saveCommand.execute());
  }
}
