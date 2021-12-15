package lab_3;

public class ex_1_2 {

	public static void main(String[] args) {
		
		 double salary = (int)(Math.random()*150001);
		 double totalTax = 0;
		 int bracket1 =23000;
		 int bracket2 =50000;
		 int bracket3 =100000;
		 double tax1 = 0.1;
		 double tax2 = 0.2;
		 double tax3 = 0.3;
		 double tax4 = 0.4;
  		
		
		 System.out.println("The salary before tax: " + salary );
		 
		 if (salary <= bracket1) {
			 totalTax = (int) (salary * tax1);
			 System.out.println("The calculation tax is: " +salary+"*"+tax1 +"=" +(salary*tax1));
		 }
		 else if (salary > bracket1 && salary <=bracket2) {
			 totalTax = (bracket1*tax1) + ((bracket2-salary)*0.2);
			 System.out.println("The calculation tax is: " +bracket1+"*"+tax1 +"=" +(bracket1*tax1)+"  "
			 			+ (salary-bracket1)+"*"+tax2+"=" + ((salary-bracket1)*tax2));
			 
		 }else if (salary > bracket2 && salary <= bracket3) {
			 totalTax = (bracket1*tax1) + ((bracket2-bracket1) * tax2) + ((salary-bracket2)*tax3);
			 System.out.println("The calculation tax is: " +bracket1+"*"+tax1 +"=" +(bracket1*tax1)+"  "
			 			+ (bracket2-bracket1)+"*"+tax2+"=" + ((bracket2-bracket1)*tax2)+ "  " + (salary-bracket2)+"*"+tax3+"="
			 			+  ((salary-bracket2)*tax3));
			 
		 }else {
			 totalTax = (bracket1*tax1) + ((bracket2-bracket1)*tax2) + ((bracket3-bracket2)*tax3) + ((salary-bracket3)*tax4);
			 	System.out.println("The calculation tax is: " +bracket1+"*"+tax1 +"=" +(bracket1*tax1)+"  "
			 			+ (bracket2-bracket1)+"*"+tax2+"=" + ((bracket2-bracket1)*tax2)+ "  " + (bracket3-bracket2)+"*"+tax3+"="
			 			+ ((bracket3-bracket2)*tax3)+ "  " + (salary-bracket3)+"*" +tax4+"="+ ((salary-bracket3)*tax4));
		 }
		 		System.out.println("=============");
		 		System.out.println(totalTax);
		 	
		
		
	}

}

	