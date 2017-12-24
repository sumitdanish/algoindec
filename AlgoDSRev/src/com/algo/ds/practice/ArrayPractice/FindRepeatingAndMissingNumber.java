package com.algo.ds.practice.ArrayPractice;

public class FindRepeatingAndMissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 3, 1, 3 };
			new FindRepeatingAndMissingNumber().findRepeatingAndMissing(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void findRepeatingAndMissing(int[] a) {
		try {
			for (int i = 0; i < a.length; i++) {
				if (a[Math.abs(a[i]) - 1] > 0) {
					a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1];
				} else {
					System.out.println("Duplicate > " + Math.abs(a[i]));

				}
			}
			for (int i = 0; i < a.length; i++) {
				if (a[i] > 0) {
					System.out.println("Missing Number > " + (i + 1));
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
