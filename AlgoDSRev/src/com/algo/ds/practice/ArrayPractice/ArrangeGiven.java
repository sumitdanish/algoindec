package com.algo.ds.practice.ArrayPractice;

public class ArrangeGiven {

	/**
	 * @param args
	 */

	static int[] a = { 1, 34, 3, 98, 9, 76, 45, 4 };

	public static void main(String[] args) {

		try {
			new ArrangeGiven().quickSort(0, a.length - 1);
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getNumber(int x, int y) {
		try {
			int num = y;
			int i = 3;
			int x1 = 1;
			while (y > 0 && i > 0) {
				y /= 10;
				x1 *= Math.pow(10, 1);
			}
			x = (x * x1);
			x = x + num;
			return x;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void quickSort(int left, int right) {
		try {
			int p = a[(left + right) / 2];
			int i = left;
			int j = right;
			while (i <= j) {
				while (p > a[i]) {
					i++;
				}
				while (p < a[j]) {
					j--;
				}
				if (i <= j) {
					int num1 = getNumber(a[i], a[j]);
					int num2 = getNumber(a[j], a[i]);
					if (num2 > num1) {
						int temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					} else if (num2 < num1) {
						int temp = a[j];
						a[j] = a[i];
						a[i] = temp;
					} else if (num1 == num2) {
						int temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}
					i++;
					j--;
				}
				if (i < right) {
					quickSort(i, right);
				}
				if (j > left) {
					quickSort(left, j);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
