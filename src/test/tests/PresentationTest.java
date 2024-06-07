import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Presentation.Composite.Slide;
import Presentation.Presentation;

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
    presentation.setSlideNumber(0);
    // Act: Move to the next slide
    presentation.nextSlide();
    presentation.getCurrentSlideNumber();
    // Assert: Check if the current slide number is incremented
    assertEquals(1, presentation.getCurrentSlideNumber());
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
    assertEquals(0, presentation.getCurrentSlideNumber());
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
