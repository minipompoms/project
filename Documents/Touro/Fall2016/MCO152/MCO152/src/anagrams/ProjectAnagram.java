package anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ProjectAnagram {

	private static Scanner input = new Scanner(System.in);

	private ArrayList<String> dictionary; 
	private ArrayList<String> match;
	
	
	//constructor
	public ProjectAnagram()
	{
		start();
		String random = input.nextLine();
	}
	
	private void start()
	{
		dictionary = new ArrayList<String>();
		match = new ArrayList<String>();
	}
	
	private void readFromFile() throws FileNotFoundException 
	{
		File afile = new File("Words.txt");
		while (input.hasNextLine()) {
			dictionary.add(input.nextLine());
		}

	}
	
}	
