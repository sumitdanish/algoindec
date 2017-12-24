package com.algo.ds.practice.ArrayPractice;

public class MaxDiffInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { 100, 180, 260, 310, 40, 535, 695 };
			new MaxDiffInArray().maxDiff(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void maxDiff(int[] a) {
		try {
			int maxDif = a[1] - a[0];
			int minEle = a[0];
			for (int i = 0; i < a.length; i++) {
				if (a[i] - minEle >= maxDif) {
					maxDif = a[i] - minEle;
				}
				if (a[i] < minEle) {
					minEle = a[i];
				}
			}
			System.out.println("MAxDiff > " + maxDif + " > Min ELe > " + minEle
					+ " > " + (maxDif + minEle));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
