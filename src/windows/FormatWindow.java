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
import window_components.TextField;

public class FormatWindow {

	private JFrame frame;
	private Coordinator coordinator;
	
	public FormatWindow(Coordinator coordinator) {
		initialize();
		this.coordinator = coordinator;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 425, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Label decimal = new Label(10, 10, 201, JLabel.CENTER);
		decimal.setText("Decimal places:");
		frame.getContentPane().add(decimal);

		TextField radDpField = new TextField(10, 50, "Radius");
		frame.getContentPane().add(radDpField);

		TextField massDpField = new TextField(10, 100, "Mass");
		frame.getContentPane().add(massDpField);

		TextField ageDpField = new TextField(10, 150, "Age");
		frame.getContentPane().add(ageDpField);

		Label unit = new Label(221, 10, 201, JLabel.CENTER);
		unit.setText("Units:");
		frame.getContentPane().add(unit);

		TextBox SI = new TextBox(255, 55, "SI");
		TextBox star = new TextBox(255, 105, "Relative to Sun");

		BoxFamily family = new BoxFamily(true);
		family.add(SI);
		family.add(star);

		frame.getContentPane().add(SI);
		frame.getContentPane().add(star);

		Button zatwierdz = new Button(10, 220, 201, "Confirm");
		zatwierdz.addMouseListener(new MouseAdapter() {
			@Override
			public final void mouseClicked(MouseEvent event) {
				// decimal points
				boolean anyInserted = false;
				if(!"".equals(radDpField.getFieldText())) {
					coordinator.setRadiusDP(Integer.parseInt(radDpField.getFieldText()));
					coordinator.redrawStart();
					anyInserted = true;
				}
				if(!"".equals(massDpField.getFieldText())) {
					coordinator.setMassDP(Integer.parseInt(massDpField.getFieldText()));
					coordinator.redrawStart();
					anyInserted = true;
				}
				if(!"".equals(ageDpField.getFieldText())) {
					coordinator.setAgeDP(Integer.parseInt(ageDpField.getFieldText()));
					coordinator.redrawStart();
					anyInserted = true;
				}
				// units
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
								coordinator.showInSI(true);
								coordinator.changeUnitsToSI(true);
							} else {
								coordinator.showInSI(false);
								coordinator.changeUnitsToSI(false);
							}
							coordinator.redrawStart();
						}
						i++;
					}
				}
				if(anySelected || anyInserted) {
					frame.setVisible(false);
					frame.dispose();
				}
				//save changes
				coordinator.getFileManager().saveOptions(coordinator.getRadiusDP(), coordinator.getMassDP(), coordinator.getAgeDP(),
						coordinator.isShownInSI(), coordinator.isDistributionIncluded());
			}
		});
		frame.getContentPane().add(zatwierdz);
		
	}
	
	public void setVisible() {
		frame.setVisible(true);
	}

}
