package com.algo.ds.practice.String;

import java.util.HashMap;

public class PatternSearchingUsingTrieTree {

	/**
	 * @param args
	 */
	TrieTree root;

	public PatternSearchingUsingTrieTree() {
		root = new TrieTree((char) 0);
	}

	public static void main(String[] args) {
		try {
			PatternSearchingUsingTrieTree p = new PatternSearchingUsingTrieTree();
			String s = "geeksforgeeks.org";
			for (int i = 0; i < s.length() - 1; i++) {
				p.insert(s.substring(s.length() - (i + 1), s.length()), i + 1);
			}
			p.search("forgeeks");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void insert(String text, int index) {
		try {
			TrieTree tr = root;
			for (int i = 0; i < text.length(); i++) {
				HashMap<Character, TrieTree> child = tr.getChild();
				char ch = text.charAt(i);
				if (child.containsKey(ch)) {
					tr = child.get(ch);
				} else {
					TrieTree t = new TrieTree(ch);
					child.put(ch, t);
					tr = t;
				}
			}
			tr.setIndex(index);
			tr.setEnd(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void search(String text) {
		try {
			TrieTree tr = root;
			String result = new String();
			int index = 0;
			for (int i = 0; i < text.length(); i++) {
				HashMap<Character, TrieTree> child = tr.getChild();
				char ch = text.charAt(i);
				if (child.containsKey(ch)) {
					result += String.valueOf(ch);
					// tr=child.get(ch);
					System.out.print(result + ",");
					if (result.equals(text)) {
						System.out.println("Found at index > "
								+ child.get(ch).getIndex());
					}
				}
			}
			if (result.equals(text)) {

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	class TrieTree {
		private char val;
		private boolean isEnd;
		private int index;
		HashMap<Character, TrieTree> child = new HashMap<Character, TrieTree>();

		public TrieTree(char val) {
			super();
			this.val = val;
		}

		public char getVal() {
			return val;
		}

		public void setVal(char val) {
			this.val = val;
		}

		public boolean isEnd() {
			return isEnd;
		}

		public void setEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}

		public HashMap<Character, TrieTree> getChild() {
			return child;
		}

		public void setChild(HashMap<Character, TrieTree> child) {
			this.child = child;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

	}

}
