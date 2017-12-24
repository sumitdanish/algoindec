package com.algo.ds.practice.ArrayPractice;

public class RearrangeArrayInAlternatingPositiveNegative {

	/**
	 * @param args
	 */
	static int[] a = { 1, 2, 3, -4, -1, 4 };;

	public static void main(String[] args) {

		try {
			new RearrangeArrayInAlternatingPositiveNegative().arrange(a);
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void rotateArray(int i, int op) {
		try {
			int temp = a[i];
			for (int j = i; j > op; j--) {
				a[j] = a[j - 1];
			}
			a[op] = temp;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void arrange(int[] a) {
		try {
			int op = -1;
			for (int i = 0; i < a.length; i++) {
				if (op >= 0) {
					if ((a[i] >= 0 && a[op] < 0) || (a[i] < 0 && a[op] >= 0)) {
						rotateArray(i, op);
						if ((i - op) > 2) {
							op = op + 2;
						} else {
							op = -1;
						}
					}
				}
				if (op == -1) {
					if ((a[i] > 0 && i % 2 == 0) || (a[i] < 0 && i % 2 != 0)) {
						op = i;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
