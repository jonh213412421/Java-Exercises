package writer;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class write_file {
	public static void main(String[] args) {
		//variables
		String path = System.getProperty("user.home") + "/Desktop/";
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter filename: ");
		String filename = path + scanner.nextLine() + ".txt";
		System.out.println("enter content: ");
		String content = scanner.nextLine();
		//write file and string in file
		try {
			FileWriter writer = new FileWriter(filename);
			writer.write(content);
			writer.close();
			System.out.println("file written");
		} catch (IOException e) {
			System.out.println("error");
		}
	}
}
