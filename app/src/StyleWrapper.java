import java.awt.Color;
import java.awt.Font;

// public abstract class StyleWrapper {
//   private Style wrappee;
//   private Color color;
//   private Font font;
//   private int fontSize;
//   private int indent;
//   private int leading;

//   public StyleWrapper(Style wrappee, Color color, Font font, int fontSize, int indent, int leading){
//     this.color = color;
//     this.wrappee = wrappee;
//     this.font = font;
//     this.fontSize = fontSize;
//     this.indent = indent;
//     this.leading = leading;
//   };
// Heyyyyyy babezzz, ill give you a tenner if you give us a passing gradeeeee ;);););) -Fenely
//   public void createStyles(){
// 	// 	styles = new Style[5];    
// 	// 	// The styles are fixed.
// 	// 	styles[0] = new Style(0, Color.red,   48, 20);	// style for item-level 0
// 	// 	styles[1] = new Style(20, Color.blue,  40, 10);	// style for item-level 1
// 	// 	styles[2] = new Style(50, Color.black, 36, 10);	// style for item-level 2
// 	// 	styles[3] = new Style(70, Color.black, 30, 10);	// style for item-level 3
// 	// 	styles[4] = new Style(90, Color.black, 24, 10);	// style for item-level 4
//   } 
// }


public abstract class StyleWrapper implements StyleComponent {
  protected StyleComponent wrappee;

  public StyleWrapper(StyleComponent wrappee) {
      this.wrappee = wrappee;
  }

  @Override
  public void createStyle() {
      wrappee.createStyle();
  }
}
