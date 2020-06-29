package coordination;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import objects.Star;

public class Coordinator {
	
	private Star currentStar;
	
	private JLabel label_radius, label_mass, label_temperature, label_star_cass, label_age, label_star_image;
	
	private Format format;
	private StarGenerator generator;
	private FileManager manager;
	private SaveManager save;
	
	private int radDP, massDP, ageDP;
	
	private JLabel radiusDisplay, massDisplay;
	
	private boolean generateInKM;
	private boolean includeStandardDistribution;
	private boolean saved;
	
	public Coordinator(
			JLabel label_radius, JLabel label_mass,
			JLabel label_temperature, JLabel label_star_cass, 
			JLabel label_age, JLabel label_star_image,
			JLabel radiusDisplay, JLabel massDisplay) {
		
		this.label_radius = label_radius;
		this.label_mass = label_mass;
		this.label_temperature = label_temperature;
		this.label_star_cass = label_star_cass;
		this.label_age = label_age;
		this.label_star_image = label_star_image;
		this.radiusDisplay = radiusDisplay;
		this.massDisplay = massDisplay;
		
		format = new Format();
		generator = new StarGenerator();
		manager = new FileManager();
		save = new SaveManager(manager.loadSaves());
		
		int[] options = manager.loadOptions();
		radDP = options[0];
		massDP = options[1];
		ageDP = options[2];
		generateInKM = (options[3] == 1);
		includeStandardDistribution = (options[4] == 1);
		currentStar = null;
		
		saved = false;
		
		label_star_image.setIcon(new ImageIcon(".\\rsc\\empty.png"));
		
	}
	
	public Star[] getSaves() {
		return save.getSaves();
	}
	
	public void addSave(Star star) {
		save.addSave(star);
	}
	
	public void removeSave(int index) {
		save.removeStar(index);
	}
	
	public FileManager getFileManager() {
		return manager;
	}
	
	public void setRadiusDP(int DP) {
		radDP = DP;
	}
	
	public void setMassDP(int DP) {
		massDP = DP;
	}
	
	public void setAgeDP(int DP) {
		ageDP = DP;
	}
	
	public void showInSI(boolean SIenabled) {
		generateInKM = SIenabled;
	}
	
	public void includeStandardDistribution(boolean include) {
		includeStandardDistribution = include;
	}
	
	public int getRadiusDP() {
		return radDP;
	}
	
	public int getMassDP() {
		return massDP;
	}
	
	public int getAgeDP() {
		return ageDP;
	}
	
	public boolean isShownInSI() {
		return generateInKM;
	}
	
	public boolean isDistributionIncluded() {
		return includeStandardDistribution;
	}
	
	public boolean isSaved() {
		return saved;
	}
	
	public void setSaved(boolean saved) {
		this.saved = saved;
	}
	
	public void createNewStar() {
		currentStar = generator.generateStar(includeStandardDistribution);
		drawStar();
		saved = false;
	}
	
	public void createStar(Star star) {
		currentStar = star;
		drawStar();
		saved = false;
	}
	
	public void drawStar() {
		label_star_image.setIcon(manager.getIcon(currentStar.getStarClass(), currentStar.getImageNumber()));
		if(generateInKM) {
			label_radius.setText(format.floatingLong(currentStar.getRadiusKm(), radDP)); 
			label_mass.setText(format.exponent(currentStar.getMassKg(), massDP)); 
		} else {
			label_radius.setText(format.floating(currentStar.getRadius(), radDP)); 
			label_mass.setText(format.floating(currentStar.getMass(), massDP)); 
		}
		label_age.setText(format.exponent(currentStar.getAge(), ageDP)); 
		label_temperature.setText(format.noDecimal(currentStar.getTemperature()));
		label_star_cass.setText("<html><body style=\"font-family:Segoe UI Semilight;font-size:13px\">" + currentStar.getStarClass() + " </body></html>");
	}
	
	public void redrawStart() {
		if(currentStar != null) {
			if(generateInKM) {
				label_radius.setText(format.floatingLong(currentStar.getRadiusKm(), radDP)); 
				label_mass.setText(format.exponent(currentStar.getMassKg(), massDP)); 
			} else {
				label_radius.setText(format.floating(currentStar.getRadius(), radDP)); 
				label_mass.setText(format.floating(currentStar.getMass(), massDP)); 
			}
			label_age.setText(format.exponent(currentStar.getAge(), ageDP)); 
		}
	}
	
	public void changeUnitsToSI(boolean change) {
		if(change) {
			radiusDisplay.setText("Promie? [km]:");
			massDisplay.setText("Masa [kg]:");
		} else {
			radiusDisplay.setText("Promie? [R/Rs]:");
			massDisplay.setText("Masa [M/Ms]:");
		}
	}
	
	public Star getCurrentStar() {
		return currentStar;
	}

}
