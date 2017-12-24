package com.algo.ds.practice.ArrayPractice;

public class MinimumOfNumberOfElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 4, 5, 6, 7, 8, 4, 4 };
			int k = 3;
			new MinimumOfNumberOfElement().getMinimumElement(a, k, a.length);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void getMinimumElement(int[] a, int k, int len) {
		try {
			int ac = 0;
			Temp[] temp = new Temp[k];
			for (int i = 0; i < k; i++) {
				Temp t = new Temp(0, 0);
				temp[i] = t;
			}
			for (int i = 0; i < len; i++) {

				int j = 0;
				for (j = 0; j < k; j++) {
					if (temp[j].e == a[i]) {
						temp[j].c++;
						break;
					}
				}
				System.out.println(j);
				if (j == k) {
					int l = 0;
					for (l = 0; l < k; l++) {
						if (temp[l].e == 0) {
							temp[l].e = a[i];
							temp[l].c++;
							break;
						}
					}

					if (l == k) {
						for (int p = 0; p < k; p++) {
							temp[p].e = 0;
							temp[p].c = 0;
						}
					}
				}
			}
			for (int i = 0; i < k; i++) {
				ac = 0;
				for (int j = 0; j < len; j++) {
					if (temp[i].e == a[j]) {
						ac++;
					}
				}
				if (ac > 1) {
					System.out.println("Index Element > " + temp[i].e
							+ "  Repeted Element > " + ac);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	class Temp {
		int e = 0;
		int c = 0;

		public Temp(int e, int c) {
			super();
			this.e = e;
			this.c = c;
		}

	}
}
