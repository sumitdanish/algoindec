package com.algo.ds.practice.ArrayPractice;

public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 1, 2, 3, 4, 5, 6, 7 };
			int[] l = new RotateArray().array(a);
			for (int i = 0; i < l.length; i++) {
				System.out.print(l[i] + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int[] array(int[] a) {
		try {
			int temp = a[0];
			int i = 0;
			for (i = 0; i < a.length - 1; i++) {
				a[i] = a[i + 1];
			}
			a[i] = temp;
			return a;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
