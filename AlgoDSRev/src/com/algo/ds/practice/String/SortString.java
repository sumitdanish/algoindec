package com.algo.ds.practice.String;

public class SortString {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] ch = "aswefrqy".toCharArray();
		new SortString().quickSort(ch, 0, ch.length - 1);
		for (char c : ch) {
			System.out.print(c + ",");
		}
	}

	private void quickSort(char[] ch, int l, int r) {
		try {
			char p = ch[(l + r) / 2];
			int i = l;
			int j = r;
			while (i <= j) {
				while (p > ch[i]) {
					i++;
				}
				while (p < ch[j]) {
					j--;
				}
				if (i <= j) {
					char temp = ch[i];
					ch[i] = ch[j];
					ch[j] = temp;
					i++;
					j--;
				}
				if (i < r) {
					quickSort(ch, i, r);
				}
				if (j > l) {
					quickSort(ch, l, j);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
