package c;

import b.Box;

public class Demo1StaticInt {

	public static void main(String[] args) {

		// arrays can be statically initialized
		int[] arr1 = { 2, 4, 6, 8 };
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}

		System.out.println("=================");
		String[] names = {"Dinna","Yosi","Arie","Mira"};
		
		for (int j = 0; j < names.length; j++) {
			System.out.println(names[j]);
		}
			
		System.out.println("=================");
		
		Box[] boxes = {new Box(), new Box(1,2,3)};
		System.out.println();
		}
	
}


