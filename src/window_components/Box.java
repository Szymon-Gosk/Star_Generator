package window_components;

public abstract class Box extends WindowComponent{

	private static final long serialVersionUID = -6082620832482427066L;
	
	private boolean selected;
	
	public Box() {
		this.setSelected(false);
		this.setOpaque(true);
	}
	
	public Box(int x, int y) {
		this.setLocation(x, y);
		this.setSelected(false);
		this.setOpaque(true);
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
