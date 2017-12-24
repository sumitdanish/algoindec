package com.algo.ds.practice.ArrayPractice;

public class RotateMattrix90 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
			new RotateMattrix90().rotate(mat, 3, 4);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void rotate(int[][] mat, int r, int c) {
		try {
			int[][] roMat = new int[c][r];
			System.out.println("Befor Rotation...");
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(mat[i][j] + ",");
				}
				System.out.println();
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					roMat[c - i - 1][r - j - 1] = mat[i][j];
				}
			}
			System.out.println("\n AFter Rotation");
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(roMat[i][j] + ",");
				}
				System.out.println();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
