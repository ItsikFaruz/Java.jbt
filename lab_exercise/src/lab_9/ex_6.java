package lab_9;

public class ex_6 {

	public static void main(String[] args) {

		int[] arr = new int[50];
		int max = 0;
		int min = 0;
		int cntMax = 0;
		int cntMin = 0;
		arr[0] = (int) (Math.random() * 101);
		max = arr[0];
		min = arr[0];
		System.out.print(arr[0] + ", ");

		for (int i = 1; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 101);
			System.out.print(arr[i] + ", ");
			if (arr[i] > max) {
				max = arr[i];
				cntMax = i;
			}
			if (arr[i] < min) {
				min = arr[i];
				cntMin = i;
			}

		}
		System.out.println("\n" + "the max number in arr found in cell: " + cntMax + " and his value is: " + max);
		System.out.println("the min number in arr found in cell: " + cntMin + " and his value is: " + min);

	}
}
