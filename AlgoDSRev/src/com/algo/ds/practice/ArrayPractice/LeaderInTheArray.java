package com.algo.ds.practice.ArrayPractice;

public class LeaderInTheArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int[] a = { 16, 17, 4, 3, 5, 2 };
			new LeaderInTheArray().printMaxLeader(a);
		} catch (Exception nex) {
			nex.printStackTrace();
		}

	}

	private void printMaxLeader(int[] a) {
		try {
			int max_len = a[a.length - 1];
			for (int i = a.length - 2; i >= 0; i--) {
				if (a[i] > max_len) {
					System.out.print(a[i] + ",");
					max_len = a[i];
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
