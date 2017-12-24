package com.algo.ds.practice.ArrayPractice;

public class FindMaximumElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { 1, 3, 50, 10, 9, 7, 6 };
			int m = new FindMaximumElement().getMax(a, 0, a.length);
			System.out.println(m + " > " + a[m]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getMax(int[] a, int left, int right) {
		try {
			if (left > right) {
				return -1;
			}
			if (right == left + 1 && a[right] < a[left]) {
				return left;
			}
			if (right == left + 1 && a[right] > a[left]) {
				return right;
			}
			int mid = (left + right) / 2;
			if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
				return mid;
			}
			if (a[mid] > a[mid + 1] && a[mid] < a[mid - 1]) {
				return getMax(a, left, mid - 1);
			} else {
				return getMax(a, mid + 1, right);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
