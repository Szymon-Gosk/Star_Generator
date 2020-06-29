package windows;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import coordination.Coordinator;
import window_components.Button;
import window_components.Label;
import window_components.Menu;

public class MainWindow {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 504, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.BLACK);
		
		Menu menu = new Menu(frame.getWidth());
		menu.addOption(90, "Save");
		menu.addOption(90, "Load");
		menu.addOption(100, "Distribution");
		menu.addOption(120, "Formatting");
		frame.getContentPane().add(menu);

		Label radius = new Label(15, 30, 125, JLabel.CENTER);
		radius.setBounds(15, 30, 125, 40);
		radius.setText("Radius [km]:");
		frame.getContentPane().add(radius);

		Label mass = new Label(15, 74, 125, JLabel.CENTER);
		mass.setLocation(15, 74);
		mass.setSize(125, 40);
		mass.setText("Mass [kg]:");
		frame.getContentPane().add(mass);

		Label temperature = new Label(15, 117, 125, JLabel.CENTER);
		temperature.setBounds(15, 117, 125, 40);
		temperature.setText("Temperature [K]:");
		frame.getContentPane().add(temperature);

		Label classX = new Label(14, 160, 125, JLabel.CENTER);
		classX.setBounds(15, 160, 125, 40);
		classX.setText("Class [A]:");
		frame.getContentPane().add(classX);

		Label age = new Label(15, 203, 125, JLabel.CENTER);
		age.setText("Age [y]:");
		frame.getContentPane().add(age);

		Label radiusN = new Label(155, 30, 125, JLabel.LEFT);
		radiusN.setText("");
		frame.getContentPane().add(radiusN);

		Label massN = new Label(155, 74, 125, JLabel.LEFT);
		massN.setText("");
		frame.getContentPane().add(massN);

		Label temperatureN = new Label(155, 117, 125, JLabel.LEFT);
		temperatureN.setText("");
		frame.getContentPane().add(temperatureN);

		Label classXN = new Label(155, 160, 125, JLabel.LEFT);
		classXN.setBounds(155, 160, 125, 40);
		classXN.setText("");
		frame.getContentPane().add(classXN);

		Label ageN = new Label(155, 203, 125, JLabel.LEFT);
		ageN.setText("");
		frame.getContentPane().add(ageN);

		JLabel image = new JLabel("");
		image.setBounds(280, 40, 203, 203);
		frame.getContentPane().add(image);

		Coordinator coordinator = new Coordinator(radiusN, massN, temperatureN, classXN, ageN, image, radius, mass);

		Button generate = new Button(15, 265, 165, "Generate");
		generate.addMouseListener(new MouseAdapter() {
			@Override
			public final void mouseClicked(MouseEvent event) {
				coordinator.createNewStar();
			}
		});
		frame.getContentPane().add(generate);

		menu.getOption("Save").addMouseListener(new MouseAdapter() {
			@Override
			public final void mouseClicked(MouseEvent event) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SaveWindow window = new SaveWindow(coordinator);
							window.setVisible();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		menu.getOption("Load").addMouseListener(new MouseAdapter() {
			@Override
			public final void mouseClicked(MouseEvent event) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FileWindow window = new FileWindow(coordinator);
							window.setVisible();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		menu.getOption("Distribution").addMouseListener(new MouseAdapter() {
			@Override
			public final void mouseClicked(MouseEvent event) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DistributionWindow window = new DistributionWindow(coordinator);
							window.setVisible();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		menu.getOption("Formatting").addMouseListener(new MouseAdapter() {
			@Override
			public final void mouseClicked(MouseEvent event) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FormatWindow window = new FormatWindow(coordinator);
							window.setVisible();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
	}
}
