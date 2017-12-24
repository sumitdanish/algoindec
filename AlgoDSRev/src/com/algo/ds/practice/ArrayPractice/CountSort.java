package com.algo.ds.practice.ArrayPractice;

public class CountSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		try {
			int[] a = { 1, 4, 1, 2, 7, 5, 2 };
			int k = 9;
			new CountSort().countSort(a, k);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void countSort(int[] a, int k) {
		int[] count = new int[k + 1];
		int[] op = new int[k + 1];

		for (int i = 0; i < a.length; i++) {
			count[a[i]]++;
		}
		for (int i = 1; i < k; i++) {
			count[i] += count[i - 1];
		}
		for (int i = 0; i < a.length; i++) {
			op[count[a[i]] - 1] = a[i];
			count[a[i]]--;
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = op[i];
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}

}
