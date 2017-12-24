package com.algo.ds.practice.ArrayPractice;

import java.util.Random;

public class RandomSuffleOfArray {

	/**
	 * @param args
	 */

	static int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
	static final Random ran = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			RandomSuffleOfArray ranDom = new RandomSuffleOfArray();
			ranDom.suffleArray();
			for (int a1 : a) {
				System.out.print(a1 + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void suffleArray() {
		try {
			int len = a.length - 1;
			while (len > 1) {
				int n = ran.nextInt(len);
				swap(len, n);
				len--;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void swap(int i, int j) {
		try {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
