public class Temperature{
	public static double celsiusToFahrenheit(double celsius){
		double result = (celsius) * (9.0/5.0) + 32;
		return result;

	}

	public static double celsiusToKelvin(double celsius){
		double result = (celsius) + 273.15;
		return result;
	}

	public static double fahrenheitToCelsius (double fahrenheit){
		double result = (5.0/9.0) * (fahrenheit - 32);
		return result;
	}

	public static double  fahrenheitToKelvin (double fahrenheit){
		double result = (5.0/9.0) * (fahrenheit + 459.67);
		return result;
	}

	public static double kelvinToFahrenheit (double kelvin){
		double result = (9.0/5.0) * (kelvin) - 459.67;
		return result;

	}

	public static double kelvinToCelsius (double kelvin){
		double result = kelvin - 273.15;
		return result;
	}
}