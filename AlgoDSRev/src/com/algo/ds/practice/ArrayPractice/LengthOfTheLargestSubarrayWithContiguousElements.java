package com.algo.ds.practice.ArrayPractice;

public class LengthOfTheLargestSubarrayWithContiguousElements {

	/**
	 * @param args
	 * 
	 *            The contiguous element in array depends upon the elements Alog
	 *            : 1.a if Array have different element then contiguous is..
	 *            difference between max and min element should be equal to
	 *            difference between last and first index
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 14, 12, 11, 20 };
			int len = new LengthOfTheLargestSubarrayWithContiguousElements()
					.getLenOfConti(a);
			System.out.println(len);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getLenOfConti(int[] a) {
		try {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int max_len = 1;

			for (int i = 0; i < a.length - 1; i++) {
				max = a[i];
				min = a[i];
				for (int j = i + 1; j < a.length; j++) {
					max = getMax(a[j], max);
					min = getMin(a[j], min);
					int dif = max - min;
					if (dif == j - i) {
						max_len = getMax(max_len, ((j - i)));
					}
				}
			}
			return max_len;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMax(int a, int b) {
		try {
			return a > b ? a : b;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMin(int a, int b) {
		try {
			return a < b ? a : b;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}
}
