package com.algo.ds.practice.ArrayPractice;

public class MaximunNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 2, 3, 3, 5, 3, 4, 1, 7 };
			int k = 8;
			new MaximunNumber().getMaxNumber(a, k);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void getMaxNumber(int[] a, int k) {
		try {
			int i = 0;
			for (i = 0; i < a.length; i++) {
				a[a[i] % k] += k;
			}
			int maxR = 0;
			int ind = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[j] > maxR) {
					maxR = a[j];
					ind = j;
				}
			}
			System.out.println("Index > " + ind + " Val > " + a[ind]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
