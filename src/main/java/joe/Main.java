package joe;

import java.io.IOException;
import java.util.Scanner;

import joe.file.FileSearchRanker;

public class Main {

	public static void main(String[] args) throws IOException {
		if(args.length == 0) {
			throw new IllegalArgumentException("No directory given to index.");
		}
		final FileSearchRanker fileSearchRanker = new FileSearchRanker(args[0]);
		try(final Scanner input = new Scanner(System.in)) {
			while(true) {
				System.out.print("search> ");
				final String line = input.nextLine();
				if(line.equals(":quit")) {
					System.exit(0);
				} else {
					System.out.println(fileSearchRanker.rankFilesForWords(line.split("\\s+")));
				}
			}
		}
	}
}
