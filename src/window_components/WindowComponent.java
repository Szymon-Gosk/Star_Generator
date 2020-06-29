package window_components;

import java.awt.Color;

import javax.swing.JLabel;

public abstract class WindowComponent extends JLabel{

	private static final long serialVersionUID = -8055891518872604773L;
	
	public static final Color WHITE = new Color(255, 255, 255);
	public static final Color DARK_WHITE = new Color(200, 200, 200);
	
	public static final Color DARK_GREY = new Color(38, 38, 38);
	public static final Color MEDIUM_GREY = new Color(45, 45, 45);
	public static final Color LIGHT_GREY = new Color(68, 68, 68);
	
	public static final Color DARK_BACKGROUND = new Color(30, 30, 30);
	public static final Color DARK_ENTERED = new Color(54, 54, 54);
	public static final Color DARK_CLICKED = new Color(71, 71, 71);
	
	public static final Color LIGHT_BACKGROUND = new Color(54, 54, 54);
	public static final Color LIGHT_ENTERED = new Color(71, 71, 71);
	public static final Color LIGHT_CLICKED = new Color(105, 105, 105);

}
