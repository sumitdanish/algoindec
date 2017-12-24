package com.algo.ds.practice.ArrayPractice;

public class EqulibriumPointInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { -7, 1, 5, 2, -4, 3, 0 };
			new EqulibriumPointInArray().print(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/* O(N2) */

	private void printEquiPoint(int[] a) {
		try {
			for (int i = 0; i < a.length; i++) {
				int ls = 0;
				int rs = 0;

				for (int j = 0; j <= i; j++) {
					ls += a[j];
				}
				for (int k = i; k < a.length; k++) {
					rs += a[k];
				}
				if (ls == rs) {

					System.out
							.println("RS > " + rs + "  LS> " + ls + " > " + i);
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/* O(N) */
	private void print(int[] a) {
		try {
			int sum = 0;
			int ls = 0;
			for (int i = 0; i < a.length; i++) {
				sum += a[i];
			}
			for (int i = 0; i < a.length; i++) {
				sum -= a[i];
				if (ls == sum) {
					System.out.println(" > " + i);
					break;
				}
				ls += a[i];
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
