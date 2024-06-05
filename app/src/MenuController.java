import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
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
  private Frame parent;
  private Presentation presentation;

  /**
   * Constructor for MenuController.
   *
   * The frame on which the menu bar will be displayed
   * The presentation represents the object being controlled
   */
  public MenuController(Frame frame, Presentation pres) {
    parent = frame;
    presentation = pres;

    // Create File menu
    Menu fileMenu = new Menu("File");
    Menu viewMenu = new Menu("View");
    Menu helpMenu = new Menu("Help");

    // Add menu items to File menu
    MenuItem openItem = new MenuItem("Open", new MenuShortcut('O'));
    openItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handleOpen();
      }
    });
    fileMenu.add(openItem);

    MenuItem newItem = new MenuItem("New", new MenuShortcut('N'));
    newItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handleNew();
      }
    });
    fileMenu.add(newItem);

    MenuItem saveItem = new MenuItem("Save", new MenuShortcut('S'));
    saveItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handleSave();
      }
    });
    fileMenu.add(saveItem);

    fileMenu.addSeparator();

    MenuItem exitItem = new MenuItem("Exit", new MenuShortcut('X'));
    exitItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handleExit();
      }
    });
    fileMenu.add(exitItem);

    // Add menu items to View menu
    MenuItem nextItem = new MenuItem("Next", new MenuShortcut('N'));
    nextItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        presentation.nextSlide();
      }
    });
    viewMenu.add(nextItem);

    MenuItem prevItem = new MenuItem("Prev", new MenuShortcut('P'));
    prevItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        presentation.prevSlide();
      }
    });
    viewMenu.add(prevItem);

    MenuItem gotoItem = new MenuItem("Go to", new MenuShortcut('G'));
    gotoItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        String pageNumberStr = JOptionPane.showInputDialog((Object)"Page number?");
        int pageNumber = Integer.parseInt(pageNumberStr);
        //Makes sure you can't go to a slide that does not exist
        if(pageNumber < presentation.getSize()) {
          presentation.setSlideNumber(pageNumber - 1);
        }
      }
    });
    viewMenu.add(gotoItem);

    // Add menu items to Help menu
    MenuItem aboutItem = new MenuItem("About", new MenuShortcut('A'));
    aboutItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AboutBox.show(parent);
      }
    });
    helpMenu.add(aboutItem);

    // Add menus to MenuController
    add(fileMenu);
    add(viewMenu);
    add(helpMenu);
  }

  /**
   * Binds a command to a menu item.
   *
   * The command parameter is the one which will be executed when the menu item is selected.
   * The actionCommand parameter is the command associated with the menu item.
   */
  public void bindCommand(Command command, String actionCommand) {
    MenuItem menuItem = findMenuItem(actionCommand);
    if (menuItem != null) {
      menuItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          command.execute();
        }
      });
    } else {
      System.err.println("Menu item for action command " + actionCommand + " not found.");
    }
  }

  /**
   * Finds a menu item by its action command.
   *
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

  //Handles the "Open" action by loading a presentation from a file
  private void handleOpen() {
    presentation.clear();
    Accessor xmlAccessor = new XMLAccessor();
    try {
      xmlAccessor.loadFile(presentation, "test.xml");
      presentation.setSlideNumber(0);
    } catch (IOException exc) {
      JOptionPane.showMessageDialog(parent, "IO Exception: " + exc, "Load Error", JOptionPane.ERROR_MESSAGE);
    }
    parent.repaint();
  }

  // Handles the "New" action by clearing the current presentation
  private void handleNew() {
    presentation.clear();
    parent.repaint();
  }

   //Handles the "Save" action by saving the presentation to a file
  private void handleSave() {
    Accessor xmlAccessor = new XMLAccessor();
    try {
      xmlAccessor.saveFile(presentation, "dump.xml");
    } catch (IOException exc) {
      JOptionPane.showMessageDialog(parent, "IO Exception: " + exc, "Save Error", JOptionPane.ERROR_MESSAGE);
    }
  }

   //Handles the "Exit" action by exiting the application
  private void handleExit() {
    presentation.exit(0);
  }
}
