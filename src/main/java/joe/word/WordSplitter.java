package joe.word;

import java.util.ArrayList;
import java.util.List;

public class WordSplitter {
	
	private static final String PUNCTUATION_TO_REMOVE_REGEX = "[.,?!\"]";
	private static final String SPLIT_REGEX = "\\s+";//One or more spaces
	//Numbers not allowed, words with apostrophe or hyphen after at least one letter allowed
	private static final String VALID_WORD_REGEX = "([A-Za-z])+(['-]([A-Za-z])+)*'?";
	
	public static List<String> splitString(final String line) {
		final List<String> words = new ArrayList<>();
		for(String word : line.replaceAll(PUNCTUATION_TO_REMOVE_REGEX, "").split(SPLIT_REGEX)) {
			if(word.matches(VALID_WORD_REGEX)) {
				words.add(word);
			}
		}
	    return words;
	}
	
}