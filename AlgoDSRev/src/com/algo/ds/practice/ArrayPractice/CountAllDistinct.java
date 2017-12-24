package com.algo.ds.practice.ArrayPractice;

import java.util.HashMap;

public class CountAllDistinct {

	/**
	 * @param args
	 */
	static int[] a = { 1, 5, 3, 4, 2 };

	public static void main(String[] args) {

		try {
			int k = 3;
			CountAllDistinct co = new CountAllDistinct();
			// co.quickSort(0,a.length-1);
			// for(int i=0;i<a.length;i++)
			// {
			// System.out.print(a[i]+",");
			// }
			// co.removeDuplicate();
			co.getPair(k);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void getPair(int k) {
		try {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int i = 0;
			map.put(a[i], a[i]);
			for (i = 1; i < a.length; i++) {

				if (map.containsKey(a[i] + k)) {
					System.out.println(map.get(a[i] + k) + " > " + a[i]);
				} else if (map.containsKey(a[i] - k)) {
					System.out.println(map.get(a[i] - k) + " > " + a[i]);
				} else {
					map.put(a[i], a[i]);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void quickSort(int left, int right) {
		try {
			int i = left;
			int j = right;
			int p = a[(right + left) / 2];
			while (i <= j) {
				while (p >= a[i]) {
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

	private void removeDuplicate() {
		try {
			int j = 0;
			int i = 0;
			while (i < a.length) {
				if (a[i] == a[j]) {
					i++;
				} else {
					a[j] = a[i];
					i++;
					j++;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
