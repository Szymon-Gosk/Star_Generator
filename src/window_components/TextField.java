package window_components;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextField extends WindowComponent{

	private static final long serialVersionUID = -7417541417042555929L;
	
	public static final int WIDTH = 201;
	public static final int HEIGHT = 50;
	
	private LinkedList<Integer> range;
	
	private boolean inserted;
	
	private JTextField field;
	
	private JLabel line;
	private JLabel hint;
	
	public TextField(int x, int y, String hintText) {
		this.setBounds(x, y, WIDTH, HEIGHT);
		inserted = false;
		
		range = new LinkedList<>();
		for(int i = 48 ; i <= 57 ; i++) {
			range.add(i);
		}
		range.add(KeyEvent.VK_BACK_SPACE);
		range.add(KeyEvent.VK_DELETE);
		
		line = new JLabel();
		line.setBounds(4, 46, 195, 1);
		line.setBackground(LIGHT_CLICKED);
		line.setOpaque(true);
		
		hint = new JLabel();
		hint.setBounds(4, 20, 194, 25);
		hint.setForeground(LIGHT_CLICKED);
		hint.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		hint.setText(hintText);
		
		field = new JTextField("");
		field.setBounds(4, 20, 194, 25);
		field.setForeground(WHITE);
		field.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		field.setOpaque(false);
		field.setBorder(null);
		field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				if(isInRange(event.getKeyChar())) {
					if(field.getText().length() == 0) {
						if(!inserted && !(event.getKeyChar() == KeyEvent.VK_BACK_SPACE)
								&& !(event.getKeyChar() == KeyEvent.VK_DELETE)) {
							hint.setText(null);
							inserted = true;
						} else if (inserted) {
							inserted = false;
							hint.setText(hintText);
						}
					} 
				} else {
					event.consume();
				}
		    } 
		});
		
		this.add(line);
		this.add(field);
		this.add(hint);
	}
	
	public void addToRange(char c) {
		range.add((int) c);
	}
	
	public void addToRange(int i) {
		range.add(i);
	}
	
	public void addToRange(int[] i) {
		for(int n : i) {
			range.add(n);
		}
	}
	
	public String getFieldText() {
		return field.getText();	
	}
	
	public boolean isEmpty() {
		return (field.getText().length() == 0);
		
	}
	
	private boolean isInRange(char c) {
		for(int i : range) {
			if(i == c) {
				return true;
			}
		}
		return false;
	}

}
