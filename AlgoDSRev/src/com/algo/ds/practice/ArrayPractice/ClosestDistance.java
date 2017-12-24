package com.algo.ds.practice.ArrayPractice;

public class ClosestDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { 1, 4, 5, 7 };
			int[] b = { 10, 20, 30, 40 };
			ClosestDistance cd = new ClosestDistance();
			int x = 32;
			cd.closestPair(a, b, x);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void closestPair(int[] a, int[] b, int x) {
		try {
			int dif = Integer.MAX_VALUE;
			int l = 0;
			int r = 0;
			int i = 0;
			int j = b.length - 1;
			while (i < a.length && j >= 0) {
				if (Math.abs((a[i] + b[j] - x)) < dif) {
					dif = (a[i] + b[j] - x);
					l = i;
					r = j;
				}
				if (Math.abs((a[i] + b[j] - x)) > dif) {
					i++;
				} else {
					j--;
				}
			}

			System.out.println("Closer Pair-->{" + a[l] + "," + b[r] + "}");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
