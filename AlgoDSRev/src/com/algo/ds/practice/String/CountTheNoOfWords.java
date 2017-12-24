package com.algo.ds.practice.String;

public class CountTheNoOfWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String str = "One two          three\n  four\nfive  ";
			int wc = new CountTheNoOfWords().count(str);
			System.out.println(wc);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int count(String str) {
		try {
			int i = 0;
			int wc = 1;
			boolean flag = false;
			while (i < str.length()) {
				if (str.charAt(i) == '\t' || str.charAt(i) == '\n'
						|| str.charAt(i) == ' ') {
					flag = true;
				} else if (flag) {
					++wc;
					flag = false;
				}
				i++;
				// str=str.substring(str.indexOf(' '));
			}
			return wc;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}
}
