package joe.word;

import org.junit.Assert;
import org.junit.Test;

public class WordsModelTest {

	@Test
	public void test() {
		final WordsModel wordsModel = new WordsModel();
		Assert.assertFalse(wordsModel.containsWord("test"));
		wordsModel.addWord("tests");
		Assert.assertFalse(wordsModel.containsWord("test"));
		wordsModel.addWord("test");
		Assert.assertTrue(wordsModel.containsWord("test"));
	}
	
	@Test public void testCaseIgnored() {
		final WordsModel wordsModel = new WordsModel();
		wordsModel.addWord("TEST");
		Assert.assertTrue(wordsModel.containsWord("test"));
		Assert.assertTrue(wordsModel.containsWord("Test"));
	}
	
	@Test
	public void testSpecialChars() {
		final WordsModel wordsModel = new WordsModel();
		wordsModel.addWord("they'll");
		Assert.assertTrue(wordsModel.containsWord("they'll"));
		wordsModel.addWord("re-use");
		Assert.assertTrue(wordsModel.containsWord("re-use"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUnexpectedCharsFound() {
		new WordsModel().addWord("7am");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUnexpectedCharsInSearch() {
		final WordsModel wordsModel = new WordsModel();
		wordsModel.addWord("add");
		wordsModel.containsWord("a1");
	}
	
}