package com.algo.ds.practice.ArrayPractice;

import java.util.ArrayList;

public class ByStockAndSell {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] a = { 100, 180, 260, 310, 40, 535, 695 };
			new ByStockAndSell().getSellingPoint(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void getSellingPoint(int[] a) {
		try {
			int i = 0;
			int len = a.length;
			ArrayList<Profit> ar = new ArrayList<Profit>();
			int count = 0;
			for (i = 0; i < len; i++) {
				Profit p = new Profit();
				while (i < len && a[i + 1] <= a[i]) {
					i++;
				}
				if (i == len - 1) {
					break;
				}
				p.setBuyingPoint(i);
				i++;
				while (i < len && a[i - 1] <= a[i]) {
					i++;
				}
				p.setSeelingPoint(i - 1);
				ar.add(p);
				count++;
			}
			System.out.println(count);
			for (Profit p1 : ar) {
				System.out.println(p1.getBuyingPoint() + " > "
						+ p1.getSeelingPoint());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	class Profit {
		int buyingPoint;
		int seelingPoint;

		public Profit() {

		}

		public int getBuyingPoint() {
			return buyingPoint;
		}

		public void setBuyingPoint(int buyingPoint) {
			this.buyingPoint = buyingPoint;
		}

		public int getSeelingPoint() {
			return seelingPoint;
		}

		public void setSeelingPoint(int seelingPoint) {
			this.seelingPoint = seelingPoint;
		}

	}

}
