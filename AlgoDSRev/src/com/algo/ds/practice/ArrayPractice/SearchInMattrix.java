package com.algo.ds.practice.ArrayPractice;

public class SearchInMattrix {

	public static void main(String[] args) {
		try {
			int[][] a = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 },
					{ 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
			int key = 29;
			int fromRow = 0;
			int fromColumn = 0;
			int toRow = 3;
			int toColumn = 3;

			new SearchInMattrix().isFind(a, fromRow, toRow, fromColumn,
					toColumn, key);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void isFind(int[][] a, int fromRow, int toRow, int fromColumn,
			int toColumn, int key) {
		try {
			int midC = (fromColumn + toColumn) / 2;
			int midR = (fromRow + toRow) / 2;

			if (a[midR][midC] == key) {
				System.out.println("Got it.." + midC + " > " + midR);
				return;
			} else {
				if (midR != toRow && midC != toColumn) {
					isFind(a, fromRow, midR, midC, toColumn, key);
				}
				/* This is the condition when our matrix is 1X2 */
				if (fromRow == toRow && fromColumn + 1 == toColumn) {
					if (a[toRow][toColumn] == key) {
						System.out.println("Got it..sdf");
						return;
					}
				}
				if (a[midR][midC] < key) {
					if (midR + 1 <= toRow) {
						isFind(a, midR + 1, toRow, fromColumn, toColumn, key);
					}
				}
				if (a[midR][midC] > key) {
					if (midC - 1 >= fromColumn) {
						isFind(a, fromRow, toRow, fromColumn, midC - 1, key);
					}
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
