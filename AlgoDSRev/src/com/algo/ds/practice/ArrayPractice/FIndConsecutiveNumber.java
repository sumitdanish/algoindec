package com.algo.ds.practice.ArrayPractice;

public class FIndConsecutiveNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { -1, 0, 1, 4, 5, 3, 2, 6 };
			if (new FIndConsecutiveNumber().isConsecutive1(a)) {
				System.out.println("Yes Its");
			} else {
				System.out.println("Its Not!!!!!!!!!!!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/* Time complextity O(N), SPace complexity O(N) */
	private boolean isConsecutive(int[] a) {
		try {
			boolean[] isVisisted = new boolean[a.length];
			for (int i = 0; i < a.length; i++) {
				isVisisted[i] = false;
			}
			int max = getMax(a);
			int min = getMin(a);
			if ((max - min) == (a.length - 1)) {
				for (int i = 0; i < a.length; i++) {
					if (isVisisted[a[i] - min] == true) {
						return false;
					}
					isVisisted[a[i] - min] = true;
				}
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private boolean isConsecutive1(int[] a) {
		try {
			int min = getMin(a);
			int max = getMax(a);
			if ((max - min) == (a.length - 1)) {
				for (int i = 0; i < a.length; i++) {
					int j = 0;
					if (a[i] < 0) {
						j = -a[i] - min;
						System.out.println(" > q" + a[i]);
					} else {
						j = a[i] - min;
						System.out.println(" > q > " + j);
					}

					if (a[j] >= 0) {
						a[j] = -a[j];
					} else {
						return false;
					}
				}
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private int getMin(int[] a) {
		try {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < a.length; i++) {
				if (min > a[i]) {
					min = a[i];
				}
			}
			return min;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMax(int[] a) {
		try {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < a.length; i++) {
				if (max < a[i]) {
					max = a[i];
				}
			}
			return max;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}
}
