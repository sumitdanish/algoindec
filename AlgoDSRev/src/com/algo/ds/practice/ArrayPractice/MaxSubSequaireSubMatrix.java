package com.algo.ds.practice.ArrayPractice;

public class MaxSubSequaireSubMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[][] mat = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 },
					{ 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
					{ 0, 0, 0, 0, 0 }, };
			new MaxSubSequaireSubMatrix().matrix(mat);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void matrix(int[][] mat) {
		try {
			int[][] s = new int[6][5];
			int max = 0;
			int max_i = 0;
			int max_j = 0;
			for (int i = 0; i < 5; i++) {
				s[0][i] = mat[0][i];
			}
			for (int i = 0; i < 6; i++) {
				s[i][0] = mat[i][0];
			}
			for (int i = 1; i < 6; i++) {
				for (int j = 1; j < 5; j++) {
					if (mat[i][j] == 1) {
						s[i][j] = getMin(s[i - 1][j], getMin(s[i][j - 1],
								s[i - 1][j - 1])) + 1;
					} else {
						s[i][j] = 0;
					}
				}
			}
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 5; j++) {
					if (max < s[i][j]) {
						max = s[i][j];
						max_i = i;
						max_j = j;
					}
				}
			}
			// System.out.println(max+" > "+max_i+" > "+" > "+max_j+"\n");
			for (int i = max_i; i > max_i - max; i--) {
				for (int j = max_j; j > max_j - max; j--) {
					System.out.print(mat[i][j] + ",");
				}
				System.out.println();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int getMin(int a, int b) {
		try {
			return a > b ? b : a;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
