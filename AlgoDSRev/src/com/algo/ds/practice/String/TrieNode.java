package com.algo.ds.practice.String;

import java.util.LinkedList;

public class TrieNode {

	private char val;
	private boolean isEnd;
	private TrieNode trieNode;
	private LinkedList<TrieNode> trieList;

	public TrieNode(char val) {
		super();
		this.val = val;
		this.isEnd = false;
		this.trieList = new LinkedList<TrieNode>();
	}

	public TrieNode() {

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

	public TrieNode getTrieNode() {
		return trieNode;
	}

	public void setTrieNode(TrieNode trieNode) {
		this.trieNode = trieNode;
	}

	public LinkedList<TrieNode> getTrieList() {
		return trieList;
	}

	public void setTrieList(LinkedList<TrieNode> trieList) {
		this.trieList = trieList;
	}

	public TrieNode isSubChild(char ch, LinkedList<TrieNode> trieNode) {
		try {
			for (TrieNode node : trieNode) {
				if (node.getVal() == ch) {
					setTrieNode(node);
					System.out.println(ch);
					return node;
				}
			}
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
