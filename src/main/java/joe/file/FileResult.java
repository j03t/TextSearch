package joe.file;

public class FileResult implements Comparable<FileResult> {
	
	private final String fileName;
	private final Float ranking;
	
	public FileResult(String fileName, float ranking) {
		this.fileName = fileName;
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return String.format("%s : %.0f%%", fileName, ranking);
	}

	@Override
	public int compareTo(FileResult that) {
		final int rankingCompare = that.ranking.compareTo(this.ranking);
		if(rankingCompare == 0) {
			return that.fileName.compareTo(this.fileName);
		} else {
			return rankingCompare;
		}
	}
	
}