package com.algo.ds.practice.ArrayPractice;

public class MedianOfTwoSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a1 = { 1, 12, 15, 26, 38 };
			int[] a2 = { 2, 13, 17, 30, 45 };
			int median = new MedianOfTwoSortedArray().getMeadian(a1, a2,
					a1.length - 1);// new MedianOfTwoSortedArray().binary(a1,
									// a2,0,a1.length,a1.length);
			System.out.println(median);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public int getMeadian(int[] a1, int[] a2, int n) {
		try {
			int m1 = 0;
			int m2 = 0;
			int i = 0;
			int j = 0;
			for (i = 0; i < a1.length; i++) {
				if (i == n) {
					m1 = m2;
					m2 = a2[0];
					break;
				} else if (j == n) {
					m1 = m2;
					m2 = a1[0];
					break;
				} else if (a1[i] < a2[j]) {
					m1 = m2;
					m2 = a1[i];
					i++;
				} else {
					m1 = m2;
					m2 = a2[j];
					j++;
				}
			}
			return (m1 + m2) / 2;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int binary(int[] a1, int[] a2, int low, int high, int n) {
		try {
			if (low > high) {
				return binary(a2, a1, 0, n - 1, n);
			}
			int i = (low + high) / 2;
			int j = n - i - 1;// By using this equation we can get mid point of
								// the 2nd array
			if (a1[i] > a2[j] && a1[i] < a2[j + 1] && j + 1 < n) {
				System.out.println(a1[i] + " > " + a2[j]);
				return (a1[i] + a2[j]) / 2;
			} else {
				if (a1[i] > a2[j]) {
					return binary(a1, a2, low, i - 1, n);
				} else if (a1[i] < a2[j]) {
					return binary(a1, a2, i + 1, high, n);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
