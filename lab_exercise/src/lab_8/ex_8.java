package lab_8;

public class ex_8 {

	public static void main(String[] args) {

		int[] arr = new int[10];
		arr[0] = (int) (Math.random() * 101);
		System.out.println(arr[0]);
		int max = arr[0];
		int min = arr[0];
		int sum = arr[0];
		int avg = 0;
		int cellMin = 0;
		int cellMax = 0;

		for (int i = 1; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 101);
			System.out.println(arr[i] + ",");
			sum += arr[i];
			if (arr[i] > max) {
				max = arr[i];
				cellMax = i;
			}
			if (arr[i] < min) {
				min = arr[i];
				cellMin = i;
			}

		}

		avg = sum / arr.length;
		System.out.println("sum= " + sum + " avg= " + avg + " cellMin= " + cellMin + " min= " + min + " cellMax= "
				+ cellMax + " max= " + max);

	}

}
