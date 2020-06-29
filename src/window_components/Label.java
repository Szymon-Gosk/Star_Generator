package window_components;

import java.awt.Font;

public class Label extends WindowComponent{

	private static final long serialVersionUID = -98589921676699062L;
	
	public Label(int x, int y, int width, int horizontalAlignment) {
		this.setBounds(x, y, width, 40);
		this.setForeground(WHITE);
		this.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		this.setHorizontalAlignment(horizontalAlignment);
	}

}
