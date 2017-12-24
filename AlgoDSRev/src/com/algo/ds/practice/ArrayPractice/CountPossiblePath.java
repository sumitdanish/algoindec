package com.algo.ds.practice.ArrayPractice;

public class CountPossiblePath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[][] mat = new int[5][5];
			int len = new CountPossiblePath().getTotalPath1(mat, 3, 3);
			System.out.println(len);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getTotalPath(int[][] m, int row, int col) {
		try {
			if (row == 1 || col == 1) {
				return 1;
			}
			return getTotalPath(m, row - 1, col)
					+ getTotalPath(m, row, col - 1);// If we are considering
													// cross movement then we
													// can enable
			// +getTotalPath(m, row-1, col-1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getTotalPath1(int[][] mat, int row, int col) {
		try {
			int[][] count = new int[row][col];
			for (int i = 0; i < row; i++) {
				count[i][0] = 1;
			}
			for (int i = 0; i < col; i++) {
				count[0][i] = 1;
			}
			// for(int i=0;i<row;i++)
			// {
			// for(int j=0;j<col;j++)
			// {
			// count[i][j]=1;
			// }
			// }
			for (int i = 1; i < row; i++) {
				for (int j = 1; j < col; j++) {
					count[i][j] = count[i - 1][j] + count[i][j - 1];// If we are
																	// considering
																	// cross
																	// movement
																	// then we
																	// can
																	// enable
					// this line as well as
					// above nested above for loop+count[i-1][j-1];
				}
			}
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					System.out.print(count[i][j] + ",");
				}
				System.out.println();
			}
			return count[row - 1][col - 1];
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
