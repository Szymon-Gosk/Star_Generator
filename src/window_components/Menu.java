package window_components;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JLabel;

public class Menu extends WindowComponent{

	private static final long serialVersionUID = -7529152390984072502L;
	
	public static final int HEIGHT = 25;

	private LinkedList<Button> options;
	
	private int nextX;
	
	public Menu(int width) {
		this.setBounds(0, 0, width, HEIGHT);
		nextX = 0;
		options = new LinkedList<>();
		this.setBackground(MEDIUM_GREY);
		this.setOpaque(true);
	}
	
	public void addOption(int width, String title) {
		if(options.isEmpty()) {
			options.add(new Button(0, 0, width, title));
			options.get(0).setBounds(0, 0, width, HEIGHT);
			options.get(0).setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
			options.get(0).setForeground(DARK_WHITE);
			nextX = width;
		} else {
			options.add(new Button(nextX, 0, width, title));
			options.getLast().setBounds(nextX, 0, width, HEIGHT);
			options.getLast().setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
			options.getLast().setForeground(DARK_WHITE);
			nextX += width;
		}
		options.getLast().setBackground(MEDIUM_GREY);
		options.getLast().addMouseListener(new MouseAdapter() {
			@Override
			public final void mouseExited(MouseEvent event) {
				((JLabel) event.getSource()).setBackground(MEDIUM_GREY);
			}
		});
		this.add(options.getLast());
	}
	
	public Button getOption(String title) {
		int index = 0;
		for(Button button : options) {
			if(title.equals(button.getText())) {
				return options.get(index);
			}
			index++;
		}
		return null;
	}
	
}
