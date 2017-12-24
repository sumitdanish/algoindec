package com.algo.ds.practice.ArrayPractice;

public class MaxLengthOfEqual1sAnd0s {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 1, 0, 1, 1, 1, 0, 0 };
			new MaxLengthOfEqual1sAnd0s().max0sAnd1s(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void max0sAnd1s(int[] a) {
		try {
			int max_len = 0;
			int sum = 0;
			int st = 0;
			int end = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] == 0) {
					sum = -1;
				}
				if (a[i] == 1) {
					sum = 1;
				}
				int j;
				for (j = i + 1; j < a.length; j++) {
					if (a[j] == 0) {
						sum = sum - 1;
					} else if (a[j] == 1) {
						sum = sum + 1;
					}
					if (sum == 0 && max_len < j - i + 1) {
						st = i;
						end = j;
						max_len = j - i + 1;
					}

				}

			}

			System.out.println("Max Len > " + max_len + " > start : " + st
					+ " > end" + end);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
