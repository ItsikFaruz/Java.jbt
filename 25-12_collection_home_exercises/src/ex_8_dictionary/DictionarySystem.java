package ex_8_dictionary;

import java.util.Scanner;

public class DictionarySystem {

	private Dictionary dictionary = new Dictionary();
	boolean systemOn=true;
	Scanner sc = new Scanner(System.in);
	
	public void start() {
		while (systemOn) {
			try {
				printMenu();
				String command = sc.nextLine();
				switch (command) {
				case "add":
					doAdd();
					break;
				case "get":
					doGet();
					break;
				case "edit":
					doEdit();
					break;
				case "del":
					doDelete();
					break;
				case "disp":
					doDisplay();
					break;

				case "quit":
					systemOn = false;
					break;

				default:
					System.out.println(command + "is not a supported action");
				}

			} catch (Exception e) {
				System.out.println("ERROR: " + e.getMessage());
			}
				
		}
		sc.close();
		System.out.println("bye");
	}

	private void doDisplay() {
		System.out.println("all entries: ");
		for (String entry : dictionary.getAllEntrySorted()) {
			System.out.println(entry);
		}
		System.out.println("==================");
	}

	private void doDelete() {
		System.out.print("enter the entry to delete:");
		String entry = sc.nextLine();
		String x = this.dictionary.deleteEntry(entry);
		if (x != null) {
			System.out.println("deleted entry: " + entry);
		} else {
			System.out.println("entry " + entry + "not found");
		}
	}

	private void doEdit() throws DictionaryException {
		System.out.print("enter the entry to edit:");
		String entry = sc.nextLine();
		System.out.print("enter the new definition");
		String definiton = sc.nextLine();
		this.dictionary.editEntry(entry, definiton);
	}

	private void doGet() {
		System.out.print("enter the entry to get definition:");
		String entry = sc.nextLine();
		String def = dictionary.getDefinition(entry);
		System.out.println(entry + ": " + def);
	}

	private void doAdd() throws DictionaryException {
		System.out.print("enter the new entry:");
		String entry = sc.nextLine();
		System.out.print("enter new definition");
		String definiton = sc.nextLine();
		this.dictionary.addEntry(entry, definiton);
	}

	public void printMenu() {
		System.out.println("\n=====menu=====");
		System.out.println("add entry...............add");
		System.out.println("get definition..........get");
		System.out.println("edit definition.........edit");
		System.out.println("delete entry............del");
		System.out.println("display all.............add");
		System.out.println("exit....................quit");
		System.out.print("enter a choise.......... ");
	}

}
