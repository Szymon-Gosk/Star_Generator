package window_components;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Button extends WindowComponent{

	private static final long serialVersionUID = 9029316535089588266L;
	
	public static final int HEIGHT = 40;

	private Timer timer;
	
	public Button(int x, int y, int width, String text) {
		this.setBounds(x, y, width, HEIGHT);
		this.setBackground(DARK_BACKGROUND);
		this.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		this.setForeground(WHITE);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setText(text);
		this.setOpaque(true);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public final void mouseClicked(MouseEvent event) {
				((JLabel) event.getSource()).setBackground(DARK_CLICKED);
				timer = new Timer();
				timer.schedule(new TimerTask() {
					public void run() {
						((JLabel) event.getSource()).setBackground(DARK_ENTERED);
						timer.cancel();
					}
			     }, 60);
			}
			@Override
			public final void mouseEntered(MouseEvent event) {
				((JLabel) event.getSource()).setBackground(DARK_ENTERED);
			}
			@Override
			public final void mouseExited(MouseEvent event) {
				((JLabel) event.getSource()).setBackground(DARK_BACKGROUND);
			}
		});
	}
	
}
