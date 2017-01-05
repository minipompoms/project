package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayAnagrams {

	public static void main(String[] args) throws IOException {
		BufferedReader newGame = new BufferedReader(new InputStreamReader(System.in));
		final int FINAL_LEVEL = 5;

		while (true) {
			System.out.println("Let's Play Anagrams!");
			System.out.println("\nThe rules of the game are as follows:\n"
					+ "\nYou start at Level 2, and enter only two-letter words until "
					+ "\nyou reach the next level. When you reach Level 3,"
					+ "\nyou input 3-letter words only... and so on."
					+ "\nThe game ends when you reach level 5 or enter 3 incorrect words." + "\n\nHave Fun!\n");
			ProjectAnagram game = new ProjectAnagram("words.txt");

			System.out.println("Your starting level: " + game.getLevel() + "\tYour starting score: " + game.getScore());

			String play = game.generatedLetters();

			while (true) {
				System.out.println("\nYour scrambled letters are: " + play);
				System.out.println("Enter a " + game.getLevel() + "-letter word:");
				String word = newGame.readLine();

				if (game.isValidWord(word) && game.isContainedInScrambledLetters(word, play)
						&& game.isInDictionary(word) && game.getNumIncorrects() == 3) {
					if (game.isValidWord(word)) {
						System.out.println("CORRECT");
						game.updateScore(1);
						System.out.println("Your current level: " + game.getLevel());
						System.out.println("Your current score: " + game.getScore());
					} else {
						System.out.println("Invalid word. Please try again.");
						game.updateIncorrects();
					}
				} else if (!game.isValidWord(word)) {
					System.out.println("Invalid word length.");
					game.updateIncorrects();
				} else if (!(game.isContainedInScrambledLetters(word, play))) {
					System.out.println("Characters of the word entered are not present in scrambled letters");
					game.updateIncorrects();
				} else {
					System.out.println("Invalid word. " + word + " is not in our dictionary.");
					game.updateIncorrects();
				}

				if (game.getNumIncorrects() == 3) {
					System.out.println("\nYou have 3 incorrects. Sorry.. GoodBye!");
					break;
				}

				if (game.getLevel() == FINAL_LEVEL) {
					System.out.println("\nCONGRATS!! You have completed all the levels");
					System.out.println("Your final score: " + game.getScore());
					break;
				}
			}

			System.out.println("\nWould you like to play another game?  (Enter 'y' to continue, or 'n' to quit): ");
			String choice = newGame.readLine();

			if (choice.toLowerCase().equals("n"))
				break;
		}

	}

}
