package com.algo.ds.practice.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SuffixArrayImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			SuffixArrayImpl sl = new SuffixArrayImpl();
			String str = "banana";
			ArrayList<Suffix> array = new ArrayList<Suffix>();
			Suffix suff;
			for (int i = 0; i < str.length(); i++) {
				String st = str.substring(i, str.length());
				suff = new Suffix(st, i);
				array.add(suff);
			}
			Collections.sort(array, new SufixSort());
			for (Suffix s : array) {
				System.out.println("Index > " + s.getIndex() + " > Suffix > "
						+ s.getSufix());
			}

			int index = sl.binary("nana", 0, str.length(), array);
			System.out.println("Pattern found At > " + index);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int binary(String pat, int left, int right, ArrayList<Suffix> list) {
		try {
			int mid = (left + right) / 2;
			int co = pat.compareTo(list.get(mid).getSufix());
			if (co == 0) {
				return list.get(mid).getIndex();
			}
			if (co < 0 && mid - 1 > left) {
				return binary(pat, left, mid - 1, list);
			}
			if (co > 0) {
				return binary(pat, mid + 1, right, list);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}

class SufixSort implements Comparator<Suffix> {

	@Override
	public int compare(Suffix o1, Suffix o2) {
		// TODO Auto-generated method stub
		return o1.getSufix().compareTo(o2.getSufix());
	}

}

class Suffix {
	String sufix;
	int index;

	public Suffix(String sufix, int index) {
		this.sufix = sufix;
		this.index = index;
	}

	public String getSufix() {
		return sufix;
	}

	public void setSufix(String sufix) {
		this.sufix = sufix;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
