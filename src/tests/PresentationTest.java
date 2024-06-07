package Decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Accessors.Accessor;
import Accessors.DemoPresentation;
import Accessors.XMLAccessor;
import Decorator.ColorStyleDecorator;
import Decorator.ConcreteStyle;
import Decorator.FontSizeStyleDecorator;
import Decorator.FontStyleDecorator;
import Decorator.IndentStyleDecorator;
import Decorator.Style;
import Decorator.StyleComponent;
import Decorator.StyleWrapper;
import Jabberpoint.JabberPoint;
import Presentation.Command.AboutBox;
import Presentation.Command.Command;
import Presentation.Command.ExitCommand;
import Presentation.Command.KeyController;
import Presentation.Command.MenuController;
import Presentation.Command.NewCommand;
import Presentation.Command.NextSlideCommand;
import Presentation.Command.OpenCommand;
import Presentation.Command.PrevSlideCommand;
import Presentation.Command.Receiver;
import Presentation.Command.SaveCommand;
import Presentation.Composite.SlideComponent;
import Presentation.Composite.Slide;
import Presentation.Presentation;
import Presentation.BitmapItem;
import Presentation.SlideItem;
import Presentation.SlideViewerComponent;
import Presentation.SlideViewerFrame;
import Presentation.TextItem;

public class PresentationTest {

  // Test adding components
  @Test
  public void testAddingComponents() {
    Presentation presentation = new Presentation();
    Slide slide1 = new Slide();
    Slide slide2 = new Slide();
    presentation.append(slide1);
    presentation.append(slide2);
    assertEquals(2, presentation.getSize());
  }

  // Test slide navigation
  @Test
  public void testSlideNavigation() {
    Presentation presentation = new Presentation();
    Slide slide1 = new Slide();
    Slide slide2 = new Slide();
    presentation.append(slide1);
    presentation.append(slide2);
    assertNotNull(presentation.getSlide(0));
    assertNotNull(presentation.getSlide(1));
  }

  // Test manipulation
  @Test
  public void testManipulation() {
    Presentation presentation = new Presentation();
    Slide slide1 = new Slide();
    Slide slide2 = new Slide();
    presentation.append(slide1);
    presentation.append(slide2);
    slide1.setTitle("Slide 1");
    assertEquals("Slide 1", slide1.getTitle());
  }

  // Test behavioral consistency
  @Test
  public void testNextSlide() {
    // Arrange: Prepare the presentation and slides
    Presentation presentation = new Presentation();
    Slide slide1 = new Slide();
    Slide slide2 = new Slide();
    presentation.append(slide1);
    presentation.append(slide2);

    // Act: Move to the next slide
    presentation.nextSlide();

    // Assert: Check if the current slide number is incremented
    assertEquals(1, presentation.getSlideNumber());
  }

  @Test
  public void testPrevSlide() {
    // Arrange: Prepare the presentation and slides
    Presentation presentation = new Presentation();
    Slide slide1 = new Slide();
    Slide slide2 = new Slide();
    presentation.append(slide1);
    presentation.append(slide2);

    // Act: Move to the next slide and then back to the previous slide
    presentation.nextSlide();
    presentation.prevSlide();

    // Assert: Check if the current slide number is decremented back to the initial value
    assertEquals(0, presentation.getSlideNumber());
  }

  // Test boundary conditions
  @Test
  public void testBoundaryConditions() {
    // Arrange: Prepare the presentation and a slide
    Presentation presentation = new Presentation();
    Slide slide = new Slide();
    presentation.append(slide);

    // Assert: Check if accessing slides with negative and out-of-bound slide numbers returns null
    assertNull(presentation.getSlide(-1)); // Negative slide number
    assertNull(presentation.getSlide(1));  // Out-of-bound slide number
  }
}
