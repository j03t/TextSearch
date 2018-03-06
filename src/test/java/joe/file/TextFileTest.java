package joe.file;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TextFileTest {
	
	@Test
	public void testNoWordInput() throws IOException {
		final TextFile textFile = new TextFile(new File("src/test/resources/Voyager-Encounters-Jupiter.txt"));
		Assert.assertEquals(0, textFile.wordSearchRanking(), 0);
	}

	@Test
	public void testFoundOneWord() throws IOException {
		final TextFile textFile = new TextFile(new File("src/test/resources/Voyager-Encounters-Jupiter.txt"));
		Assert.assertEquals(100	, textFile.wordSearchRanking("Jupiter"), 0);
	}

	@Test
	public void testFoundMultiple() throws IOException {
		final TextFile textFile = new TextFile(new File("src/test/resources/Voyager-Encounters-Jupiter.txt"));
		Assert.assertEquals(100, textFile.wordSearchRanking("Jupiter", "cylindrical", "historian", "Viking"), 0);
	}
	
	@Test
	public void testNotFound() throws IOException {
		final TextFile textFile = new TextFile(new File("src/test/resources/Voyager-Encounters-Jupiter.txt"));
		Assert.assertEquals(0, textFile.wordSearchRanking("kitten"), 0);
	}
	
	@Test
	public void testSomeWordsFound() throws IOException {
		final TextFile textFile = new TextFile(new File("src/test/resources/Voyager-Encounters-Jupiter.txt"));
		Assert.assertEquals(50, textFile.wordSearchRanking("jupiter", "kitten"), 0);
		Assert.assertEquals(33.33, textFile.wordSearchRanking("jupiter", "kitten", "puppy"), 0.01);
		Assert.assertEquals(66.66, textFile.wordSearchRanking("jupiter", "kitten", "the"), 0.01);
		Assert.assertEquals(40, textFile.wordSearchRanking("jupiter", "kitten", "puppy", "the", "horse"), 0);
	}
	
	@Test
	public void testDuplicatesInSearchRemoved() throws IOException {
		final TextFile textFile = new TextFile(new File("src/test/resources/Voyager-Encounters-Jupiter.txt"));
		Assert.assertEquals(50, textFile.wordSearchRanking("jupiter", "jupiter", "kitten"), 0);
	}
	
}