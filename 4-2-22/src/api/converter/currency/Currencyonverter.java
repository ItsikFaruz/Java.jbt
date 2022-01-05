package api.converter.currency;

public class Currencyonverter {
	
	public static double convertDollarToNIS(double dollar) {
		double nis = dollar * 3.09;
		return nis;
	}
	
	public static double convertNISToDollar(double nis) {
		double dollar = nis / 3.09;
		return dollar;
	}

}
