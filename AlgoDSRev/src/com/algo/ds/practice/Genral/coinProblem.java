package com.algo.ds.practice.Genral;

public class coinProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 1, 2, 3 };
			int sum = 5;
			int c = new coinProblem().getMinCoin(a, sum);
			System.out.println(c);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getMinCoin(int[] a, int sum) {
		try {
			int j = 0;
			int min = sum + 1;
			int coin = 0;
			for (int i = 0; i < a.length; i++) {
				if (sum == a[i]) {
					return a[i];
				}
				if (sum > a[i]) {
					j = getMinCoin(a, sum - a[i]) + 1;
					if (j != 0 && j < min) {
						min = j;
						//coin = a[i];
					}
				}
			}
			if (min == sum + 1) {
				return -1;
			} else {
				// System.out.println(coin);
				return min;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
