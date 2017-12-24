package com.algo.ds.practice.ArrayPractice;

public class PrintSubMattrix {

	/**
	 * @param args
	 *            Given an n x n square matrix, find sum of all sub-squares of
	 *            size k x k
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[][] mat = { { 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2 },
					{ 3, 3, 3, 3, 3 }, { 4, 4, 4, 4, 4 }, { 5, 5, 5, 5, 5 }, };
			new PrintSubMattrix().printMatt(mat, 3);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void printMatt(int[][] mat, int k) {
		try {
			for (int i = 0; i < mat.length - k + 1; i++) {
				for (int j = 0; j < mat[i].length - k + 1; j++) {
					int sum = 0;
					for (int p = i; p < k + i; p++) {
						for (int q = j; q < k + j; q++) {
							sum += mat[p][q];
						}
					}
					System.out.print(sum + ",");
				}
				System.out.println();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
