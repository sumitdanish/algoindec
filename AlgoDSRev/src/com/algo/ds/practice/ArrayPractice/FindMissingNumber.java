package com.algo.ds.practice.ArrayPractice;

public class FindMissingNumber {

	/**
	 * @param args
	 */
	static int[] a = { 2, 3, -7, 6, 8, 1, -10, 15 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FindMissingNumber f = new FindMissingNumber();
			int j = f.part();
			f.getMissingNumber(j);

			for (int i = j; i < a.length; i++) {
				System.out.print(a[i] + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int part() {
		try {
			int i = 0;
			int j = 0;
			for (i = 0; i < a.length; i++) {
				if (a[i] < 0) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					j++;
				}
			}
			return j;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void getMissingNumber(int n) {
		try {
			for (int i = n; i < a.length; i++) {
				if (Math.abs(a[i]) < a.length && a[Math.abs(a[i])] > 0) {
					a[Math.abs(a[i])] = -a[Math.abs(a[i])];
				}
			}
			for (int i = n; i < a.length; i++) {
				if (a[i] > 0) {
					System.out.println(i);
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
