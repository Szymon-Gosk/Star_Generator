package window_components;

import java.awt.Font;

import javax.swing.SwingConstants;

public class TextBox extends Box{

	private static final long serialVersionUID = 308829704955885160L;
	
	public static final int WIDTH = 150;
	public static final int HEIGHT = 40;

	public TextBox(int x, int y, String text) {
		super(x, y);
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(MEDIUM_GREY);
		this.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		this.setForeground(WHITE);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setText(text);
	}

}
