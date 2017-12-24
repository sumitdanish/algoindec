package com.algo.ds.practice.ArrayPractice;

public class FindIndexof0sToBeReplacedWith1s {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1 };
			int ind0_s = new FindIndexof0sToBeReplacedWith1s().get0sIndex(a);
			System.out.println(ind0_s);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/* O(N2) */

	private int get0sIndex(int[] a) {
		try {
			int max = 0;
			int ind_0s = 0;
			int count = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] == 0) {
					count = 0;
					for (int j = i + 1; j < a.length; j++) {
						if (a[j] == 1) {
							count++;
						} else {
							break;
						}
					}
					for (int x = i - 1; x >= 0; x--) {
						if (a[x] == 1) {
							count++;
						} else {
							break;
						}
					}
					if (count > max) {
						max = count;
						ind_0s = i;
					}
				}
			}
			// System.out.println(max+" > "+ind_0s);
			return ind_0s;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	/* Kadane Code */
	private int getIndex0s(int[] a) {
		try {
			int max_so_far = Integer.MIN_VALUE;
			int max_end_here = 0;
			int ind_0s = 0;
			for (int i = 0; i < a.length; i++) {
				/* {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1} */
				if (a[i] == 0) {
					a[i] = -1;
				}
				max_end_here = max_end_here + a[i];
				if (max_end_here <= 0) {
					max_end_here = 0;
				}
				if (a[i] == -1 && max_end_here >= 0
						&& max_so_far < max_end_here) {
					max_so_far = max_end_here;
					ind_0s = i;
				}
			}
			return ind_0s;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
