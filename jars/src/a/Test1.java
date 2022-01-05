package a;

import api.converter.currency.Currencyonverter;
import api.converter.temperature.TemperatureConverter;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("start test");
		double nis =100;
		double dollar = Currencyonverter.convertNISToDollar(nis);
		System.out.println(nis + " nis are " + dollar + "$");
		
		double celsius = 8 ;
		double farenheit = TemperatureConverter.convertFahrenheitoCelsius(celsius);
		System.out.format("%.2f celsius is %.2f farenheit", celsius , farenheit);
		
	}

}
