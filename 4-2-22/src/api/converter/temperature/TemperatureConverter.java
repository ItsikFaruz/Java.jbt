package api.converter.temperature;

public class TemperatureConverter {

	
	public static double convertCelsiusToFahrenheit(double celsius) {
		double fahrenheit = celsius *1.8 + 32;
		return fahrenheit;
	}
	
	public static double convertFahrenheitoCelsius(double fahrenheit) {
		double celsius = (fahrenheit -32)*0.5556;
		return celsius;
	}

}
