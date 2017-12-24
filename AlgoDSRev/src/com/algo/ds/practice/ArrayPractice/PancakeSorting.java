package com.algo.ds.practice.ArrayPractice;

public class PancakeSorting {

	/**
	 * @param args
	 */
	static int[] a = { 18, 40, 35, 12, 30, 35, 20, 6, 90, 80 };;

	public static void main(String[] args) {

		try {
			new PancakeSorting().pancake(a);
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void flip(int[] a, int endPoint) {
		try {
			int i = 0;
			int j = endPoint;
			while (i <= j) {
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				j--;
				i++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int ceilingPoint(int[] a, int low, int high, int key) {
		try {
			int mid = (low + high) / 2;
			if (a[mid] == key) {
				return mid;
			}
			if (a[mid] < key) {
				if (mid + 1 < high && a[mid + 1] >= key) {
					return mid + 1;
				}
				return ceilingPoint(a, mid + 1, high, key);
			}
			if (a[mid] > key) {
				if (mid - 1 > low && a[mid - 1] < key) {
					return mid;
				}
				return ceilingPoint(a, low, mid - 1, key);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void pancake(int[] a) {
		int ceIndex = 0;
		for (int i = 1; i < a.length; i++) {
			ceIndex = ceilingPoint(a, 0, i, a[i]);
			if (ceIndex != i) {
				flip(a, ceIndex - 1);
				flip(a, i - 1);
				flip(a, i);
				flip(a, ceIndex);
			}
		}
	}

}
