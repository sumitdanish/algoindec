package com.algo.ds.practice.ArrayPractice;

public class SmallestSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 1, 4, 45, 6, 10, 19 };
			int x = 51;
			SmallestSubarray sa = new SmallestSubarray();
			int len = sa.minLen1(a, x);
			System.out.println(len);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/* O(n2) */
	private int minLen(int[] a, int x) {
		try {
			int s = 0;
			int e = 0;
			int sum = 0;
			int min = a.length;
			for (int i = 0; i < a.length; i++) {
				sum = a[i];
				if (sum > x) {
					return i;
				}
				for (int j = i + 1; j < a.length - 1; j++) {
					sum += a[j];
					if (min > (j - i + 1) && sum > x) {
						s = i;
						e = j;
						min = j - i + 1;
					}
				}
			}
			System.out.println(s + " > " + e);
			return min;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int minLen1(int[] a, int x) {
		try {
			int s = 0;
			int e = 0;
			int sum = 0;
			int s1 = 0;
			int e1 = 0;
			int min = a.length;
			while (e < a.length) {
				while (sum <= x && e < a.length) {
					sum += a[e];
					e++;
				}
				while (sum > x && s < a.length) {
					if ((e - s) < min) {
						s1 = s;
						e1 = e;
						min = e - s;
					}
					sum -= a[s];
					s++;
				}
				// e++;
			}
			System.out.println(s1 + " > " + e1);
			return min;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
