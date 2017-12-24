package com.algo.ds.practice.ArrayPractice;

public class KthSmallestElementUsingQuickSort {

	/**
	 * @param args
	 */

	static int kthEle = 0;
	static int kthEle1 = 0;
	static int[] a = { 12, 3, 5, 7, 4, 19, 26 };

	public static void main(String[] args) {

		try {
			KthSmallestElementUsingQuickSort kth = new KthSmallestElementUsingQuickSort();
			int k = 2;
			kth.quickSort(0, a.length - 1, k);
			System.out.println(kthEle);
			for (int a1 : a) {
				System.out.print(a1 + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void quickSort(int left, int right, int kth) {
		try {
			int i = left;
			int j = right;
			int p = a[(left + right) / 2];
			kthEle1++;
			if (kthEle1 == kth - 1) {
				kthEle = p;

				return;
			}
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
					quickSort(i, right, kth);
				}
				if (j > left) {
					quickSort(left, j, kth);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
