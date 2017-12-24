package com.algo.ds.practice.ArrayPractice;

public class SortElement {

	/**
	 * @param args
	 * 
	 *            Sort an array according to the order defined by another array
	 */
	static int[] a = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };

	public static void main(String[] args) {
		try {
			SortElement so = new SortElement();
			int[] a2 = { 2, 1, 8, 3 };
			so.quickSort(a, 0, a.length - 1);
			so.sort(a, a2);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int binarySearch(int[] a, int l, int r, int key) {
		try {
			int mid = (l + r) / 2;
			if (a[mid] == key || key > a[mid - 1]) {
				return mid;
			} else if (mid - 1 > l && key < a[mid]) {
				return binarySearch(a, l, mid - 1, key);
			} else if (mid + 1 < r && key > a[mid]) {
				return binarySearch(a, mid + 1, r, key);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void quickSort(int[] a, int l, int r) {
		try {
			int p = a[(l + r) / 2];
			int i = l;
			int j = r;
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
				if (j > l) {
					quickSort(a, l, j);
				}
				if (i < r) {
					quickSort(a, i, r);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void sort(int[] a, int[] a2) {
		int[] count = new int[a.length];
		int k = 0;
		boolean[] visited = new boolean[a.length];
		int[] temp = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}
		for (int i = 0; i < a.length; i++) {
			visited[i] = false;
		}
		for (int i1 = 0; i1 < a2.length; i1++) {
			int ind = binarySearch(temp, 0, temp.length - 1, a2[i1]);
			for (int j = ind; j < temp.length; j++) {
				if (temp[j] == a2[i1] && visited[j] == false) {
					a[k] = temp[j];
					visited[j] = true;
					k++;
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			if (visited[i] == false) {
				a[k] = temp[i];
				k++;
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}

}
