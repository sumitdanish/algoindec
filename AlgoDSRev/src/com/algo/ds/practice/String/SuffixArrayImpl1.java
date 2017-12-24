package com.algo.ds.practice.String;

import java.util.Comparator;
import java.util.*;

public class SuffixArrayImpl1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String str = new String("banana");
			new SuffixArrayImpl1().bildSufixTree(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void bildSufixTree(String str) {
		try {
			int len = str.length();
			ArrayList<Suffix1> array = new ArrayList<Suffix1>();
			for (int i = 0; i < len; i++) {
				int rank0 = str.charAt(i) - 'a';
				int rank1 = (i + 1 < len ? str.charAt(i + 1) - 'a' : -1);
				String sufix = str.substring(i, str.length());
				Suffix1 su = new Suffix1();
				su.setRank0(rank0);
				su.setRank1(rank1);
				su.setIndex(i);
				su.setSufix(sufix);
				array.add(su);
			}
			Collections.sort(array, new SuffixSortRanks());
			int[] ind = new int[len];

			for (int k = 4; k < 2 * len; k = k * 2) {
				int ran = 0;
				int previous_rank = array.get(0).getRank0();
				array.set(0, new Suffix1(ran, 0));
				ind[array.get(0).getIndex()] = 0;
				for (int i = 1; i < len; i++) {
					if (array.get(0).getRank0() == previous_rank
							&& array.get(i).getRank1() == array.get(i - 1)
									.getRank1()) {
						previous_rank = array.get(0).getRank0();
						array.set(i, new Suffix1(ran, 0));
					} else {
						previous_rank = array.get(i).getRank0();
						array.set(i, new Suffix1(ran++, 0));
					}
					ind[array.get(i).getIndex()] = i;
				}

				for (int i = 0; i < len; i++) {
					int newIndex = array.get(i).getIndex() + (k / 2);
					int r = (newIndex + 1 < len ? array.get(ind[newIndex])
							.getRank0() : -1);
					array.set(i, new Suffix1(0, r));
				}
				Collections.sort(array, new SuffixSortRanks());
			}
			for (int i = 0; i < len; i++) {
				System.out.println(array.get(i).getIndex() + " ----<>"
						+ array.get(i).getSufix() + "---<> "
						+ array.get(i).getRank0() + " ---<> "
						+ array.get(i).getRank0());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class SuffixSortRanks implements Comparator<Suffix1> {
	public int compare(Suffix1 s1, Suffix1 s2) {
		return ((s1.getRank0() == s2.getRank0()) ? (s1.getRank1() > s2
				.getRank1() ? 1 : 0) : (s1.getRank0() > s2.getRank0() ? 1 : 0));
	}
}

class Suffix1 {
	String sufix;
	int index;
	int rank0;
	int rank1;

	public Suffix1() {

	}

	public Suffix1(int rank0, int rank1) {
		this.rank0 = rank0;
	}

	public void setSufix(String sufix) {
		this.sufix = sufix;
	}

	public void setRank0(int rank0) {
		this.rank0 = rank0;
	}

	public void setRank1(int rank1) {
		this.rank1 = rank1;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getRank0() {
		return rank0;
	}

	public int getRank1() {
		return rank1;
	}

	public int getIndex() {
		return index;
	}

	public String getSufix() {
		return sufix;
	}
}