package com.algo.ds.practice.String;

public class LCSInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String str1 = "AGGTAB";
			String str2 = "GXTXAYB";
			int lcs = new LCSInString().getMaxLcs(str1, str2);
			System.out.println(lcs);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getLCS(String str1, String str2, int len1, int len2) {
		try {
			if (len1 == 0 || len2 == 0) {
				return 0;
			}
			if (len1 - 1 >= 0 && len2 - 1 >= 0
					&& str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
				return (1 + getLCS(str1, str2, len1 - 1, len2 - 1));
			} else {
				return getMax(getLCS(str1, str2, len1 - 1, len2), getLCS(str1,
						str2, len1, len2 - 1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMaxLcs(String str1, String str2) {
		try {
			int[][] lcs = new int[str1.length() + 1][str2.length() + 1];
			String str = new String();
			for (int i = 0; i < str1.length(); i++) {
				lcs[i][0] = 0;
			}
			for (int i = 0; i < str2.length(); i++) {
				lcs[0][i] = 0;
			}
			for (int i = 0; i <= str1.length(); i++) {
				for (int j = 0; j <= str2.length(); j++) {
					if (i == 0 || j == 0) {
						lcs[i][j] = 0;
					} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
						lcs[i][j] = 1 + lcs[i - 1][j - 1];
					} else {
						lcs[i][j] = getMax(lcs[i][j - 1], lcs[i - 1][j]);
					}
				}
			}
			int i = str1.length();
			int j = str2.length();
			while (i > 0 && j > 0) {
				if (str1.charAt(i - 1) == str2.charAt(i - 1)) {
					str += String.valueOf(str1.charAt(i - 1));
					i--;
					j--;
				} else if (lcs[i - 1][j] > lcs[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
			System.out.println(str);
			// for(int i=0;i<=str1.length();i++)
			// {
			// for(int j=0;j<=str2.length();j++)
			// {
			// System.out.print(lcs[i][j]+",");
			// }
			// System.out.println();
			// }

			return lcs[str1.length()][str2.length()];
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
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
