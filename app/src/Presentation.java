import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Presentation implements SlideComponent {
    private String showTitle;
    private ArrayList<Slide> showList = null;
    private int currentSlideNumber = 0;
    private SlideViewerComponent slideViewComponent = null;
    private Map<String, Style> styles = new HashMap<>();

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

    public int getSlideNumber() {
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
        }
        else if(currentSlideNumber == (showList.size()) - 1){
            setSlideNumber(currentSlideNumber);
        }
    }

    void clear() {
        showList = new ArrayList<Slide>();
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
        styles.put(name, style);
    }

    public Style getStyle(String name) {
        return styles.get(name);
    }
}
