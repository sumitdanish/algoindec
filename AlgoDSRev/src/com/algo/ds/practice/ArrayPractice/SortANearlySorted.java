package com.algo.ds.practice.ArrayPractice;

public class SortANearlySorted {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		try {
			int k = 3;
			int a[] = { 2, 6, 3, 12, 56, 8 };
			MinHeapSortNearlySortedArray m = new MinHeapSortNearlySortedArray();
			m.printArray(a, k);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
