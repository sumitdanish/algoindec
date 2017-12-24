package com.algo.ds.practice.ArrayPractice;

public class NumberOfTriangle {

	/**
	 * @param args
	 */
	static int[] a = { 10, 21, 22, 102, 100, 300, 200 };

	public static void main(String[] args) {
		try {
			NumberOfTriangle num = new NumberOfTriangle();
			num.quickSort(0, a.length - 1);
			int count = num.getNumberOfTraingle();
			System.out.println(count);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getNumberOfTraingle() {
		try {
			int k = 0;
			int count = 0;
			for (int i = 0; i < a.length - 2; i++) {
				k = i + 2;
				for (int j = i + 1; j < a.length; j++) {
					while (k < a.length && a[i] + a[j] > a[k]) {
						k++;
					}
					count += k - j - 1;
				}
			}
			return count;
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
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
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
