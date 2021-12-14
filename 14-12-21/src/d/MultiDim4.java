package d;

public class MultiDim4 {

	public static void main(String[] args) {

		String [][] cinema = new String[3][3];
		print(cinema);
			

	}

	public static void print(String [][] cinema) {
		System.out.println("=====================");
		for (int i = 0; i < cinema.length; i++) {
			for (int j = 0; j < cinema[i].length; j++) {
				System.out.print(cinema [i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("=====================");
	}
}