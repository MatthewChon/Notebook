import javax.swing.SwingUtilities;

import components.Window;

public class Application {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Window("Notebook"));
	}

}
