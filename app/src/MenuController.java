import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.JOptionPane;

public class MenuController extends MenuBar {
	private Frame parent;
	private Presentation presentation;

	public MenuController(Frame frame, Presentation pres) {
		parent = frame;
		presentation = pres;

		Menu fileMenu = new Menu("File");
		Menu viewMenu = new Menu("View");
		Menu helpMenu = new Menu("Help");

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

		MenuItem nextItem = new MenuItem("Next", new MenuShortcut('N'));
		viewMenu.add(nextItem);

		MenuItem prevItem = new MenuItem("Prev", new MenuShortcut('P'));
		viewMenu.add(prevItem);

		MenuItem gotoItem = new MenuItem("Go to", new MenuShortcut('G'));
		gotoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String pageNumberStr = JOptionPane.showInputDialog((Object)"Page number?");
				int pageNumber = Integer.parseInt(pageNumberStr);
				presentation.setSlideNumber(pageNumber - 1);
			}
		});
		viewMenu.add(gotoItem);

		MenuItem aboutItem = new MenuItem("About", new MenuShortcut('A'));
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AboutBox.show(parent);
			}
		});
		helpMenu.add(aboutItem);

		add(fileMenu);
		add(viewMenu);
		add(helpMenu);
	}

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

	private void handleNew() {
		presentation.clear();
		parent.repaint();
	}

	private void handleSave() {
		Accessor xmlAccessor = new XMLAccessor();
		try {
			xmlAccessor.saveFile(presentation, "dump.xml");
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(parent, "IO Exception: " + exc, "Save Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void handleExit() {
		presentation.exit(0);
	}
}
