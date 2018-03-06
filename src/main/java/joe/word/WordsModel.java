package joe.word;

//Using a Trie tree structure
public class WordsModel {

	private class Node {
		Node[] children = new Node[28];//26 alphabet characters and - '
		boolean wordEnd;
	}
	
	private Node node = new Node();
	
	public void addWord(final String word) {
		Node node = this.node;
		for(int i =0; i < word.length(); i++) {
			int ind = convertToIndex(word.charAt(i));
			if(node.children[ind] == null) {
				final Node newNode = new Node();
				node.children[ind] = newNode;
				node = newNode;
			} else {
				node = node.children[ind];
			}
		}
		node.wordEnd = true;
	}

	private int convertToIndex(char ch) {
		switch(ch) {
			case '-': return 26;
			case '\'': return 27;
			default: 
				if(Character.isAlphabetic(ch)) {
					return Character.toLowerCase(ch) - 'a';
				} else {
					throw new IllegalArgumentException("Only alphabetic characters and - ' are supported, found: " + ch);
				}
		}
	}
	
	public boolean containsWord(final String word) {
		Node node = this.node;
		for(int i=0; i < word.length(); i++) {
			int ind = convertToIndex(word.charAt(i));
			if(node.children[ind] != null) {
				node = node.children[ind];
			} else {
				return false;
			}
		}
		return node.wordEnd;
	}
	
}