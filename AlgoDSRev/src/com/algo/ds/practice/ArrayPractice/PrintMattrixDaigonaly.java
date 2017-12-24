package com.algo.ds.practice.ArrayPractice;

public class PrintMattrixDaigonaly {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		try {
			int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
					{ 13, 14, 15, 16 }, { 17, 18, 19, 20 }, };
			new PrintMattrixDaigonaly().printMattrix(a, 4);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void printMattrix(int[][] a, int n) {
		try {
			for (int i = 0; i < 2 * n; i++) {
				for (int j = 0; j <= i; j++) {
					if (j < n && (i - j) < n) {
						System.out.print(a[i - j][j] + " ");
					}
				}
				System.out.println();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
