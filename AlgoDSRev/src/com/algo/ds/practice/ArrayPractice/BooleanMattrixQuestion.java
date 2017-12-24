package com.algo.ds.practice.ArrayPractice;

public class BooleanMattrixQuestion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[][] mat = { { 1, 0 }, { 0, 0 } };
			new BooleanMattrixQuestion().print(mat, 2, 2);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void print(int[][] mat, int c, int r) {
		try {
			int[] col = new int[c];
			int[] row = new int[r];
			// int i=0;
			// for(i=0;i<r;i++);
			// {
			// row[i] = 0;
			// }
			// for(i=0;i<c;i++)
			// {
			// col[i] = 0;
			// }
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					if (mat[j][k] == 1) {
						row[j] = 1;
						col[k] = 1;
					}
				}
			}
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					if (row[j] == 1 || col[k] == 1) {
						mat[j][k] = 1;
					}
				}
			}
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					System.out.print(mat[j][k] + ",");
				}
				System.out.println();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
