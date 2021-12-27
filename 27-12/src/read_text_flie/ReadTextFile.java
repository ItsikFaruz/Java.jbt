package read_text_flie;

import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {

	public static void main(String[] args) {

		try (FileReader in = new FileReader("c:/itsik/temp/file1.txt");){
			
			int c = in.read(); // read the first character
			while(c != -1) {
				System.out.print((char)c);
				c = in.read();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
			
		
		
	}

}
