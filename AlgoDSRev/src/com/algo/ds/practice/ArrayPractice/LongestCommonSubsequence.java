package com.algo.ds.practice.ArrayPractice;

public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	static int max_so_far = 1;

	public static void main(String[] args) {

		try {
			int[] a = { 10, 22, 9, 33, 21, 50, 41, 60 };
			int lcs = new LongestCommonSubsequence().LCSTab(a);
			System.out.println(lcs);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int LCS(int[] a, int i) {
		try {
			if (i == 1) {
				return 1;
			}
			int res = 0;
			int max_so = 1;
			for (int j = 1; j < i; j++) {
				res = LCS(a, j);
				if (a[j - 1] < a[i - 1] && res + 1 > max_so) {
					max_so = res + 1;
				}
			}
			if (max_so > max_so_far) {
				max_so_far = max_so;
			}
			return max_so;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int LCSTab(int[] a) {
		try {
			int[] lcs = new int[a.length];
			for (int i = 0; i < a.length; i++) {
				lcs[i] = 1;
			}
			for (int i = 1; i < a.length; i++) {
				lcs[i] = 1;
				for (int j = 0; j < i; j++) {
					if (a[i] > a[j] && lcs[i] < lcs[j] + 1) {
						lcs[i] = lcs[j] + 1;
					}
				}
			}
			int max = 0;
			for (int i = 0; i < a.length; i++) {
				if (max < lcs[i]) {
					max = lcs[i];
				}
			}
			return max;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
