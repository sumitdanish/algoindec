package com.algo.ds.practice.ArrayPractice;

public class SumClosestToZero {

	/**
	 * @param args
	 */
	static int[] a = { 1, 60, -10, 70, -80, 85 };

	public static void main(String[] args) {

		try {
			SumClosestToZero sum = new SumClosestToZero();
			sum.quickSort(0, a.length - 1);
			sum.maxCloseseSum();
			// new SumClosestToZero().sumClosestToZero();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void sumClosestToZero() {
		try {
			int min_i = 0;
			int max_i = 0;
			int maxSum = Integer.MAX_VALUE;
			for (int i = 0; i < a.length; i++) {
				int sum = a[i];
				for (int j = i + 1; j < a.length; j++) {
					if (Math.abs(sum + a[j]) < maxSum) {
						maxSum = Math.abs(sum + a[j]);
						max_i = j;
						min_i = i;
					}
				}
			}

			System.out.println("MAx_i > " + max_i + " > " + min_i);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void maxCloseseSum() {
		try {
			int max_i = 0;
			int min_i = 0;
			int maxSum = Integer.MAX_VALUE;
			int i = 0;
			int j = a.length - 1;
			while (i < j) {
				int sum = a[i] + a[j];
				if (Math.abs(sum) < maxSum) {
					maxSum = Math.abs(sum);
					min_i = i;
					max_i = j;
				}
				if (sum < 0) {
					i++;
				} else {
					j--;
				}
			}
			System.out.println("MAX > " + a[max_i] + " MIN > " + a[min_i]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void quickSort(int left, int right) {
		try {
			int p = a[(left + right) / 2];
			int i = left;
			int j = right;
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
					quickSort(j, right);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
