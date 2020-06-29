package coordination;

import java.util.LinkedList;

import objects.Star;

public class SaveManager {

	LinkedList<String> saves;
	
	public SaveManager(LinkedList<String> saves) {
		this.saves = saves;
	}
	
	public Star[] getSaves() {
		Star[] stars = new Star[saves.size()];
		int i = 0;
		for(String save : saves) {
			int temperature;
			double radius, radius_km;
			double mass, mass_kg;
			long age;
			String star_class;
			int imageNumber;
			String name;

			String values[] = new String[9];
			int j = 0;
			while(true) {
				if(save.length() > 0) {
					if(save.indexOf('&') == -1) {
						values[8] = save;
						break;
					} else {
						values[j] = save.substring(0, save.indexOf('&'));
						save = save.substring(save.indexOf('&')+1);
						j++;
					}
				}
			}
			temperature = Integer.parseInt(values[0]);
			radius = Double.parseDouble(values[1]);
			radius_km = Double.parseDouble(values[2]);
			mass = Double.parseDouble(values[3]);
			mass_kg = Double.parseDouble(values[4]);
			age = Long.parseLong(values[5]);
			star_class = values[6];
			imageNumber = Integer.parseInt(values[7]);
			name = values[8];
			
			stars[i] = new Star(temperature, imageNumber, radius, radius_km, mass, mass_kg, age, star_class, name);
			
			i++;
		}
		return stars;
	}
	
	public void addSave(Star star) {
		saves.add(star.toString());
	}
	
	public void removeStar(int index) {
		saves.remove(index);
	}
	
}
