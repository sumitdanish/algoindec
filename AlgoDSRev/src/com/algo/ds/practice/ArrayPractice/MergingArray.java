package com.algo.ds.practice.ArrayPractice;

public class MergingArray {

	/**
	 * @param args
	 * 
	 *            Merge an array of size n into another array of size m+n
	 * 
	 */
	static int[] a = { 2, 8, 0, 0, 0, 13, 0, 15, 20 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			MergingArray me = new MergingArray();
			int[] a1 = { 5, 7, 9, 25 };
			me.merge(a1);
			for (int a11 : a) {
				System.out.print(a11 + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int slideArray() {
		try {
			int j = a.length - 1;
			for (int i = a.length - 1; i >= 0; i--) {
				if (a[i] != 0) {
					a[j] = a[i];
					j--;
				}
			}
			return j;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void merge(int[] a1) {
		try {
			int i = 0;
			int j = slideArray();
			int k = 0;
			while (k < a.length && i < a1.length && j < a.length) {
				if (a[j] <= a1[i]) {
					a[k] = a[j];
					k++;
					j++;
				} else if (a[j] > a1[i]) {
					a[k] = a1[i];
					k++;
					i++;
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
