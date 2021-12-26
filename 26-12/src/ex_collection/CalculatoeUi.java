package ex_collection;

import java.util.Scanner;

public class CalculatoeUi {

	Calculator calculator = new Calculator();
	boolean systemOn=true ;
	Scanner sc = new Scanner(System.in);

	public void start() {
		while (systemOn) {
			try {
				

				showMenu();
				String command = sc.nextLine();
				switch (command) {
				case "+":
					doAdd();
					break;
				case "-":
					doSub();
					break;
				case "*":
					doMul();
					break;
				case "/":
					doDiv();
					break;
				case "=":
					res();
					break;
				case "c":
					clearRes();
					break;
				case "q":
					systemOn = false;
					break;
				default:
					break;
				}

			} catch (RuntimeException e) {
				System.err.println("ERROR: " + e.getMessage());
				break;
			}
		}

	} 

	private void clearRes() {
		calculator.clear();

	}

	private void res() {
		System.out.println(this.calculator.getRes());
	}

	private void doDiv() {
		System.out.println("enter value to div: ");
		double val = Double.parseDouble(sc.nextLine());
		this.calculator.div(val);
	}

	private void doMul() {
		System.out.println("enter value to mul: ");
		double val = Double.parseDouble(sc.nextLine());
		this.calculator.mul(val);
	}

	private void doSub() {
		System.out.println("enter value to sub: ");
		double val = Double.parseDouble(sc.nextLine());
		this.calculator.sub(val);

	}

	private void doAdd() {
		System.out.println("enter value to add: ");
		double val = Double.parseDouble(sc.nextLine());
		this.calculator.add(val);

	}

	public void showMenu() {
		System.out.println("\n===Menu");
		System.out.println("add.......... +");
		System.out.println("sub.......... -");
		System.out.println("mul.......... *");
		System.out.println("div.......... /");
		System.out.println("res.......... =");
		System.out.println("clear........ c");
		System.out.println("quit........ q");
	}

}
