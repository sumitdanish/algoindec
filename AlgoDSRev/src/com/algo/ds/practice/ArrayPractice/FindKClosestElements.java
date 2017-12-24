package com.algo.ds.practice.ArrayPractice;

public class FindKClosestElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
			int k = 35;
			int co = 4;
			FindKClosestElements fk = new FindKClosestElements();
			fk.closestElement(a, k, co);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void closestElement(int[] a, int key, int co) {
		try {
			int ind = binary(a, 0, a.length, key);
			int count = 0;
			ind = ind - 1;
			int r = ind + 1;
			while (ind > 0 && r < a.length && count < 4) {
				if (key - a[ind] <= a[r] - key) {
					System.out.print(a[ind] + ",");
					ind--;
				} else {
					System.out.print(a[r] + ",");
					r++;
				}
				count++;
			}
			while (ind > 0 && count < 4) {
				System.out.print(a[ind] + ",");
				ind--;
			}
			while (r < a.length && count < 4) {
				System.out.print(a[r] + ",");
				r++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int binary(int[] a, int l, int r, int key) {
		try {
			int mid = (l + r) / 2;
			if (a[mid] == key) {
				return mid;
			} else if (mid - 1 > l && a[mid] > key) {
				return binary(a, l, mid - 1, key);
			} else if (mid + 1 < r && a[mid] < key) {
				return binary(a, mid + 1, r, key);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
