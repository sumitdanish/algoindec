package com.algo.ds.practice.ArrayPractice;

public class MaxSumOfContigiousArrayInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 2, -1, 2, 3, 4, -5 };
			new MaxSumOfContigiousArrayInArray().getMaxForNegaAndPost(a);
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	/*
	 * in kadane algo if most the element is -ive then the maximum sum is
	 * allways 0 .. which is not correct
	 */
	private void getSum(int[] a) {
		try {
			int max_so_far = 0;
			int max_end_here = 0;
			int st = 0;
			int st1 = 0;
			int end = 0;
			for (int i = 0; i < a.length; i++) {
				max_end_here = max_end_here + a[i];
				st1 = i;
				if (max_end_here < 0) {
					max_end_here = 0;
					st1 = i + 1;
				}
				if (max_so_far < max_end_here) {
					end = i;
					st = st1;
					max_so_far = max_end_here;
				}
			}
			System.out.println(max_so_far);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void getMaxForNegaAndPost(int[] a) {
		try {
			int max = a[0];
			int current_sum = a[0];
			int st = 0;
			int end = 0;
			for (int i = 1; i < a.length; i++) {
				current_sum = current_sum + a[i];
				st = i;
				if (current_sum < a[i]) {
					current_sum = a[i];
					st = i;
				}
				if (current_sum > max) {
					max = current_sum;
					end = i;
				}
			}
			System.out.println(max);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
