import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.HashMap;
import java.util.Map;

public class KeyController extends KeyAdapter {
	private Presentation presentation;

	public KeyController(Presentation p) {
		presentation = p;
	}

	private Map<Integer, Command> keyBindings = new HashMap<>();

	public void addKeyBinding(int keyCode, Command command) {
		keyBindings.put(keyCode, command);
	}

	public void keyPressed(KeyEvent keyEvent) {
		Command command = keyBindings.get(keyEvent.getKeyCode());
		if (command != null) {
			command.execute();
		}
	}
}
