package com.algo.ds.practice.ArrayPractice;

public class SegregateEvenOdd {

	/**
	 * @param args
	 */
	static int[] a;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			a = new int[] { 12, 34, 45, 9, 8, 90, 3 };
			new SegregateEvenOdd().segregateEvenOdd();
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void segregateEvenOdd() {
		try {
			int left = 0;
			int right = a.length - 1;
			while (left < right) {
				while (a[left] % 2 == 0 && left < right) {
					left++;
				}
				while (a[right] % 2 == 1 && left < right) {
					right--;
				}
				if (left < right) {
					swap(left, right);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void swap(int i, int j) {
		try {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
