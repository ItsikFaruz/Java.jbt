package lab_8;

public class ex_7 {

	public static void main(String[] args) {

		int[] arr = new int[10];
		int min = 0;
		int cnt = 0;
		arr[0] = (int) (Math.random() * 101);
		min = arr[0];
		System.out.println(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 101);
			System.out.println(arr[i] + ", ");
			if (arr[i] < min) {
				min = arr[i];
				cnt = i;
			}

		}
		System.out.println("the min number in arr found in cell: " + cnt + " and his value is: " + min);

	}

}
