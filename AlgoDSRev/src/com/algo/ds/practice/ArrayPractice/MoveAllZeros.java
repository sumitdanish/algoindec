package com.algo.ds.practice.ArrayPractice;

public class MoveAllZeros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0 };
			new MoveAllZeros().moveAllZero(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void moveAllZero(int[] a) {
		int len = a.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (a[i] != 0) {
				a[count] = a[i];
				count++;
			}
		}
		while (count < len) {
			a[count] = 0;
			count++;
		}
		for (int i = 0; i < count; i++) {
			System.out.print(a[i] + ",");
		}
	}

}
