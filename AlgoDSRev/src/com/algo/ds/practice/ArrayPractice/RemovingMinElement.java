package com.algo.ds.practice.ArrayPractice;

public class RemovingMinElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { 4, 5, 100, 9, 10, 11, 12, 15, 200 };
			int len = new RemovingMinElement()
					.getMinElement(a, 0, a.length - 1);
			System.out.println(len);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getMax(int[] a, int l, int h) {
		try {
			int max = Integer.MIN_VALUE;
			for (int i = l; i <= h; i++) {
				if (a[i] > max) {
					max = a[i];
				}
			}
			return max;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMin(int[] a, int l, int h) {
		try {
			int min = Integer.MAX_VALUE;
			for (int i = l; i <= h; i++) {
				if (a[i] < min) {
					min = a[i];
				}
			}
			return min;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMinElement(int[] a, int l, int h) {
		try {
			if (l >= h) {
				return 0;
			}
			int min = getMin(a, l, h);
			int max = getMax(a, l, h);
			if (2 * min > max) {
				return 0;
			}
			return min(getMinElement(a, l + 1, h), getMinElement(a, l, h - 1)) + 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int min(int a, int b) {
		return a > b ? b : a;
	}

}
