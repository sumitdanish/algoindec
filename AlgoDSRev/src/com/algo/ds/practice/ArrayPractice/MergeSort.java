package com.algo.ds.practice.ArrayPractice;

public class MergeSort {

	/**
	 * @param args
	 */

	static int[] temp;
	static int[] a;
	static int inv_count = 0;

	public static void main(String[] args) {

		try {
			MergeSort m = new MergeSort();
			a = new int[] { 1, 20, 6, 4, 5 };
			temp = new int[a.length];
			int len = m.merge(0, a.length - 1);
			System.out.println(len);
			for (int s : a) {
				System.out.print(s + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int merge(int left, int right) {
		try {
			if (left < right) {
				int mid = (left + right) / 2;
				inv_count = merge(left, mid);
				inv_count += merge(mid + 1, right);
				inv_count += mergeSort(left, mid, right);
			}
			return inv_count;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int mergeSort(int left, int mid, int right) {
		try {
			for (int i = left; i <= right; i++) {
				temp[i] = a[i];
			}
			int le = left;
			int ri = right;
			int mi = mid + 1;
			int tempIndex = le;
			while (le <= mid && mi <= ri) {
				if (temp[le] <= temp[mi]) {
					a[tempIndex] = temp[le];
					le++;
				} else {
					a[tempIndex] = temp[mi];
					mi++;
					inv_count = inv_count + (mid - le);
				}
				tempIndex++;
			}
			while (le <= mid) {
				a[tempIndex] = temp[le];
				tempIndex++;
				le++;
			}
			while (mi <= ri) {
				a[tempIndex] = temp[mi];
				mi++;
				tempIndex++;
			}
			return inv_count;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
