package coordination;

public class Calculator {

	public static double calculateRadius(int temperature) {
		return 1/(4.2e8) * Math.pow((1.2*temperature + 23750), 2) - 1.2;
	}

	public static double calculateMass(int temperature) {
		return 1/(8.5e7) * Math.pow(1.3*temperature + 500, 2);
	}
	
	public static double convertToKilometers(double radius) {
		return radius*695508;
	}
	
	public static double convertToKilograms(double mass) {
		return mass*1.989e30;
	}
	
	public static int calculateAgeIndicator(double mass) {
		return (int) ((Math.pow(mass, -2.5)*Math.pow(10, 5)) + 10)/2;
	}
	
	public static String determineClass(int temperature) {
		if(temperature < 3700) {
			return "M";
		} else if(temperature >= 3700 && temperature < 5200) {
			return "K";
		} else if(temperature >= 5200 && temperature < 6000) {
			return "G";
		} else if(temperature >= 6000 && temperature < 7500) {
			return "F";
		} else if(temperature >= 7500 && temperature < 10000) {
			return "A";
		} else if(temperature >= 10000 && temperature < 30000) {
			return "B";
		} else {
			return "O";
		}
	}
	
}
