package joe.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class FileSearchRanker {

	private final List<TextFile> files = new ArrayList<>();

	public FileSearchRanker(final String indexableDirectory) throws IOException {
		for (final File fileEntry : new File(indexableDirectory).listFiles()) {
			if (!fileEntry.isDirectory()) {
				files.add(new TextFile(fileEntry));
			}
		}
	}

	public String rankFilesForWords(String... words) {
		final TreeSet<FileResult> fileRankings = new TreeSet<FileResult>();
		for (TextFile file : files) {
			fileRankings.add(new FileResult(file.getFileName(), file.wordSearchRanking(words)));
		}
		final List<String> results = new ArrayList<>();
		final Iterator<FileResult> iterator = fileRankings.iterator();
		for(int i = 0; i < fileRankings.size() && i < 10; i++) {
			results.add(iterator.next().toString());
		}
		return String.join("\n", results);
	}
}
