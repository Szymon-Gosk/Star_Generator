package coordination;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Format {
	
	private DecimalFormat decimalFormat;
	
	private Locale locale;
	
	public Format() {
		
		locale = new Locale("en");
		
		decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
		
	}
	
	public String exponent(double value, int decimal_point) {
		
		String pattern = "0";
		
		if(decimal_point > 0) {
			
			pattern += ".";
			
			for(int i = 0; i < decimal_point; i++) { pattern+= "0";}
			
		}
		
		pattern += "E0";
		
		decimalFormat.applyPattern(pattern);
		
		String format = decimalFormat.format(value);
		
		String mantissa, exponent;
		
		if(decimal_point == 0) {
			
			mantissa = format.substring(0, 2);
			
			exponent = format.substring(3);
			
		} else {
			
			mantissa = format.substring(0, decimal_point + 2); 
		
			exponent = format.substring(decimal_point + 3); 
			
		}
		
		return "<html><body style=\"font-family:Segoe UI Semilight;font-size:13px\">" + mantissa + "?10<sup>" + exponent + "</sup></body></html>";

	}

	public String exponent(long value, int decimal_point) {

		String pattern = "0";

		if(decimal_point > 0) {

			pattern += ".";

			for(int i = 0; i < decimal_point; i++) { pattern+= "0";}

		}

		pattern += "E0";

		decimalFormat.applyPattern(pattern);

		String format = decimalFormat.format(value);

		String mantissa, exponent;

		if(decimal_point == 0) {

			mantissa = format.substring(0, 2);

			exponent = format.substring(3);

		} else {

			mantissa = format.substring(0, decimal_point + 2);

			exponent = format.substring(decimal_point + 3);

		}

		return "<html><body style=\"font-family:Segoe UI Semilight;font-size:13px\">" + mantissa + "?10<sup>" + exponent + "</sup></body></html>";
		
	}

	public String floating(double value, int decimal_point) {
	
		String pattern = "#0.0";
	
		if(decimal_point > 1) {
			for(int i = 1; i < decimal_point; i++) { pattern+= "0"; }
		}
	
		decimalFormat.applyPattern(pattern);
	
		return "<html><body style=\"font-family:Segoe UI Semilight;font-size:13px\">" + decimalFormat.format(value) + " </body></html>";
	}
	
	public String floatingLong(double value, int decimal_point) {
		
		String pattern = "##,000,000";
		
		if(decimal_point > 0) {
			
			pattern += ".";
			
			for(int i = 0; i < decimal_point; i++) {
				
				pattern+= "0";
				
			}
			
		}
		
		decimalFormat.applyPattern(pattern);
		
		return "<html><body style=\"font-family:Segoe UI Semilight;font-size:13px\">" + decimalFormat.format(value) + " </body></html>";
	}
	
	public String noDecimal(int value) {
		
		decimalFormat.applyPattern("#0,000");
		
		return "<html><body style=\"font-family:Segoe UI Semilight;font-size:13px\">" + decimalFormat.format(value) + " </body></html>";
	}
	
}
