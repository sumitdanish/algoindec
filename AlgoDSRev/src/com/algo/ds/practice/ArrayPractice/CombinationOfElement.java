package com.algo.ds.practice.ArrayPractice;

public class CombinationOfElement {

	/**
	 * @param args
	 */
	static int[] a = { 1, 2, 3, 4, 5, 2, 3, 1 };

	public static void main(String[] args) {

		try {
			int r = 3;
			CombinationOfElement c = new CombinationOfElement();
			c.quick(0, a.length - 1);
			c.combinatioOfElementIfDuplicate(a, new int[3], 0, 0, a.length - 1,
					r);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/* If array have duplicate then that method will not work */
	private void combinationOfNumber(int[] a, int[] data, int index, int start,
			int end, int r) {
		try {
			if (index == r) {
				for (int i = 0; i < index; i++) {
					System.out.print(data[i] + ",");
				}
				System.out.println();
				return;
			}
			/*
			 * Why we are putting end-i+1>=r-index... becz we are shifting 1
			 * element at time in the array from below loop
			 */
			for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
				data[index] = a[i];
				combinationOfNumber(a, data, index + 1, i + 1, end, r);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void combinatioOfElementIfDuplicate(int[] a, int[] data, int index,
			int start, int end, int r) {
		try {
			if (index == r) {
				for (int i = 0; i < index; i++) {
					System.out.print(data[i] + ",");
				}
				System.out.println();
				return;
			}
			for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
				data[index] = a[i];
				while (i + 1 <= end && a[i] == a[i + 1]) {
					i++;
				}
				combinatioOfElementIfDuplicate(a, data, index + 1, i + 1, end,
						r);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**/

	private void quick(int left, int right) {
		try {
			int p = a[(left + right) / 2];
			int i = left;
			int j = right;
			while (i <= j) {
				while (p > a[i]) {
					i++;
				}
				while (p < a[j]) {
					j--;
				}
				if (i <= j) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					i++;
					j--;
				}
				if (i < right) {
					quick(i, right);
				}
				if (j > left) {
					quick(left, j);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
