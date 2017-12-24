package com.algo.ds.practice.ArrayPractice;

public class FindASortedSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 12, 11, 10, 5, 6, 2, 30 };
			new FindASortedSubsequence().printSortestSubSequence(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void printSortestSubSequence(int[] a) {
		try {
			int min = 0;
			int[] smallestLeft = new int[a.length];
			int[] greaterRight = new int[a.length];
			min = 0;
			int max = a.length - 1;
			for (int i = 1; i < a.length; i++) {
				if (a[i] <= a[min]) {
					min = i;
					smallestLeft[i] = -1;
				} else {
					smallestLeft[i] = min;
				}
			}
			for (int i = a.length - 2; i >= 0; i--) {
				if (a[i] >= a[max]) {
					max = i;
					greaterRight[i] = -1;
				} else {
					greaterRight[i] = max;
				}
			}

			for (int i = 0; i < a.length; i++) {
				if (greaterRight[i] != -1 && smallestLeft[i] != -1
						&& greaterRight[i] != smallestLeft[i]) {
					System.out.println(a[smallestLeft[i]] + " > " + a[i]
							+ " > " + a[greaterRight[i]]);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
