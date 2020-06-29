package window_components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import objects.Star;

public class Element extends Box{

	private static final long serialVersionUID = 3069233106966443509L;
	
	public static final int WIDTH = 250;
	public static final int HEIGHT = 40;
	
	private Star star;
	
	private JLabel icon;
	private Label name;
	
	public Element(Star star, ImageIcon imageIcon) {
		this.star = star;
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(new Color(30, 30, 30));
		this.setOpaque(true);
		
		icon = new JLabel();
		icon.setIcon(imageIcon);
		icon.setBounds(5, 5, 30, 30);
		this.add(icon);
		
		name = new Label(50, 0, 150, JLabel.LEFT);
		name.setText(star.getName());
		this.add(name);
		
	}
	
	public Star getStar() {
		return star;
	}
	
}
