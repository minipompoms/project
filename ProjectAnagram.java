package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProjectAnagram {

	private static Scanner input = new Scanner(System.in);

	private ArrayList<String> dictionary;
	// private ArrayList<String> match;
	private String userName;
	private int totalPoints;

	// constructor
	public ProjectAnagram() {
		try {
			start();
		} catch (FileNotFoundException e) {
			
		System.out.println("Contact IT, problem occured.");
		}
		// String random = input.nextLine();
	}

	private void start() throws FileNotFoundException {
		dictionary = new ArrayList<String>();
		readFromFile();
		// match = new ArrayList<String>();
	}

	private void readFromFile() throws FileNotFoundException {
		File afile = new File("words.txt");
		while (input.hasNextLine()) {
			dictionary.add(input.nextLine());
		}

	}

	public boolean checkLettersAndLength(char[] letters, String word) {
		boolean valid = false;
		if (word.length() < 3) {
			valid = false;
		}
		// break up letters
		// check each char in the array against the list of chars
		for (int i = 0; i < word.length(); i++) {
			
				if (word.charAt(i) != letters[0] && word.charAt(i) != letters[1] 
						&& word.charAt(i) != letters[2] && word.charAt(i) != letters[3] 
						&& word.charAt(i) != letters[4] && word.charAt(i) != letters[5] 
						&& word.charAt(i) != letters[6] && word.charAt(i) != letters[7] 
						&& word.charAt(i) != letters[8] && word.charAt(i) != letters[9] 
						&& word.charAt(i) != letters[10] && word.charAt(i) != letters[11]) {
					
					valid = false;
					break;
			}else{
				valid = true;	
			}
			
		}
		return valid;
	}

	public boolean checkWord(String word) {
		boolean isWord = false;
		// compare to words in dictionary
		for (String str : dictionary) {
			if (word.equalsIgnoreCase(str)) {
				isWord = true;
				// if it finds the word, break out and return true
				break;
			} else {
				isWord = false;
			}
		}

		return isWord;
	}

	public char[] generateLetters() {
		// all valid letters
		final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final int N = alphabet.length();
		char[] letters = new char[12];
		int rand;

		Random r = new Random();
		// generate 12 letters
		for (int i = 0; i < 12; i++) {
			// generate a number between 1 and 26
			rand = r.nextInt(N - 1);
			// add to letter list
			letters[i] = alphabet.charAt(rand);

		}
		return letters;
	}

	public void addPoints(String word) {

		// no points for first 2 letters, 1 more for each additional
		totalPoints += (word.length() - 2);

	}

	public int getTotalPoints() {
		return this.totalPoints;
	}

	public void setUserName(String s) {
		this.userName = s;
	}

	public String getUserName() {
		return this.userName;
	}
	
	/*public StringBuilder getDict(){
		StringBuilder list = new StringBuilder();
		for (String word: dictionary){
			list.append(word);
		}
			
		return list;
	}*/
}
