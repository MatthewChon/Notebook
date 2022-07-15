package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class MainMenu implements WindowSpecification, MouseListener {
	private JFrame window;
	private JPanel panel;
	private Map<String, File> contentTable;
	private File contentFile;
	private File mainDir;
	public MainMenu(JFrame frame) {
		window = frame;
		panel = createNewPanel();
		contentTable = new HashMap<>();
		mainDir = new File(dataPath);
		if (!mainDir.exists()) {
			mainDir.mkdir();
			
		}
		contentFile = new File(mainDir.getName() + "/menu.txt");
		if (!contentFile.exists()) {
			try {
				contentFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private JPanel createNewPanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(WINDOW_SIZE);
		window.addMouseListener(this);
		return panel;
	}
	public void show() {
		window.add(panel);
	}
	public void close() {
		window.remove(panel);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			loadPopupMenu(e);
		}
	}
	private void loadPopupMenu(MouseEvent e) {
		JPopupMenu popup = createPopup();
		popup.show(e.getComponent(),e.getX(), e.getY());
	}
	private JPopupMenu createPopup() {
		JPopupMenu menu = new JPopupMenu();
		addFunctionality(menu);
		return menu;
	}
	private void addFunctionality(JPopupMenu menu) {
		menu.add(addItemButton());
		menu.add(removeItemButton());
	}
	private JMenuItem addItemButton() {
		JMenuItem addItem = new JMenuItem("Add new subject");
		addItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String subject = JOptionPane.showInputDialog("Enter subject name: ");
				File subjectDir = new File(mainDir.getName() + "/" + subject);
				if (contentTable.containsKey(subject)) {
					JOptionPane.showMessageDialog(null, subject + " already existed");
				} else {
					subjectDir.mkdir();
					contentTable.put(subject, subjectDir);
				}
			}	
		});
		return addItem;
	}
	private JMenuItem removeItemButton() {
		JMenuItem removeItem = new JMenuItem("Remove subject");
		return removeItem;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
