package joe.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import joe.word.WordSplitter;
import joe.word.WordsModel;

public class TextFile {

	private final String fileName;
	private final WordsModel wordsModel;
	
	public TextFile(final File file) throws IOException {
		this.fileName = file.getName();
		this.wordsModel = new WordsModel();
		try(final BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while((line = reader.readLine()) != null) {
				WordSplitter.splitString(line).forEach(word -> wordsModel.addWord(word));
			}
		}
	}
	
	public float wordSearchRanking(String... words) {
		float totalWords = 0, wordsFound = 0;
		for(String word : removeDuplicates(words)) {
			totalWords++;
			if(wordsModel.containsWord(word)) {
				wordsFound++;
			}
		}
		if(totalWords == 0 || wordsFound == 0) {
			return 0;
		} else {
			return (wordsFound / totalWords) * 100;
		}
	}
	
	private Set<String> removeDuplicates(String[] words) {
		final Set<String> uniqueWords = new HashSet<>();
		for(String word : words) {
			uniqueWords.add(word);
		}
		return uniqueWords;
	}

	public String getFileName() {
		return this.fileName;
	}
	
}