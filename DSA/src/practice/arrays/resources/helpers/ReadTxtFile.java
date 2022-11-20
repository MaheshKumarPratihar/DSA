package practice.arrays.resources.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTxtFile {

	public BufferedReader readFile(String fileName) throws IOException {
		// File path is passed as parameter
		StringBuffer sb = new StringBuffer();
		sb.append("D:\\Armundia\\GIT\\DSA\\DSA\\src\\practice\\arrays\\resources\\files\\");
		sb.append(fileName);

		File file = new File(sb.toString());

		// Note: Double backquote is to avoid compiler
		// interpret words
		// like \test as \t (ie. as a escape sequence)

		// Creating an object of BufferedReader class
		BufferedReader br = new BufferedReader(new FileReader(file));

		// Declaring a string variable
//		String st;
		// Condition holds true till
		// there is character in a string
//		while ((st = br.readLine()) != null) {
//
//			// Print the string
//			System.out.println(st);
//		}
		
		return br;
	}
}
