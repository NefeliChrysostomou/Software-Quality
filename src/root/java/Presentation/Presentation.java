package Presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Decorator.Style;
import Presentation.Command.Command;
import Presentation.Command.Receiver;
import Presentation.Composite.SlideComponent;
import Presentation.Composite.Slide;

/**@author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */

public class Presentation extends Receiver implements SlideComponent {
  private String showTitle;
  private ArrayList<Slide> showList = null;
  private int currentSlideNumber = 0;
  private SlideViewerComponent slideViewComponent;
  private final Map<String, Style> STYLES = new HashMap<>();

  public Presentation() {
    slideViewComponent = null;
    clear();
  }

  public Presentation(SlideViewerComponent slideViewerComponent) {
    this.slideViewComponent = slideViewerComponent;
    clear();
  }

  public int getSize() {
    return showList.size();
  }

  public String getTitle() {
    return showTitle;
  }

  public void setTitle(String nt) {
    showTitle = nt;
  }

  public void setShowView(SlideViewerComponent slideViewerComponent) {
    this.slideViewComponent = slideViewerComponent;
  }

  public int getCurrentSlideNumber() {
    return currentSlideNumber;
  }

  public void setSlideNumber(int number) {
    currentSlideNumber = number;
    if (slideViewComponent != null) {
      slideViewComponent.update(this, getCurrentSlide());
    }
  }

  public void prevSlide() {
    if (currentSlideNumber > 0) {
      setSlideNumber(currentSlideNumber - 1);
    }
  }

  public void nextSlide() {
    if (currentSlideNumber < (showList.size()) - 1) {
      setSlideNumber(currentSlideNumber + 1);
    } else if (currentSlideNumber == (showList.size()) - 1) {
      setSlideNumber(currentSlideNumber);
    }
  }

  public void clear() {
    showList = new ArrayList<>();
    setSlideNumber(-1);
  }

  public Slide getSlide(int number) {
    if (number < 0 || number >= getSize()) {
      return null;
    }
    return showList.get(number);
  }

  public Slide getCurrentSlide() {
    return getSlide(currentSlideNumber);
  }

  public void exit(int n) {
    System.exit(n);
  }

  @Override
  public void append(SlideComponent slide) {
    if (slide instanceof Slide) {
      showList.add((Slide) slide);
    } else {
      throw new IllegalArgumentException("Only Slide objects can be added to the presentation.");
    }
  }

  public void addStyle(String name, Style style) {
    STYLES.put(name, style);
  }

  public Style getStyle(String name) {
    return STYLES.get(name);
  }

  @Override
  public void executeKeyCommand(Command command) {
    command.execute();
  }
}
