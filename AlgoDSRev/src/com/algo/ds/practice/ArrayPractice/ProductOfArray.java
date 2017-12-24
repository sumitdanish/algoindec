package com.algo.ds.practice.ArrayPractice;

public class ProductOfArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[] a = { 10, 3, 5, 6, 2 };
			new ProductOfArray().product(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void product(int[] a) {
		try {
			int[] leftPro = new int[a.length];
			int[] rightPro = new int[a.length];
			int[] pro = new int[a.length];
			leftPro[0] = 1;
			rightPro[a.length - 1] = 1;
			for (int i = 1; i < a.length; i++) {
				leftPro[i] = leftPro[i - 1] * a[i - 1];
			}
			for (int i = a.length - 2; i >= 0; i--) {
				rightPro[i] = a[i + 1] * rightPro[i + 1];
			}
			for (int i = 0; i < a.length; i++) {
				pro[i] = leftPro[i] * rightPro[i];
			}
			for (int i = 0; i < a.length; i++) {
				System.out.print(pro[i] + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void prod12(int[] a) {
		try {
			int temp = 1;
			int[] prod = new int[a.length];
			for (int i = 0; i < a.length; i++) {
				prod[i] = temp;
				temp *= a[i];
			}
			temp = 1;
			for (int i = a.length - 1; i >= 0; i--) {
				prod[i] *= temp;
				temp *= a[i];
			}

			for (int i = 0; i < a.length; i++) {
				System.out.print(prod[i] + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
