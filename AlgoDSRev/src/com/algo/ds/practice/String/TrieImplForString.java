package com.algo.ds.practice.String;

import java.util.HashMap;
import java.util.LinkedList;

public class TrieImplForString {

	/**
	 * @param args
	 */

	TrieUsingMap root;

	public TrieImplForString() {
		root = new TrieUsingMap((char) 0);

	}

	public static void main(String[] args) {

		try {
			TrieImplForString dict = new TrieImplForString();
			dict.insert("are");
			dict.insert("area");
			dict.insert("basem");
			dict.insert("ba");
			dict.insert("cat");
			dict.insert("cater");
			dict.insert("basement");
			dict.searchString("ba");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void insert(String word) {
		try {
			TrieUsingMap tr = root;
			for (int i = 0; i < word.length(); i++) {
				HashMap<Character, TrieUsingMap> trChild = tr.getTriList();
				char ch = word.charAt(i);
				if (trChild.containsKey(ch)) {
					tr = trChild.get(ch);
				} else {
					TrieUsingMap t = new TrieUsingMap(ch);
					trChild.put(ch, t);
					tr = t;
				}
			}
			tr.setEnd(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private boolean searchString(String word) {
		try {
			TrieUsingMap tr = root;
			String result = new String();
			int lastIndex = 0;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				HashMap<Character, TrieUsingMap> trChild = tr.getTriList();
				if (trChild.containsKey(ch)) {
					result += String.valueOf(ch);
					tr = trChild.get(ch);
					if (tr.isEnd()) {
						lastIndex = i + 1;// It will give the length of the
											// matched String
					}
				} else {
					break;
				}
			}
			if (!tr.isEnd()) {
				System.out.println(result.substring(0, lastIndex) + " > "
						+ lastIndex);
			} else {
				System.out.println(result);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}

	class TrieUsingMap {
		private boolean isEnd;
		private char val;
		private HashMap<Character, TrieUsingMap> triList;

		public TrieUsingMap(char val) {
			super();
			this.isEnd = false;
			this.val = val;
			this.triList = new HashMap<Character, TrieUsingMap>();
		}

		public boolean isEnd() {
			return isEnd;
		}

		public void setEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}

		public char getVal() {
			return val;
		}

		public void setVal(char val) {
			this.val = val;
		}

		public HashMap<Character, TrieUsingMap> getTriList() {
			return triList;
		}

		public void setTriList(HashMap<Character, TrieUsingMap> triList) {
			this.triList = triList;
		}

	}

}
