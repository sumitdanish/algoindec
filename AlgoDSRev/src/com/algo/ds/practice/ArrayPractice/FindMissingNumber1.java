package com.algo.ds.practice.ArrayPractice;

public class FindMissingNumber1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { 0, 1, 2, 6, 9 };
			int n = 5;/*
					 * Total number of element in the array this is the optional
					 * but value in the array should be there
					 */
			int m = 10;/* Total size of the array */
			int ele = new FindMissingNumber1().binarySearch(a, 0, m - 1);
			System.out.println(ele);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int binarySearch(int[] a, int left, int right) {
		try {
			if (a[left] != left) {
				return left;
			}
			int mid = (left + right) / 2;
			if (a[mid] > mid) {
				return binarySearch(a, left, mid - 1);
			}
			return binarySearch(a, mid + 1, right);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
