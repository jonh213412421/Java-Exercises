package writer;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class txt_reader {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("whats the file path? ");
		String path = scanner.nextLine();
		
		try {
			FileReader filereader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(filereader);
			String line;
			while ((line  = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();
	} catch(IOException e) {
		System.out.println("error");
	}

	}
}
