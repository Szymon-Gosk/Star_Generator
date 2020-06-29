package windows;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import coordination.Coordinator;
import window_components.Button;
import window_components.TextField;

public class SaveWindow {

	private JFrame frame;
	private Coordinator coordinator;
	
	public SaveWindow(Coordinator coordinator) {
		initialize();
		this.coordinator = coordinator;
	}

	private void initialize() {
		frame = new JFrame("Save");
		frame.setBounds(100, 100, 236, 175);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.BLACK);
		
		TextField field = new TextField(15, 10, "Insert name");
		int[] keys = new int[59];
		for(int i = 65 ; i <= 122 ; i++) {
			keys[i-65] = i;
		}
		keys[58] = 45;
		field.addToRange(keys);
		frame.getContentPane().add(field);
		
		Button button = new Button(15, 85, 201, "Save");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public final void mouseClicked(MouseEvent event) {
				if(!coordinator.isSaved() && coordinator.getCurrentStar() != null) {
					if(!field.isEmpty()) {
						coordinator.getCurrentStar().setName(field.getFieldText());
					}
					coordinator.getFileManager().saveStar(coordinator.getCurrentStar());
					coordinator.setSaved(true);
					coordinator.addSave(coordinator.getCurrentStar());
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(button);
		
	}
	
	public void setVisible() {
		frame.setVisible(true);
	}
	
}
