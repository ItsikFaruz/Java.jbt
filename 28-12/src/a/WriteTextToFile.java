package a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextToFile {

	public static void main(String[] args) {

		File directory = new File("c:/itsik/temp/a/b");
		if(!directory.exists()) {
			directory.mkdirs();
		}
		
		// this the file we want to write to
		File file = new File(directory,"file2.text");
		
		//create an object that can write text to file
		//add buffer
		
		
		try (BufferedWriter out = new BufferedWriter(new FileWriter(file,false));){ // if true:add on existing , false create new
			out.write("this is the first line.");
			out.write("this is the second line.");
			out.newLine();
			System.out.println("text writeen");
			
			int x = 500;
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
