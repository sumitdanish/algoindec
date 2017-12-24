package com.algo.ds.practice.ArrayPractice;

public class MattrixPrinting {

	/**
	 * @param args
	 * 
	 *            X X X X X X X X 0 0 0 0 0 X X 0 X X X 0 X X 0 X X X 0 X X 0 0
	 *            0 0 0 X X X X X X X X
	 * 
	 * 
	 */
	public static void main(String[] args) {

		try {
			int m = 7;
			int n = 7;
			MattrixPrinting mp = new MattrixPrinting();
			mp.printMattrix(m, n);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void printMattrix(int m, int n) {
		try {
			char x = 'x';
			char[][] a = new char[m][n];
			int i = 0;
			int j = 0;
			int m1 = m;
			int n1 = n;
			while (i < m && j < n) {
				for (int j1 = j; j1 < n; j1++) {
					a[i][j1] = x;
				}
				i++;
				for (int l = i; l < m; l++) {
					a[l][n - 1] = x;
				}
				n--;
				if (i < m) {
					for (int i_i = n - 1; i_i > j; i_i--) {
						a[m - 1][i_i] = x;
					}
					m--;
				}
				if (j < n) {
					for (int j1 = m - 1; j1 >= i; j1--) {
						a[j1][j] = x;
					}
					j++;
				}
				x = (x == 'x' ? '0' : 'x');
			}
			for (int p = 0; p < m1; p++) {
				for (int p1 = 0; p1 < n1; p1++) {
					System.out.print(a[p][p1]);
				}
				System.out.println();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
