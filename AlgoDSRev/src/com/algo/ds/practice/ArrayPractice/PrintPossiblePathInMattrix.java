package com.algo.ds.practice.ArrayPractice;

public class PrintPossiblePathInMattrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 } };
			int[] path = new int[6];
			new PrintPossiblePathInMattrix()
					.printPath(mat, 0, 0, 2, 3, 0, path);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void printPath(int[][] m, int i, int j, int row, int col, int pi,
			int[] path) {
		try {
			if (i == row) {
				for (int k = j; k < col; k++) {
					path[pi + k - j] = m[i][k];
				}
				for (int i1 = 0; i1 < pi + row - i; i1++) {
					System.out.print(path[i1] + ",");
				}
				return;
			}
			path[pi] = m[i][j];
			printPath(m, i + 1, j, row, col, pi + 1, path);
			printPath(m, i , j+1, row, col, pi + 1, path);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
