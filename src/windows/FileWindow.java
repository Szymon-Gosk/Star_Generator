package windows;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import coordination.Coordinator;
import objects.Star;
import window_components.Button;
import window_components.ElementList;

public class FileWindow {
	
	private JFrame frame;

	private Coordinator coordinator;
	
	public FileWindow(Coordinator coordinator) {
		this.coordinator = coordinator;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 305, 353);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.BLACK);

		ElementList list = new ElementList(25, 15);
		list.fill(coordinator.getSaves(), coordinator);
		frame.getContentPane().add(list);
		
		Button button = new Button(15, 270, 125, "Load");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public final void mouseClicked(MouseEvent event) {
				Star star = list.getSelectedStar();
				if(star != null) {
					coordinator.createStar(list.getSelectedStar());
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(button);
		
		Button button2 = new Button(159, 270, 125, "Delete");
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public final void mouseClicked(MouseEvent event) {
				coordinator.removeSave(list.getSelectedIndex());
				coordinator.getFileManager().removeStar(list.getSelectedIndex());
				list.removeStar();
			}
		});
		frame.getContentPane().add(button2);
		
	}
	
	public void setVisible() {
		frame.setVisible(true);
	}

}
