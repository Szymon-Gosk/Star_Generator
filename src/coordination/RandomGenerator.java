package coordination;

import java.util.Random;

public class RandomGenerator {

	public static int generateTemp(boolean includeDistribution) {
		
		Random random = new Random();
		
		if(includeDistribution) {
			
			int d = random.nextInt(100) + 1;
			
			if(d < 71) {
				return random.nextInt(1300) + 2400;
			} else if( d >= 71 && d < 83) {
				return random.nextInt(1500) + 3700;
			} else if( d >= 83 && d < 91) {
				return random.nextInt(800) + 5200;
			} else if( d>= 91 && d < 96) {
				return random.nextInt(1500) + 6000;
			} else if(d >= 96 && d < 99) {
				return random.nextInt(2500) + 7500;
			} else if(d == 99) {
				return random.nextInt(20000) + 10000;
			} else {
				return random.nextInt(12000) + 30000;
			}
			
		} else {
			
			return random.nextInt(39601) + 2400;
			
		}
		
	}
	
	public static double generateRadiusDev(String star_class) {
		
		Random random = new Random();
		
		int sign;
		
		if(random.nextBoolean()) {
			sign = 1;
		} else {
			sign = -1;
		}
		
		switch(star_class) {
		case "M":
			return sign*((double) random.nextInt(2455))/100000;
		case "K":
			return sign*((double) random.nextInt(3120))/100000;	
		case "G":
			return sign*((double) random.nextInt(1740))/100000;	
		case "F":
			return sign*((double) random.nextInt(3410))/100000;
		case "A":
			return sign*((double) random.nextInt(6120))/100000;
		case "B":
			return ((double) random.nextInt(68210))/100000;
		case "O":
			return ((double) random.nextInt(500000))/100000;
		default:
			return 0;
		}
		
	}
	
	public static double generateMassDev(String star_class) {
		
		Random random = new Random();
		
		int sign;
		
		if(random.nextBoolean()) {
			sign = 1;
		} else {
			sign = -1;
		}
		
		switch(star_class) {
		case "M":
			return sign*((double) random.nextInt(2220))/100000;
		case "K":
			return sign*((double) random.nextInt(3600))/100000;	
		case "G":
			return sign*((double) random.nextInt(2380))/100000;	
		case "F":
			return sign*((double) random.nextInt(5320))/100000;
		case "A":
			return sign*((double) random.nextInt(11350))/100000;
		case "B":
			return sign*((double) random.nextInt(202650))/100000;
		case "O":
			return sign*((double) random.nextInt(217020))/100000;
		default:
			return 0;
		}
		
	}
	
	public static long age(double mass) {
		
		return (long) ((new Random().nextInt(Calculator.calculateAgeIndicator(mass) - 10) + 10)*Math.pow(10, 5));
		
	}
	
	public static int imageNumber() {
		
		return new Random().nextInt(6);
		
	}
	
}
