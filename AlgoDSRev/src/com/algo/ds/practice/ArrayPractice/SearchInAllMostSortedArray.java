package com.algo.ds.practice.ArrayPractice;

public class SearchInAllMostSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 2, 3, 10, 4, 40 };
			int key = 4;
			int ind = new SearchInAllMostSortedArray().binarySearch(a, 0,
					a.length - 1, key);
			System.out.println(ind);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int binarySearch(int[] a, int l, int r, int key) {
		try {
			int mid = (l + r) / 2;
			if (a[mid] == key) {
				return mid;
			}
			if (a[mid + 1] == key) {
				return mid + 1;
			}
			if (a[mid - 1] == key) {
				return mid - 1;
			}
			if (key < a[mid] && mid - 2 > l) {
				return binarySearch(a, mid - 2, l, key);
			}
			if (key > a[mid] && mid + 2 < r) {
				return binarySearch(a, mid + 2, r, key);
			}
			return -1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
