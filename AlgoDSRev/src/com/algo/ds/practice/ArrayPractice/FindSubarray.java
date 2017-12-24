package com.algo.ds.practice.ArrayPractice;

public class FindSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		try {
			int[] a = { 15, 2, 4, 8, 9, 5, 10, 23 };
			int key = 23;
			new FindSubarray().printStartingIndex(a, key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void printStartingIndex(int[] a, int key) {
		try {
			int cu = a[0];
			int sum = 0;
			int st = 0;
			for (int i = 1; i < a.length; i++) {
				if (cu > key) {
					cu = cu - a[st];
					st++;
				}
				if (cu == key) {
					System.out.println(" > " + st + " > " + (i - 1));
					// break;
				}
				if (i < a.length) {
					cu += a[i];
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
