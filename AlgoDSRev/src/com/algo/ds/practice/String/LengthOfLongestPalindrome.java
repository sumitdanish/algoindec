package com.algo.ds.practice.String;

public class LengthOfLongestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String str = "forgeeksskeegfor";
			new LengthOfLongestPalindrome().lps(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void lps(String str) {
		try {
			int[][] l = new int[str.length()][str.length()];
			for (int i = 0; i < str.length(); i++) {
				l[i][i] = 1;
			}
			int k = 0;
			for (int i = 2; i < str.length() - 1; i++) {
				for (int j = 0; j < str.length() - i + 1; j++) {
					k = i + j - 1;
					if (str.charAt(j) == str.charAt(k) && i == 2) {
						l[i][k] = 2;
					} else if (str.charAt(j) == str.charAt(k)) {
						l[i][k] = l[i + 1][k - 1] + 2;
					} else {
						l[i][k] = getMax(l[i + 1][k], l[i][k - 1]);
					}
				}
			}
			System.out.println(l[0][str.length()]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int getMax(int a, int b) {
		try {
			return a > b ? a : b;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
