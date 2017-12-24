package com.algo.ds.practice.ArrayPractice;

public class SearchElementInMattrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[][] mat = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 },
					{ 27, 29, 37, 48 }, { 32, 33, 39, 50 }, };
			new SearchElementInMattrix().serarch(mat, 4, 4, 37);
			new SearchElementInMattrix().binarSearch(mat, 0, 3, 0, 3, 37);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void serarch(int[][] mat, int col, int row, int key) {
		try {
			int c = col - 1;
			int r = 0;
			while (c >= 0 && r < row - 1) {
				if (mat[r][c] == key) {
					System.out.println("oiuyiuy");
					return;
				} else {
					if (mat[r][c] > key) {
						c--;
					} else {
						r++;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void binarSearch(int[][] mat, int fc, int tc, int fr, int tr,
			int key) {
		try {
			int midC = (fc + tc) / 2;
			int midR = (fr + tr) / 2;
			if (mat[midR][midC] == key) {
				System.out.println("Got..");
				return;
			} else {
				if (midR != tr && midC != tc) {
					binarSearch(mat, midC, tc, fr, midR, key);
				}
				if (fc + 1 == tc && fr == tr) {
					if (mat[tr][tc] == key) {
						System.out.println("Get it..");
					}
				} else {
					if (mat[midR][midC] < key) {
						if (midR + 1 <= tr) {
							binarSearch(mat, fc, tc, midR + 1, tr, key);
						}
					} else if (mat[midR][midC] > key) {
						if (midC - 1 > fc) {
							binarSearch(mat, midC - 1, tc, fr, tr, key);
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
