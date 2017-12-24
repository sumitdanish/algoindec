package com.algo.ds.practice.ArrayPractice;

public class MinDistanceBwTwoElementInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 3, 5, 6, 2, 6, 5, 6, 6, 5, 4, 8, 3 };
			int x = 3;
			int y = 6;
			int min = new MinDistanceBwTwoElementInArray().minDistance(a, x, y);
			System.out.println(min);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int minDistance(int[] a, int x, int y) {
		try {
			int pre = 0;
			int i = 0;
			int min = Integer.MAX_VALUE;
			for (i = 0; i < a.length; i++) {
				if (a[i] == x || a[i] == y) {
					pre = i;
					break;
				}
			}
			for (; i < a.length; i++) {
				if (a[i] == x || a[i] == y) {
					if ((a[i] != a[pre]) && min > Math.abs(i - pre)) {
						min = Math.abs(i - pre);
					} else {
						pre = i;
					}
				}
			}
			return min;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
