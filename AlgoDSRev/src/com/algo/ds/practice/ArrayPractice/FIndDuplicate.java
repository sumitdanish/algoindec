package com.algo.ds.practice.ArrayPractice;

public class FIndDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { 1, 1, 2, 2, 2, 2, 3 };
			int x = 2;
			FIndDuplicate f = new FIndDuplicate();
			int fo = f.getFirstOccurenceBinarySearch(a, 0, a.length - 1, x);
			int so = f.getLastOccurence(a, fo, a.length - 1, x);
			System.out.println(fo + " > " + so);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getFirstOccurenceBinarySearch(int[] a, int left, int right,
			int key) {
		try {
			if (a[left] == key) {
				return left;
			}
			if (a[right] == key) {
				return right;
			}
			int mid = (left + right) / 2;
			if (mid == 0 || (key > a[mid - 1] && a[mid] == key)) {
				return mid;
			}
			if (a[mid] > key) {
				return getFirstOccurenceBinarySearch(a, left, mid - 1, key);
			}
			return getFirstOccurenceBinarySearch(a, mid + 1, right, key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getLastOccurence(int[] a, int left, int right, int key) {
		try {
			// if(a[left]==key)
			// {
			// return left;
			// }
			// if(a[right]==key)
			// {
			// return right;
			// }
			int mid = (left + right) / 2;
			if (mid == right || (a[mid + 1] > key && a[mid] == key)) {
				return mid;
			} else if (a[mid] > key) {
				return getLastOccurence(a, left, mid - 1, key);
			}
			return getLastOccurence(a, mid + 1, right, key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
