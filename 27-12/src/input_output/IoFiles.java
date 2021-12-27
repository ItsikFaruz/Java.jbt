package input_output;

import java.io.File;
import java.io.IOException;

public class IoFiles {

	public static void main(String[] args) {

		
		String path = "c:/itsik/temp/file1.txt";
		File file = new File(path);
		
		try {
		if(file.exists()) {
			System.out.println("file exists: " + file);
		}else {
			System.out.println("file Not exists: " + file);
			file.createNewFile();
			System.out.println("file created");
		}
		} catch (IOException e) {
		e.printStackTrace();
		}
					
		
		
		
		
	}
}

