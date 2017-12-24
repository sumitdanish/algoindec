package com.algo.ds.practice.ArrayPractice;

public class FloorAndCeling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 1, 2, 4, 8, 10, 11, 12, 19 };
			int floor = new FloorAndCeling().getF(a, 3);
			int ceil = new FloorAndCeling().getCeling(a, 0, a.length - 1, 3);
			System.out.println(floor + " > " + a[ceil]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getF(int[] a, int key) {
		try {
			int max = 0;
			for (int i = 0; i < a.length; i++) {
				if (max < a[i] && max < key && a[i] <= key) {
					max = a[i];
				}
			}
			return max;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getCeling(int[] a, int low, int high, int key) {
		try {
			int mid = (low + high) / 2;
			if (a[mid] == key) {
				return mid;
			}
			if (a[mid] < key) {
				if (mid + 1 <= high && a[mid + 1] >= key) {
					return mid + 1;
				}
				return getCeling(a, mid + 1, high, key);
			}
			if (a[mid] > key) {
				if (mid - 1 > low && a[mid - 1] < key) {
					return mid;
				}
				return getCeling(a, low, mid - 1, key);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
