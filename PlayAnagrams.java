package project;

import java.util.Scanner;

public class PlayAnagrams {
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		
		ProjectAnagram newGame = new ProjectAnagram();
		int userChoice;
		char[] letters = new char[12];
		
		while (true) {
			userChoice = menu();
			// clear buffer
			keyboard.nextLine();
			switch (userChoice) {
			case 1:
				System.out.println("Enter your name.");
				String user = keyboard.nextLine();
				newGame.setUserName(user);
				System.out.println(
						"To gain points, form words from the 12 letters below. Enter one word at a time. Words must be at least 3 letters.\n");
				letters = newGame.generateLetters();
				String word = null;
			case 2:
				//print out 12 letters
					for (int i = 0; i < letters.length; i++) {
						System.out.print(letters[i] + " ");
					}
					word = keyboard.nextLine();
					//check the letter against the available letters and the list
					if ((newGame.checkLettersAndLength(letters, word.toUpperCase())) == true) {
						if (newGame.checkWord(word.toUpperCase()) == true) {
							newGame.addPoints(word);
						} else {
							System.out.println("Sorry, that's not in our dictionary.");
						}
					} else {
						System.out.println(
								"Invalid word. Make sure your word is at least 3 letters and uses the letters provided.");
					}
				
				break;
			case 3:
				System.out.println("\nThanks for playing! " + newGame.getUserName()  + "'s total score is " + newGame.getTotalPoints());
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice.\n");
				userChoice = menu();
				break;
			}
		}
	}

	public static int menu() {
		System.out.println("Enter 1 to start a new game, 2 to add a word and 3 to exit.");
		int choice = keyboard.nextInt();
		return choice;
	}

}
