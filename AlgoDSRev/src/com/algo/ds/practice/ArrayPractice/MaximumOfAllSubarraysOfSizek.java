package com.algo.ds.practice.ArrayPractice;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumOfAllSubarraysOfSizek {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		new MaximumOfAllSubarraysOfSizek().getMaxInArrayK(a, 3);
	}

	private void getMaxInArrayK(int[] a, int k) {
		try {
			Queue<Integer> qu = new LinkedList<Integer>();
			int i = 0;
			for (i = 0; i < k; i++) {
				while (!qu.isEmpty() && a[i] >= a[qu.peek()]) {
					qu.poll();
				}
				qu.add(new Integer(i));
			}
			for (; i < a.length; i++) {
				System.out.print(a[qu.peek()] + ",");
				while (!qu.isEmpty() && qu.peek() <= (i - k)) {
					qu.poll();
				}
				while (!qu.isEmpty() && a[i] >= a[qu.peek()]) {
					qu.poll();
				}
				qu.add(new Integer(i));
			}
			System.out.print(a[qu.peek()]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
