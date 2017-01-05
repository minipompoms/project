package project;

import junit.framework.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class AnagramsTests extends TestCase {

	ProjectAnagram game;

	@Before
	public void setUp() {
		try {
			game = new ProjectAnagram("words.txt");
		} catch (IOException ex) {
			fail("Game setup error.");
		}
	}

	@Test // pass in the wrong file
	public void setUpFileException() {
		try {
			game = new ProjectAnagram("w0rds.txt");
			fail("Exception expected.");
		} catch (IOException ex) {
			assertTrue(true);
		}

	}

	@Test
	public void testWordLengthLevel2() {//the 2 asserts must be run under same conditions
		assertFalse("1 letter is invalid on start.", game.isValidWord("o"));

		assertTrue("Valid word", game.isValidWord("on"));
	}

	@Test
	public void testWordLengthLevel3() {
		game.setLevel(3);
		assertFalse("2 letter word is invalid", game.isValidWord("me"));
		
		assertTrue("Valid word", game.isValidWord("she"));
	}

	@Test
	public void testWordLengthLevel4() {
		game.setLevel(4);
		assertFalse("3 letter word is invalid", game.isValidWord("hey"));
		
		assertTrue("Valid word", game.isValidWord("tree"));
	}

	@Test
	public void testInvalidLetters() {
		assertFalse("Letters not from list.", game.isContainedInScrambledLetters("abc", "defghijk"));
	}

	@Test
	public void testValidLetters() {
		assertTrue("Letters in list", game.isContainedInScrambledLetters("car", "qwertycpa"));
	}

	@Test
	public void testSomeLetters() {
		assertFalse("Letters not from list.", game.isContainedInScrambledLetters("abde", "defghijk"));
	}

	@Test
	public void testNonWord() {
		assertFalse("Invalid word", game.isInDictionary("zzz"));
	}

	@Test
	public void testRealWord() {
		assertTrue("Valid word", game.isInDictionary("best"));
	}
	
	@Test
	public void test3Incorrects(){
		game.updateIncorrects();
		game.updateIncorrects();
		game.updateIncorrects();
		assertEquals(3, game.getNumIncorrects());
	}
	
	@Test
	public void updateScore(){
		game.updateScore(10);
		assertEquals(10, game.getScore());
	}

}
