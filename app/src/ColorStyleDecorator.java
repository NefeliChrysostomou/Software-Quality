import java.awt.Color;

public class ColorStyleDecorator extends StyleWrapper {
    private Color newColor;

    public ColorStyleDecorator(StyleComponent wrappee, Color newColor) {
        super(wrappee);
        this.newColor = newColor;
    }

    @Override
    public void createStyle() {
        super.createStyle();
        Style baseStyle = ((ConcreteStyle) wrappee).getStyle();
        baseStyle.setColor(newColor);
    }
}
