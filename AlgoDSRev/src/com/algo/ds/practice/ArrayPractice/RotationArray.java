package com.algo.ds.practice.ArrayPractice;

public class RotationArray {

	/**
	 * @param args
	 */

	static int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int d = 3;
			new RotationArray().rotate(d);
			for (int a1 : a) {
				System.out.print(a1 + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void blockSwapping(int n, int d) {
		try {
			if (d == n) {
				return;
			}
			if (d == n - d) {
				swapingBlock(0, n - d, d);
				return;
			}
			if (d < n - d) {
				swapingBlock(0, n - d, d);
				blockSwapping(d, n - d);
			}
			if (d > n - d) {
				swapingBlock(0, d, n - d);
				blockSwapping(2 * n - d, d);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void swapingBlock(int fi, int si, int d) {
		try {
			for (int i = 0; i < d; i++) {
				int temp = a[fi + i];
				a[fi + i] = a[si + i];
				a[si + i] = temp;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void rotate(int d) {
		try {
			for (int i = 0; i < d; i++) {
				swap();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void swap() {
		try {
			int temp = a[0];
			int i = 0;
			for (i = 0; i < a.length - 1; i++) {
				a[i] = a[i + 1];
			}
			a[i] = temp;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
