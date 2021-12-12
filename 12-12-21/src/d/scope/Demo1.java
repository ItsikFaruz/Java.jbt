package d.scope;

public class Demo1 {

	public static void main(String[] args) {
		
		{// this is a scope
			int x = 5;
			System.out.println(x);
		}//end of a scope 
		
		{// this is a scope
			int x = 3;
			System.out.println(x);
		}//end of a scope
	}
	

}
