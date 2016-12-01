package project;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Anagrams {

	private static Scanner input = new Scanner(System.in);

	private ArrayList<String> dictionary; 
	private ArrayList<String> match;
	private ArrayList<Character> notList; 
	private ArrayList<Character> list; 
	
	
	//constructor
	public Anagrams()
	{
		start();
		System.out.println("Enter your jumbled letters:");
		String random = input.nextLine();
		unscramble(random);
		sort();
		getWords();
	}
	
	private void start()
	{
		dictionary = new ArrayList<String>();
		match = new ArrayList<String>();
		notList = notList();
		readFromFile();
	}//end start
	
	//checks characters are valid letters & stores it
	private ArrayList<Character> notList()
	{
		ArrayList<Character> notList = new ArrayList<Character>();
		for(int i = 0; i < 127; i++)
		{
			if (i < 97|| i > 122)
			{
				notList.add((char)i);
			}
		}
		return notList;
	}//end notList
	
	
	private ArrayList<Character> list(String letters)
	{
		ArrayList<Character> list = new ArrayList<Character>();
		for (int i = 0; i < letters.length(); i++) 
		{
			list.add(letters.charAt(i));
		}
		return list;
	}//end list
	
	
	private void readFromFile() 
	{
		try{
		File aFile = new File("src/project/words.txt");
		Scanner read = new Scanner(aFile);
		while (read.hasNextLine()) 
		{
			dictionary.add(read.nextLine());
		}
		}
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		
	}//end readFromFile
	
	public ArrayList<String> getDictionary() 
	{
		return dictionary;
	}//end getDictionary
	
	
	private void getWords() 
	{
		for (int i = 0; i < match.size(); i++) {
			System.out.println(match.get(i));
		}
	}//end getWords
	
	
	
	private void unscramble(String letters)
	{
		letters = letters.toLowerCase();
		// Add the letters to the 2nd list
		list = list(letters);
		// Loop to check a word in dictionary
		for (int i = 0; i < getDictionary().size(); i++)
		{
			ArrayList<Integer> count = new ArrayList<Integer>();
			ArrayList<Character> hold = new ArrayList<Character>();
			hold.addAll(list);
			
			check: for(int j = 0; j < getDictionary().get(i).length(); j++)
			{
				int exists = 0;
				for (int x = 0; x < hold.size(); x++)
				{
					exists = 0;
					if (getDictionary().get(i).charAt(j) ==hold.get(x))
					{
						hold.remove(x);
						exists = 1;	
						continue check;
					}
				}
				count.add(exists);
			}
			int tracker =1;
			for (Integer v: count)
			{
				tracker *= v;
			}
			if (tracker == 1 && getDictionary().get(i).length() <=list.size()
					&& getDictionary().get(i).length() >2)
			{
				match.add(getDictionary().get(i));
			}
		}
	}//end unscramble
	
	
	private void sort()
	{
		Collections.sort(match, new Comparator<String>()
				{
			public int compare(String x, String z)
			{
				if(x.length() > z.length())
				{
					return -1;
				}
				else if(x.length() == z.length())
				{
					return 0;
				}
				else
				{
					return 1;
				}
			}
				});
	}//end sort
	

	
	
}//end class	

  


