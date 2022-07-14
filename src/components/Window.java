package components;

import javax.swing.JFrame;

public class Window implements Runnable, WindowSpecification {
	private JFrame mainFrame;
	public Window(String windowName) {
		mainFrame = createNewFrame(windowName);
	}
	private JFrame createNewFrame(String name) {
		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}
	@Override
	public void run() {
		loadMenu();
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	private void loadMenu() {
		MainMenu menu = new MainMenu(mainFrame);
		menu.show();
	}
}
