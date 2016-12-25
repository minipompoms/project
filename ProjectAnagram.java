
package project;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class ProjectAnagram {


	private HashMap<String,Boolean> dictionary;
	private Random r;
	private int level;
	private int totalPoints;
	private int numIncorrects;

	// constructor
	public ProjectAnagram(String filename) throws IOException
	{
			
		dictionary = new HashMap<String,Boolean>();
		r = new Random();
		BufferedReader readFromFile = new BufferedReader(new FileReader("src/project/words.txt"));
		String line = "";
	
		while ( (line = readFromFile.readLine()) != null ) {
			dictionary.put(line.toLowerCase(), true); // creates dictionary of valid words
		}
		
		readFromFile.close();
		
		level = 2;
		totalPoints = 0;
		numIncorrects = 0;
	}

	public void updateIncorrects() 
	{
		numIncorrects++;
	}
	
	public int getNumIncorrects() 
	{
		return numIncorrects;
	}
	
	public int getLevel() 
	{
		return level;
	}
	
	public int getScore() 
	{
		return totalPoints;
	}
	
	public void updateLevel() 
	{
		if (level == 2 && totalPoints == 2) {
			level++;
		} else if (level == 3 && totalPoints == 6) {
			level++;
		} else if (level == 4 && totalPoints == 8) {
			level++;
		}		
	}
	

	public void updateScore(int increment) 
	{
		totalPoints += increment;
		updateLevel();
	}
	
	public boolean isValidWord(String word) 
	{
		return word.length() == level;
	}
	
	
	public boolean isContainedInScrambledLetters (String word, String lets) 
	{
		HashMap<Character, Integer> scrambled = new HashMap<Character, Integer> ();
		// break up letters
		
		for (int i = 0; i < lets.length(); i++) {
			if (scrambled.containsKey(lets.charAt(i))) {
				scrambled.put(lets.charAt(i), scrambled.get(lets.charAt(i))+1);
			} else {
				scrambled.put(lets.charAt(i), 1);
			}
		}
		
		for (int i = 0; i < word.length(); i++) {
			if (scrambled.containsKey(word.charAt(i))) {
				if (scrambled.get(word.charAt(i)) == 0) {
					return false;
				} else {
					scrambled.put(word.charAt(i), scrambled.get(word.charAt(i))-1);
				}
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	public String generateRandomVowel() 
	{
		char[] vowel = { 'a', 'e', 'i', 'o', 'u' };
		return vowel[r.nextInt(vowel.length)]+"";
	}
	
	public String generatedLetters() 
	{
		// gets random vowels first
		String str = generateRandomVowel()+ " "+generateRandomVowel()+" "; 
		// adding 10 more alphabets to the string
		for (int i = 0; i < 10; i++) {
			char c = (char)(r.nextInt(26) + 'a');
			str += c + " ";
		}
		return str;
	}


	
}