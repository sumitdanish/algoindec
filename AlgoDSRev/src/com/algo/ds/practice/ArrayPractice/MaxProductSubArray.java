package com.algo.ds.practice.ArrayPractice;

public class MaxProductSubArray {

	/**
	 * @param args
	 */
	static int max_so_far = 1;

	public static void main(String[] args) {

		try {
			int[] a = { 1, -2, -3, 0, 7, -8, -2 };
			int pro = new MaxProductSubArray().maxProduct(a);
			System.out.println(pro);
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	private int maxProduct(int[] a) {
		try {
			int max_Prod = 1;
			int min_Prod = 1;
			for (int i = 0; i < a.length; i++) {

				if (a[i] > 0) {
					max_Prod *= a[i];
					min_Prod = getMin(min_Prod * a[i], 1);
				}
				if (a[i] == 0) {
					max_Prod = 1;
					min_Prod = 1;
				}
				if (a[i] < 0) {
					int temp = max_Prod;
					max_Prod = min_Prod * a[i];
					min_Prod = temp * a[i];
				}
				if (max_so_far < max_Prod) {
					max_so_far = max_Prod;
				}
			}
			return max_so_far;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMin(int a, int b) {
		try {
			return a >= b ? b : a;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
