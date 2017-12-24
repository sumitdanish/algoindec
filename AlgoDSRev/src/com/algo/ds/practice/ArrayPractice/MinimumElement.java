package com.algo.ds.practice.ArrayPractice;

public class MinimumElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { 5, 3, 3, 4, 4, 4, 4, 5, 3, 3 };
			int ind = new MinimumElement().getMinimumIndex(a, 0, a.length - 1);
			System.out.println(ind);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getMinimumIndex(int[] a, int left, int right) {
		try {
			if (right < left) {
				return a[0];
			}
			if (left == right) {
				return left;
			}
			int mid = left + (right - left) / 2;
			if (mid - 1 > left && a[mid] < a[mid - 1]) {
				return mid;
			} else if (a[mid - 1] == a[mid] && a[mid] == a[mid + 1]) {
				return getMin(getMinimumIndex(a, left, mid - 1),
						getMinimumIndex(a, mid + 1, right));
			}
			if (mid + 1 < right && a[mid] > a[mid + 1]) {
				return mid;
			}

			else if (a[mid] < a[right]) {
				return getMinimumIndex(a, left, mid - 1);
			}

			return getMinimumIndex(a, mid + 1, right);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMin(int a, int b) {
		try {
			return a > b ? b : a;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}
}
