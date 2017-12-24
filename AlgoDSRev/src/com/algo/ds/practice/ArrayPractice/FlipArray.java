package com.algo.ds.practice.ArrayPractice;

public class FlipArray {

	/**
	 * @param args
	 */

	static int[] a = { 23, 10, 20, 11, 12, 6, 7 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new FlipArray().flip(a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}

	}

	private void flip(int len) {
		int i = 0;
		int j = len - 1;
		while (i <= j) {
			int temp = a[j];
			a[j] = a[i];
			a[i] = temp;
			i++;
			j--;
		}
	}

}
