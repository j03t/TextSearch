package joe.file;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;


public class FileSearchRankerTest {

	@Test
	public void test() throws IOException {
		final FileSearchRanker fileSearchRanker = new FileSearchRanker("src/test/resources");
		Assert.assertEquals("testFile1.txt : 50%\nVoyager-Encounters-Jupiter.txt : 50%", fileSearchRanker.rankFilesForWords("jupiter", "kitten"));
		Assert.assertEquals("testFile1.txt : 67%\nVoyager-Encounters-Jupiter.txt : 33%", fileSearchRanker.rankFilesForWords("jupiter", "kitten", "cat"));
		Assert.assertEquals("Voyager-Encounters-Jupiter.txt : 67%\ntestFile1.txt : 33%", fileSearchRanker.rankFilesForWords("jupiter", "viking", "cat"));
	}
	
	@Test public void testMoreThanTenFiles() throws IOException {
		final FileSearchRanker fileSearchRanker = new FileSearchRanker("src/test/resources/more-files");
		final String expectedOuput = "testFile11.txt : 100%" +
			"\ntestFile10.txt : 100%" +
			"\ntestFile9.txt : 75%" +
			"\ntestFile8.txt : 75%" +
			"\ntestFile7.txt : 75%" +
			"\ntestFile6.txt : 50%" +
			"\ntestFile5.txt : 50%" +
			"\ntestFile4.txt : 50%" +
			"\ntestFile3.txt : 50%" +
			"\ntestFile2.txt : 50%";
		Assert.assertEquals(expectedOuput, fileSearchRanker.rankFilesForWords("mouse", "snake", "kitten", "puppy"));
	}

}
