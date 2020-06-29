package window_components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import coordination.Coordinator;
import objects.Star;

public class ElementList extends JScrollPane{

	private static final long serialVersionUID = -7005038387963975243L;
	
	private int WIDTH = 250;
	private int height;
	
	private JPanel panel;
	
	private BoxFamily family;
	
	LinkedList<Element> elements;

	public ElementList(int x, int y) {
		super(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.setBounds(x, y, 252, 240);
		this.setBorder(BorderFactory.createLineBorder(new Color(95, 95, 95)));
		
		elements = new LinkedList<>();
		
		height = 0;
		family = new BoxFamily(false);
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension(WIDTH, height));
		this.add(panel);
		this.setViewportView(panel);
		
	}
	
	public void addElement(Element element) {
		elements.add(element);
		family.add(element);
		panel.add(element);
		height += 40;
		panel.setPreferredSize(new Dimension(WIDTH, height));
	}
	
	public void fill(Star[] stars, Coordinator coordinator) {
		for(int i = 0 ; i < stars.length ; i++) {
			addElement(new Element(stars[i], coordinator.getFileManager().getSmallIcon(stars[i].getStarClass(), stars[i].getImageNumber())));
		}
	}
	
	public int getSelectedIndex() {
		int i = 0;
		int index = -1;
		for(Box b : family.getAll()) {
			if(b.isSelected()) {
				index = i;
			}
			i++;
		}
		return index;
	}
	
	public Star getSelectedStar() {
		Star star = null;
		int index = getSelectedIndex();
		if(index != -1) {
			star = elements.get(index).getStar();
		}
		return star;
	}
	
	public void removeStar() {
		int index = getSelectedIndex();
		if(index != -1) {
			elements.remove(index);
			family.remove(index);
			panel.remove(index);
			this.revalidate();
			this.repaint();
			height -= 40;
			panel.setPreferredSize(new Dimension(WIDTH, height));
		}
	}
	
}
