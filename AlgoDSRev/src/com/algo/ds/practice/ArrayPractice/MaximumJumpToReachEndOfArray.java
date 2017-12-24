package com.algo.ds.practice.ArrayPractice;

public class MaximumJumpToReachEndOfArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { 1, 3, 6, 1, 0, 9 };
			int jum = new MaximumJumpToReachEndOfArray().getMinJump(a);
			System.out.println(jum);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getMinJump(int[] a) {
		try {
			int[] jump = new int[a.length];
			jump[0] = 0;
			for (int i = 1; i < a.length; i++) {
				jump[i] = Integer.MAX_VALUE;
				for (int j = 0; j < i; j++) {
					if (i <= j + a[j] && jump[i] > (jump[j] + 1)) {
						System.out.println(i + " (j+a[j])> " + (j + a[j])
								+ " jump[j] > " + jump[j]);
						jump[i] = jump[j] + 1;
						break;
					}
				}
			}
			return jump[a.length - 1];
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
