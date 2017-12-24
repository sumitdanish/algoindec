package com.algo.ds.practice.ArrayPractice;

public class FindDuplicateNo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[] a = { 1, 2, 3, 1, 3, 6, 6 };
			new FindDuplicateNo().findDuplicate(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void findDuplicate(int[] a) {
		try {
			for (int i = 0; i < a.length; i++) {
				if (a[Math.abs(a[i])] > 0) {
					// System.out.println(i+" > "+a[i]+" > "+Math.abs(a[i])+" > "+a[Math.abs(a[i])]);
					a[Math.abs(a[i])] = -a[Math.abs(a[i])];
				} else {
					// System.out.println(i+" > "+a[i]+" > "+Math.abs(a[i])+" > "+a[Math.abs(a[i])]);
					System.out.println("DUplicate > " + Math.abs(a[i]));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
