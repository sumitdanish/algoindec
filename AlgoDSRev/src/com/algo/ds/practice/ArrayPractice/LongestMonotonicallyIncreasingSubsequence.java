package com.algo.ds.practice.ArrayPractice;

public class LongestMonotonicallyIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
			new LongestMonotonicallyIncreasingSubsequence().printLCS(a);
			// System.out.println(temp);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getCeiling(int[] a, int low, int high, int key) {
		try {
			int mid = (low + high) / 2;
			if (a[mid] == key) {
				return mid;
			}
			if (a[mid] < key) {
				if (mid + 1 <= high && a[mid + 1] >= key) {
					return mid + 1;
				}
				return getCeiling(a, mid + 1, high, key);
			}
			if (a[mid] > key) {
				if (mid - 1 > low && a[mid - 1] < key) {
					return mid;
				}
				return getCeiling(a, low, mid - 1, key);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getLCS(int[] a) {
		try {
			int[] temp = new int[a.length];
			int len = 1;
			temp[0] = a[0];
			for (int i = 1; i < a.length; i++) {
				if (a[i] < temp[0]) {
					temp[0] = a[i];
				}
				if (a[i] > temp[len - 1]) {
					temp[len] = a[i];
					len++;
				} else {
					temp[getCeiling(temp, -1, len - 1, a[i])] = a[i];
				}
			}
			for (int i = 0; i < temp.length; i++) {
				System.out.println(temp[i]);
			}
			return len;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getCeiling1(int[] a, int[] temp, int low, int high, int key) {
		try {
			int mid = (low + high) / 2;
			if (a[temp[mid]] == key) {
				return mid;
			}
			if (a[temp[mid]] < key) {
				if (mid + 1 <= high && a[temp[mid + 1]] >= key) {
					return mid + 1;
				}
				return getCeiling1(a, temp, mid + 1, high, key);
			}
			if (a[temp[mid]] > key) {
				if (mid - 1 > low && a[temp[mid - 1]] < key) {
					return mid;
				}
				return getCeiling1(a, temp, low, mid - 1, key);
			}
			/*
			 * int m=0; while(high-low>1) { m=(low+high)/2; if(a[temp[m]]>=key)
			 * { high = m; } else { low = m; } } return high;
			 */
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void printLCS(int[] a) {
		try {
			int[] temp = new int[a.length];
			int[] pre = new int[a.length];
			int len = 1;
			temp[0] = 0;
			pre[0] = -1;
			for (int i = 1; i < a.length; i++) {
				if (a[i] < a[temp[0]]) {
					temp[0] = i;
				}
				if (a[i] > a[temp[len - 1]]) {
					pre[i] = temp[len - 1];
					temp[len] = i;
					len++;
				} else {
					int pos = getCeiling1(a, temp, -1, len - 1, a[i]);
					pre[i] = temp[pos - 1];
					temp[pos] = i;
				}
			}

			for (int i = temp[len - 1]; i >= 0; i = pre[i]) {
				System.out.print(a[i] + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
