package coordination;

import objects.Star;

public class StarGenerator {
	
	public Star generateStar(boolean includeStandardDistribution) {
		return new Star(includeStandardDistribution);
	}

}
