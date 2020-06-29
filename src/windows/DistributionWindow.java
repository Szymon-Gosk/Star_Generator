package windows;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import coordination.Coordinator;
import window_components.Box;
import window_components.BoxFamily;
import window_components.Button;
import window_components.Label;
import window_components.TextBox;

public class DistributionWindow {

	private JFrame frame;
	private Coordinator coordinator;
	
	public DistributionWindow(Coordinator coordinator) {
		initialize();
		this.coordinator = coordinator;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 585, 225);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		TextBox include = new TextBox(15, 15, "Include");
		TextBox dontInclude = new TextBox(15, 70, "Do not include");

		BoxFamily family = new BoxFamily(true);
		family.add(include);
		family.add(dontInclude);

		frame.getContentPane().add(include);
		frame.getContentPane().add(dontInclude);

		Label label = new Label(180, 20, 400, JLabel.CENTER);
		label.setText("By including the distribution of the stars");
		frame.getContentPane().add(label);

		Label label2 = new Label(180, 45, 400, JLabel.CENTER);
		label2.setText("you increase the probability");
		frame.getContentPane().add(label2);

		Label label3 = new Label(180, 70, 400, JLabel.CENTER);
		label3.setText("of generating stars which occur more often");
		frame.getContentPane().add(label3);
		
		Label warning = new Label(180, 140, 400, JLabel.CENTER);
		warning.setForeground(new Color(247, 72, 87));
		frame.getContentPane().add(warning);
		
		Button zapisz = new Button(15, 140, 150, "Save");
		zapisz.addMouseListener(new MouseAdapter( ) {
			@Override
			public final void mouseClicked(MouseEvent event) {
				boolean anySelected = false;
				for(Box b : family.getAll()) {
					if(b.isSelected()) {
						anySelected = true;
					}
				}
				if(anySelected) {
					int i = 0;
					for(Box b : family.getAll()) {
						if(b.isSelected()) {
							if(i == 0) {
								coordinator.includeStandardDistribution(true);
							} else {
								coordinator.includeStandardDistribution(false);
							}
							frame.setVisible(false);
							frame.dispose();
						}
						i++;
					}
					coordinator.getFileManager().saveOptions(coordinator.isDistributionIncluded());
				} else {
					warning.setText("No option chosen!");
				}
			}
		});
		frame.getContentPane().add(zapisz);
		
	}
	
	public void setVisible() {
		frame.setVisible(true);
	}

}
