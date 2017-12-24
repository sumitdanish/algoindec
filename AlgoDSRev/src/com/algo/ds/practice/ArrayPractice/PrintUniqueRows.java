package com.algo.ds.practice.ArrayPractice;

public class PrintUniqueRows {

	/**
	 * @param args
	 */
	static int COL = 5;
	static int ROW = 5;

	public static void main(String[] args) {

		try {
			int[][] a = { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 },
					{ 0, 1, 0, 0, 1 }, { 1, 0, 1, 0, 0 } };
			PrintUniqueRows pr = new PrintUniqueRows();
			for (int i = 0; i < ROW; i++) {
				if (pr.triTreeNode(null, a, i, 0)) {
					pr.printRow(a, i);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void printRow(int[][] a, int i1) {
		System.out.println();
		for (int i = 0; i < COL; i++) {
			System.out.print(a[i1][i] + ",");
		}

	}

	private boolean triTreeNode(Trie trie, int[][] a, int row, int col) {
		try {
			if (trie == null) {
				trie = new Trie();
			}
			if (col + 1 < COL) {
				return triTreeNode(trie.t[a[row][col]], a, row, col + 1);
			} else {
				if (trie.isEnd == false) {
					trie.isEnd = true;
				}
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	class Trie {
		public boolean isEnd;
		public Trie[] t = new Trie[2];

		public Trie() {
			t[0] = null;
			t[1] = null;
			isEnd = false;
		}

	}

}
