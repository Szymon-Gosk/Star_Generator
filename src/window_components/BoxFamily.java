package window_components;

import java.util.LinkedList;

public class BoxFamily {
	
	private boolean multiSelectable;

	private LinkedList<Box> list;
	
	private BoxAdapter adapter;
	
	public BoxFamily(boolean multiSelectable) {
		list = new LinkedList<>();
		this.multiSelectable = multiSelectable;
		adapter = new BoxAdapter(multiSelectable);
	}
	
	public void add(Box box) {
		box.addMouseListener(adapter);
		list.add(box);
	}
	
	public void addTemporarily(Box box) {
		list.add(box);
	}
	
	public void remove(int index) {
		list.get(index).removeMouseListener(adapter);
		list.remove(index);
	}
	
	public Box get(int index) {
		return list.get(index);
	}
	
	public LinkedList<Box> getAll() {
		return list;
	}

	public int size() {
		return list.size();
	}
	
	public boolean isMultiSelectable() {
		return multiSelectable;
	}
}
