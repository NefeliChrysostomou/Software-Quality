import java.awt.*;
import javax.swing.JOptionPane;

/** MenuController class manages the menu bar functionality of the application.
 * It provides methods to handle menu actions such as opening, saving, and exiting.
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 2024/04/07 Nefeli Chrysostomou and Marijn Veenstra
 */
public class MenuController extends MenuBar {
  private final Frame PARENT;
  private final Presentation PRESENTATION;

  /**
   * Constructor for MenuController.
   * The frame on which the menu bar will be displayed
   * The presentation represents the object being controlled
   */
  public MenuController(Frame frame, Presentation pres) {
    PARENT = frame;
    PRESENTATION = pres;

    // Create File menu
    Menu fileMenu = new Menu("File");
    Menu viewMenu = new Menu("View");
    Menu helpMenu = new Menu("Help");

    // Add menu items to File menu
    MenuItem openItem = new MenuItem("Open", new MenuShortcut('O'));
    openItem.addActionListener(e -> {
      OpenCommand openCommand = new OpenCommand(PARENT, PRESENTATION);
      openCommand.execute();
    });
    fileMenu.add(openItem);

    MenuItem newItem = new MenuItem("New", new MenuShortcut('M'));
    newItem.addActionListener(e -> {
      NewCommand newCommand = new NewCommand(PARENT, PRESENTATION);
      newCommand.execute();
    });
    fileMenu.add(newItem);

    MenuItem saveItem = new MenuItem("Save", new MenuShortcut('S'));
    saveItem.addActionListener(e -> {
      SaveCommand saveCommand = new SaveCommand(PARENT, PRESENTATION);
      saveCommand.execute();
    });
    fileMenu.add(saveItem);

    fileMenu.addSeparator();

    MenuItem exitItem = new MenuItem("Exit", new MenuShortcut('X'));
    exitItem.addActionListener(e -> {
      ExitCommand exitCommand = new ExitCommand(PRESENTATION);
      exitCommand.execute();
    });
    fileMenu.add(exitItem);

    // Add menu items to View menu
    MenuItem nextItem = new MenuItem("Next", new MenuShortcut('N'));
    nextItem.addActionListener(e -> {
      NextSlideCommand nextSlide = new NextSlideCommand(PRESENTATION);
      nextSlide.execute();
    });
    viewMenu.add(nextItem);

    MenuItem prevItem = new MenuItem("Prev", new MenuShortcut('P'));
    prevItem.addActionListener(e -> {
      PrevSlideCommand prevSlide = new PrevSlideCommand(PRESENTATION);
      prevSlide.execute();
    });
    viewMenu.add(prevItem);

    MenuItem gotoItem = new MenuItem("Go to", new MenuShortcut('G'));
    gotoItem.addActionListener(actionEvent -> {
      String pageNumberStr = JOptionPane.showInputDialog("Page number?");
      int pageNumber = Integer.parseInt(pageNumberStr);
      //Makes sure you can't go to a slide that does not exist
      if(0 < pageNumber && pageNumber <= PRESENTATION.getSize()) {
        PRESENTATION.setSlideNumber(pageNumber - 1);
      }
    });
    viewMenu.add(gotoItem);

    // Add menu items to Help menu
    MenuItem aboutItem = new MenuItem("About", new MenuShortcut('A'));
    aboutItem.addActionListener(actionEvent -> AboutBox.show(PARENT));
    helpMenu.add(aboutItem);

    // Add menus to MenuController
    add(fileMenu);
    add(viewMenu);
    add(helpMenu);
  }

  /**
   * Binds a command to a menu item.
   * The command parameter is the one which will be executed when the menu item is selected.
   * The actionCommand parameter is the command associated with the menu item.
   */
  public void bindCommand(Command command, String actionCommand) {
    MenuItem menuItem = findMenuItem(actionCommand);
    if (menuItem != null) {
      menuItem.addActionListener(e -> command.execute());
    } else {
      System.err.println("Menu item for action command " + actionCommand + " not found.");
    }
  }

  /**
   * Finds a menu item by its action command.
   * The actionCommand is the command of the menu item to find.
   * The MenuItem object corresponding to the action command, or null if not found.
   */
  private MenuItem findMenuItem(String actionCommand) {
    for (int i = 0; i < getMenuCount(); i++) {
      Menu menu = getMenu(i);
      for (int j = 0; j < menu.getItemCount(); j++) {
        MenuItem item = menu.getItem(j);
        if (item.getActionCommand().equals(actionCommand)) {
          return item;
        }
      }
    }
    return null;
  }
}
