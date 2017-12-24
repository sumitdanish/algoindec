package com.algo.ds.practice.ArrayPractice;

public class PossiblePathInMattrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 } };
			int row = 2;
			int col = 3;
			int in = 0;
			new PossiblePathInMattrix().printPath(mat, 0, 0, col, row,
					in, new int[row + col]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void printPath(int[][] mat, int c, int r, int col, int row, int in,
			int[] path) {
		try {
			if (c <= col && r <= row) {
				path[in] = mat[r][c];
				if (c == col && r == row) {
					for (int i = 0; i <= in; i++) {
						System.out.print(path[i] + ",");
					}
					System.out.println();
					return;
				}
			}
			printPath(mat, c, r + 1, col, row, in + 1, path);
			printPath(mat, c + 1, r, col, row, in + 1, path);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
