package com.algo.ds.practice.ArrayPractice;

public class MinMax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { 1000, 11, 445, 12, 45, 3, 3000 };
			TournamentMinMax to = new MinMax().minMaxByTournament(a, 0,
					a.length - 1);
			System.out.println(to.getMax() + " > " + to.getMin());
			// new MinMax().minMax1(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void minMax(int[] a) {
		try {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					max = a[i];
					min = a[i + 1];
				} else if (a[i] < a[i + 1]) {
					max = a[i + 1];
					min = a[i];
				}
			}
			System.out.println("MAx > MIN " + max + " > " + min);
			for (int i = 0; i < a.length; i++) {
				if (max < a[i]) {
					max = a[i];
				}
				if (min > a[i]) {
					min = a[i];
				}
			}
			System.out.println("MAx > MIN " + max + " > " + min);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void getMinMax(int[] a) {
		try {
			int min = 0;
			int max = 0;
			int x = 0;
			if (a.length % 2 == 0) {
				if (a[0] > a[1]) {
					min = a[1];
					max = a[0];
				}
				if (a[0] < a[1]) {
					min = a[0];
					max = a[1];
				}
				x = 2;
			}
			if (a.length % 2 != 0) {
				min = a[0];
				max = a[0];
				x = 1;
			}
			for (int i = x; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					if (a[i] > max) {
						max = a[i];
					}
					if (a[i + 1] < min) {
						min = a[i + 1];
					}
				} else {
					if (a[i + 1] > max) {
						max = a[i + 1];
					}
					if (a[i] < min) {
						min = a[i];
					}
				}
			}

			System.out.println("Max > " + max + " > MIn kjahds > " + min);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void minMax1(int[] a) {
		try {
			int min = Integer.MAX_VALUE;
			int min1 = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < a.length; i++) {
				if (a[i] < min1) {
					min = min1;
					min1 = a[i];
				}
				if (min > a[i] && min < min1) {
					min = a[i];
				}
			}

			System.out.println(min + " > " + min1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/* Min Max by using concept of tournament algo */

	private TournamentMinMax minMaxByTournament(int[] a, int left, int right) {
		try {
			TournamentMinMax to = new TournamentMinMax();
			if (left == right) {
				to.setMax(a[left]);
				to.setMin(a[left]);
				return to;
			}
			if (left + 1 == right) {
				if (a[left] > a[right]) {
					to.setMax(a[left]);
					to.setMin(a[right]);
				}
				if (a[left] < a[right]) {
					to.setMin(a[left]);
					to.setMax(a[right]);
				}
				return to;
			}
			int mid = (left + right) / 2;
			TournamentMinMax to1 = minMaxByTournament(a, left, mid);
			TournamentMinMax to2 = minMaxByTournament(a, mid + 1, right);
			if (to1.getMax() > to2.getMax()) {
				to.setMax(to1.getMax());
			} else {
				to.setMax(to2.getMax());
			}
			if (to1.getMin() < to2.getMin()) {
				to.setMin(to1.getMin());
			} else {
				to.setMin(to2.getMin());
			}
			return to;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
