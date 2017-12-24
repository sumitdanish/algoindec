package com.algo.ds.practice.Sorting;

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 3, 7, 8, 5, 2, 1, 9, 5, 4 };
			QuickSort q = new QuickSort();
			q.quickSort(a, 0, a.length - 1);
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void quickSort(int[] a, int low, int high) {
		try {
			if (low < high) {
				int p = split(a, low, high);
				
					quickSort(a, low, p-1);
				
					quickSort(a, p, high);
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int split(int[] a, int low, int high) {
		try {
			int p = a[high];
			int i = low;
			int j = high;
			while (i < j) {
				while (p > a[i]) {
					i++;
				}
				while (p <a[j]) {
					j--;
		 		}
				if (i < j) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					i++;
					j--;
				}
			}
//			System.out.println(p+"\n");
//			for (int i1 = 0; i1 < a.length; i1++) {
//				System.out.print(a[i1] + ",");
//			}
			System.out.println();
			return i;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
