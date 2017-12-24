package com.algo.ds.practice.ArrayPractice;

public class StableMarrigeProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[][] preference = { { 7, 5, 6, 4 }, { 5, 4, 6, 7 },
					{ 4, 5, 6, 7 }, { 4, 5, 6, 7 }, { 0, 1, 2, 3 },
					{ 0, 1, 2, 3 }, { 0, 1, 2, 3 }, { 0, 1, 2, 3 }, };
			int manLen = 4;
			new StableMarrigeProblem().coupleMarrige(preference, manLen);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private boolean isWomanPreferMoverM1(int[][] preference, int w, int m,
			int m1, int manLen) {
		try {
			for (int i = 0; i < manLen; i++) {
				if (preference[w][i] == m1) {
					return true;
				}
				if (preference[w][i] == m) {
					return false;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private void coupleMarrige(int[][] preference, int manLen) {
		try {
			boolean[] man = new boolean[manLen];
			int[] woman = new int[manLen];
			for (int i = 0; i < manLen; i++) {
				man[i] = false;
				woman[i] = -1;
			}
			int freeMan = man.length - 1;
			while (freeMan >= 0) {
				int m = 0;
				for (m = 0; m < manLen; m++) {
					if (man[m] == false) {
						break;
					}
				}
				for (int i = 0; i < manLen && man[m] == false; i++) {
					int w = preference[m][i];
					if (woman[w - manLen] == -1) {
						woman[w - manLen] = m;
						man[m] = true;
						freeMan--;
					} else {
						int m1 = woman[w - manLen];
						if (isWomanPreferMoverM1(preference, w, m, m1, manLen) == false) {
							woman[w - manLen] = m;
							man[m] = true;
							man[m1] = false;
						} else {
							man[m1] = true;
							man[m] = false;
						}
					}
				}
			}
			System.out.println("      WOMAN    ----     MAN");
			for (int i = 0; i < manLen; i++) {
				System.out.println("\t" + (i + manLen) + "      ----      "
						+ woman[i]);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
