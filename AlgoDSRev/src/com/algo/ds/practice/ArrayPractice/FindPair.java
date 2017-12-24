package com.algo.ds.practice.ArrayPractice;

public class FindPair {

	/**
	 * @param args
	 */
	static int[] a = { 5, 20, 3, 2, 50, 80 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FindPair f = new FindPair();
			f.quickSort(0, a.length - 1);
			int key = 78;
			for (int i = 0; i < a.length; i++) {
				int x = key + a[i];
				int in = f.binarySearch(a, 0, a.length - 1, x);
				if (in != -1) {
					System.out.println(a[i] + " > " + a[in]);
					break;
				} else {
					System.out.println("Nops");
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int binarySearch(int[] a, int low, int high, int key) {
		try {
			int mid = (low + high) / 2;
			if (a[low] == key) {
				return low;
			} else if (a[high] == key) {
				return high;
			} else if (a[mid] == key) {
				return mid;
			} else if (mid - 1 > low && a[mid] > key) {
				return binarySearch(a, low, mid - 1, key);
			} else if (mid + 1 < high && a[mid] < key) {
				return binarySearch(a, mid + 1, high, key);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void quickSort(int left, int right) {
		try {
			int i = left;
			int j = right;
			int p = a[(left + right) / 2];
			while (i <= j) {
				while (p > a[i]) {
					i++;
				}
				while (p < a[j]) {
					j--;
				}
				if (i <= j) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					i++;
					j--;
				}
				if (i < right) {
					quickSort(i, right);
				}
				if (j > left) {
					quickSort(left, j);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
