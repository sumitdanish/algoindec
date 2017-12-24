package com.algo.ds.practice.ArrayPractice;

public class Sort0s1s2s {

	/**
	 * @param args
	 * 
	 *            The Algo implements behind this algo is Dutch Flag Problem
	 * 
	 * 
	 */
	static int[] a;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		a = new int[] { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		Sort0s1s2s so = new Sort0s1s2s();
		so.sort0s1s2s();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}

	}

	private void sort0s1s2s() {
		try {
			int low = 0;
			int mid = 0;
			int hi = a.length - 1;
			while (mid <= hi) {
				switch (a[mid]) {
				case 0:
					swap(low++, mid++);
					break;
				case 1:
					mid++;
					break;
				case 2:
					swap(mid, hi--);
					break;
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
