package com.algo.ds.practice.ArrayPractice;

public class MajorityOfElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { 1, 2, 3, 3, 3, 3, 10 };
			int ind = new MajorityOfElement().binarySearch(a, 0, a.length - 1,
					3);
			if (ind != -1) {
				if ((ind + (a.length) / 2) <= a.length - 1
						&& a[ind + ((a.length) / 2)] == 3) {
					System.out.println("Majority");
				} else {
					System.out.println("Yes its not majority");
				}
			}
			System.out.println(ind + " > " + (a.length) / 2);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int binarySearch(int[] a, int left, int right, int key) {
		try {
			if (left <= right) {
				int mid = (left + right) / 2;
				if (mid == 0 || (key >= a[mid - 1] && a[mid] == key)) {
					return mid;
				}
				if (key < a[mid])
					return binarySearch(a, left, mid - 1, key);
				else
					return binarySearch(a, mid + 1, right, key);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
