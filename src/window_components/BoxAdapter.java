package window_components;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoxAdapter extends MouseAdapter{

	private boolean multiSelectable;
	
	private Color backgroundColor;
	private Color enteredColor;
	private Color clickedColor;
	
	private ClickAdapter clickAdapter;
	
	private Box previouslyClicked;
	
	public BoxAdapter(boolean multiSelectable) {
		this.multiSelectable = multiSelectable;
		backgroundColor = new Color(30, 30, 30);
		enteredColor = new Color(51, 51, 51);
		clickedColor = new Color(71, 71, 71);
		clickAdapter = new BoxAdapter.ClickAdapter(this);
		previouslyClicked = null;
	}
	
	@Override
	public final void mouseClicked(MouseEvent event) {
		mouseClickedOnce(event);
		
		if(!multiSelectable) {
			if(!(previouslyClicked == null)) {
				previouslyClicked.setSelected(false);
				previouslyClicked.removeMouseListener(clickAdapter);
				previouslyClicked.addMouseListener(this);
				previouslyClicked.setBackground(backgroundColor);
			}
			previouslyClicked = ((Box) event.getSource());
		}
		
		((Box) event.getSource()).addMouseListener(clickAdapter);
		((Box) event.getSource()).removeMouseListener(this);	
	}
	
	public void mouseClickedOnce(MouseEvent event) {
		((Box) event.getSource()).setSelected(true);
		((Box) event.getSource()).setBackground(clickedColor);
	}
	
	public void mouseClickedTwice(MouseEvent event) {
		((Box) event.getSource()).setSelected(false);
		((Box) event.getSource()).setBackground(enteredColor);
	}
	
	@Override
	public void mouseEntered(MouseEvent event) {
		((Box) event.getSource()).setBackground(enteredColor);
	}
	
	@Override
	public void mouseExited(MouseEvent event) {
		((Box) event.getSource()).setBackground(backgroundColor);
	}
	
	private class ClickAdapter extends MouseAdapter {

		private BoxAdapter boxAdapter;
		
    	public ClickAdapter(BoxAdapter boxAdapter) {
    		this.boxAdapter = boxAdapter;
    	}
		
		public final void mouseClicked(MouseEvent event) {
    		mouseClickedTwice(event);
	    	
    		((Box) event.getSource()).addMouseListener(boxAdapter);
			((Box) event.getSource()).removeMouseListener(this);
			if(!multiSelectable) {
				previouslyClicked = null;
			}
		}
		
	}
	
}
