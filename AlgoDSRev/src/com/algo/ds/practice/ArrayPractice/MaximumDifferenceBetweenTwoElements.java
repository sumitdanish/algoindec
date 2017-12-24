package com.algo.ds.practice.ArrayPractice;

public class MaximumDifferenceBetweenTwoElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { 100, 180, 260, 310, 40, 535, 695 };
			int min = new MaximumDifferenceBetweenTwoElements()
					.getMaxDIffrence(a);
			System.out.println(min);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * If we track minimum element and maximum difference then we will get
	 * maximum element after minimum element
	 */

	private int getMaxDIffrence(int[] a) {
		try {
			int min = 0;
			int maxDif = a[1] - a[0];
			int minElement = a[0];
			for (int i = 1; i < a.length; i++) {
				if (a[i] - minElement > maxDif) {
					maxDif = a[i] - minElement;
				}
				if (a[i] < minElement) {
					minElement = a[i];
					min = i;
				}
			}
			return maxDif;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
