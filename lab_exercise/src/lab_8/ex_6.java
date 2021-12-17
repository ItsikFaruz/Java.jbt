package lab_8;

public class ex_6 {

	public static void main(String[] args) {

		int[] arr = new int[10];
		int max = 0;
		int cnt = 0;
		arr[0] = (int) (Math.random() * 101);
		max = arr[0];
		System.out.println(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 101);
			System.out.println(arr[i] + ", ");
			if (arr[i] > max) {
				max = arr[i];
				cnt = i;
			}

		}
		System.out.println("the max number in arr found in cell: " + cnt + " and his value is: " + max);

	}

}
