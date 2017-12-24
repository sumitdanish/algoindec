package com.algo.ds.practice.ArrayPractice;

public class FindFourElements {

	/**
	 * @param args
	 */
	static int[] a = { 10, 20, 30, 40, 1, 2 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int key = 91;
			FindFourElements f = new FindFourElements();
			f.quickSort(0, a.length - 1);
			f.printElement(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

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

	private void printElement(int key) {
		try {
			for (int i = 0; i < a.length - 3; i++) {
				for (int j = i + 1; j < a.length - 2; j++) {
					int l = j + 1;
					int r = a.length - 1;
					while (l <= r) {
						if (a[i] + a[j] + a[l] + a[r] == key) {
							System.out.println(a[i] + " > " + a[j] + " > "
									+ a[l] + " > " + a[r]);
							return;
						} else {
							if (a[i] + a[j] + a[l] + a[r] < key) {
								l++;
							} else {
								r--;
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
