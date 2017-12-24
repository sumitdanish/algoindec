package com.algo.ds.practice.ArrayPractice;

public class ReplaceNumberToItsNextGreaterNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 16, 17, 4, 3, 5, 2 };
			new ReplaceNumberToItsNextGreaterNumber().printNextGreaterNumber(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void printNextGreaterNumber(int[] a) {
		try {
			int next = a[a.length - 1];
			a[a.length - 1] = -1;
			for (int i = a.length - 2; i >= 0; i--) {
				int temp = a[i];
				a[i] = next;
				if (temp > next) {
					next = temp;
				}
			}
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
