package com.algo.ds.practice.ArrayPractice;

public class FindingMaxOfDiffJI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
			int max = new FindingMaxOfDiffJI().getMaxDiff1(a);
			System.out.println("\n\n");
			System.out.println(max);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getMaxDiff(int[] a) {
		try {
			int max = 0;
			int ind_i = 0;
			int ind_j = 0;
			for (int i = 0; i < a.length; i++) {
				// max=0;
				for (int j = i + 1; j < a.length - 1; j++) {
					if (a[j] > a[i] && (j - i) > max) {
						max = j - i;
						ind_i = i;
						ind_j = j;
					}
				}
			}
			return max;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMaxDiff1(int[] a) {
		try {
			int max = 0;
			int[] lMin = new int[a.length];
			int[] rMax = new int[a.length];
			lMin[0] = a[0];
			rMax[a.length - 1] = a[a.length - 1];
			for (int i = 1; i < a.length; i++) {
				lMin[i] = getMin(a[i], lMin[i - 1]);
			}
			for (int i = a.length - 2; i >= 0; i--) {
				rMax[i] = getMax(a[i], rMax[i + 1]);
			}
			int i1 = 0;
			int j1 = 0;
			while (i1 < a.length && j1 < a.length) {
				if (lMin[i1] < rMax[j1]) {
					max = max > j1 - i1 ? max : j1 - i1;
					/*
					 * Here we want the j should be max and i should be min so
					 * we are incrementing j similarly for 2nd if condition
					 */
					j1++;
				} else {
					i1++;
				}
			}

			return max;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMax(int a, int b) {

		try {
			return a > b ? a : b;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMin(int a, int b) {
		try {
			return a > b ? b : a;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
