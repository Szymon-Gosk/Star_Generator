package objects;

import coordination.Calculator;
import coordination.RandomGenerator;

public class Star {

	int temperature;
	int imageNumber;
	double radius, radius_km;
	double mass, mass_kg;
	long age;
	
	String star_class;
	String name;
	
	public Star(boolean includeDistribution) {
		
		temperature = RandomGenerator.generateTemp(includeDistribution);
		imageNumber = RandomGenerator.imageNumber();
		star_class = Calculator.determineClass(temperature);
		radius = Calculator.calculateRadius(temperature) + RandomGenerator.generateRadiusDev(star_class);
		radius_km = Calculator.convertToKilometers(radius);
		mass = Calculator.calculateMass(temperature) + RandomGenerator.generateMassDev(star_class);
		mass_kg = Calculator.convertToKilograms(mass);
		age = RandomGenerator.age(mass);
		name = "Untitled";
		
	}

	public Star(int temperature, int imageNumber, double radius, double radius_km, double mass, double mass_kg,
			long age, String star_class, String name) {
		this.temperature = temperature;
		this.imageNumber = imageNumber;
		this.radius = radius;
		this.radius_km = radius_km;
		this.mass = mass;
		this.mass_kg = mass_kg;
		this.age = age;
		this.star_class = star_class;
		this.name = name;
	}

	public int getTemperature() {
		return temperature;
	}

	public double getRadius() {
		return radius;
	}

	public double getRadiusKm() {
		return radius_km;
	}

	public double getMass() {
		return mass;
	}

	public double getMassKg() {
		return mass_kg;
	}

	public double getAge() {
		return age;
	}	
	
	public String getStarClass() {
		return star_class;
	}
	
	public int getImageNumber() {
		return imageNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		
	}
	
	public String toString() {
		return ( temperature + "&" +  radius + "&" + radius_km + "&" + mass + "&" + mass_kg + "&"
				+ age + "&" + star_class + "&" + imageNumber + "&" + name);
	}
	
}
