package joe.word;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WordSplitterTest {

	@Test
	public void testSimple() {
		final String line = "nothing complicated here";
		final List<String> words = WordSplitter.splitString(line);
		Assert.assertEquals(3, words.size());
	}
	
	@Test
	public void testWithPunctiation() {
		final String line = "nothing, complicated here. Or is there? Nope!";
		final List<String> words = WordSplitter.splitString(line);
		Assert.assertEquals(7, words.size());
		Assert.assertEquals("nothing", words.get(0));
		Assert.assertEquals("complicated", words.get(1));
		Assert.assertEquals("here", words.get(2));
		Assert.assertEquals("Or", words.get(3));
		Assert.assertEquals("is", words.get(4));
		Assert.assertEquals("there", words.get(5));
		Assert.assertEquals("Nope", words.get(6));
	}
	
	@Test
	public void testApostrophe() {
		final String line = "he's all you'll need for cleaning horses' stables";
		final List<String> words = WordSplitter.splitString(line);
		Assert.assertEquals(8, words.size());
		Assert.assertEquals("he's", words.get(0));
		Assert.assertEquals("you'll", words.get(2));
		Assert.assertEquals("horses'", words.get(6));
	}
	
	@Test
	public void testWordsInQoutes() {
		final String line = "\"Oi!\" he shouted, \"what's up?\"";
		final List<String> words = WordSplitter.splitString(line);
		Assert.assertEquals(5, words.size());
		Assert.assertEquals("Oi", words.get(0));
		Assert.assertEquals("he", words.get(1));
		Assert.assertEquals("shouted", words.get(2));
		Assert.assertEquals("what's", words.get(3));
		Assert.assertEquals("up", words.get(4));
	}
	
	@Test
	public void testWebAddressAndEmailOmitted() {
		final String line = "go to http://www.google.com for more info, or email random@test.com";
		final List<String> words = WordSplitter.splitString(line);
		Assert.assertEquals(7, words.size());
		Assert.assertEquals("info", words.get(4));
		Assert.assertEquals("email", words.get(6));
	}

	@Test
	public void testNumbersOmmitted() {
		final String line = "1. At 7am on 23rd March 1954";
		final List<String> words = WordSplitter.splitString(line);
		Assert.assertEquals(3, words.size());
		Assert.assertEquals("At", words.get(0));
		Assert.assertEquals("on", words.get(1));
		Assert.assertEquals("March", words.get(2));
	}
	
	@Test
	public void testHypenatedWords() {
		final String line = "Improve well-being on the merry-go-round";
		final List<String> words = WordSplitter.splitString(line);
		Assert.assertEquals(5, words.size());
		Assert.assertEquals("well-being", words.get(1));
		Assert.assertEquals("merry-go-round", words.get(4));
	}
	
}