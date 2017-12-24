package com.algo.ds.practice.ArrayPractice;

public class NumberOfIsland {

	/**
	 * @param args
	 */
	static int M = 5;
	static int N = 5;
	static int DIR = 8;

	public static void main(String[] args) {

		try {
			int[][] mattrix = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 },
					{ 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };

			int count = new NumberOfIsland().getIsland(mattrix);
			System.out.println(count);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getIsland(int[][] mattrix) {
		try {
			boolean[][] isVisited = new boolean[M][N];
			int count = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					isVisited[i][j] = false;
				}
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (mattrix[i][j] == 1 && isVisited[i][j] == false) {
						getNumberOfIsland(mattrix, i, j, isVisited);
						count++;
					}
				}
			}
			return count;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void getNumberOfIsland(int[][] mattrix, int row, int col,
			boolean[][] isVisited) {
		try {
			/*
			 * The co-ordinate position is defined corresponding to every
			 * cell... suppose we are in the some particular postion in the
			 * cell.. then that cell have total number of eight possible
			 * movement.. so for every cell can move in any direction and then
			 * we can find number of 1's connected with that cell..
			 * 
			 * 
			 * 
			 * Try urself... find the isLand which have maximum land.. which
			 * have maximum number of 1's
			 */
			int[] rowPosition = { 1, -1, -1, 0, 0, 1, 1, -1 };
			int[] colPosition = { 1, 0, 1, -1, 1, -1, 0, -1 };
			isVisited[row][col] = true;
			for (int i = 0; i < DIR; i++) {
				if (row + rowPosition[i] < M
						&& col + colPosition[i] < N
						&& isValidate(mattrix, row + rowPosition[i], col
								+ colPosition[i], isVisited)) {
					getNumberOfIsland(mattrix, row + rowPosition[i], col
							+ colPosition[i], isVisited);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private boolean isValidate(int[][] m, int row, int col,
			boolean[][] isVisited) {
		try {
			if (row < M && col < N && !isVisited[row][col] && m[row][col] == 1) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
