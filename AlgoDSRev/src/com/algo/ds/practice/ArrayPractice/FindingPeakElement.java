package com.algo.ds.practice.ArrayPractice;

public class FindingPeakElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 1, 3, 20, 4, 1, 0 };
			int ind = new FindingPeakElement().peakUsingBinary(a, 0, a.length,
					a.length);
			System.out.println(ind);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int peakUsingBinary(int[] a, int left, int right, int n) {
		try {
			int mid = (left + right) / 2;
			if (mid == 0) {
				return mid;
			}
			if (mid == n - 1) {
				return mid;
			}
			if (a[mid] > a[mid + 1] && a[mid - 1] < a[mid]) {
				return mid;
			} else if (a[mid] < a[mid - 1]) {
				return peakUsingBinary(a, left, mid - 1, n);
			} else if (a[mid] < a[mid + 1]) {
				return peakUsingBinary(a, mid + 1, right, n);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
