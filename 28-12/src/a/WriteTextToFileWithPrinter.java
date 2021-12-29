package a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteTextToFileWithPrinter {

	public static void main(String[] args) {

		File directory = new File("c:/itsik/temp/a/b");
		if(!directory.exists()) {
			directory.mkdirs();
		}
		
		// this the file we want to write to
		File file = new File(directory,"file2.text");
		
		//create an object that can write text to file
		//add buffer
		
		
		try (PrintWriter out = new PrintWriter(new FileWriter(file,false));){ // if true:add on existing , false create new
			out.println("this is the first line.");
			out.println("this is the second line.");
			out.println(8);
			out.println(83);
			int x = 500;
			out.println(x);
			System.out.println("text writeen");
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
