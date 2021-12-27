package read_text_flie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFileBuffered {

	public static void main(String[] args) {

		File file = new File("c:/itsik/temp/file1.txt");
		try (BufferedReader in = new BufferedReader(new FileReader(file));) {
			String line = in.readLine();
			while (line != null) {
				System.out.println(line);
				line = in.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
