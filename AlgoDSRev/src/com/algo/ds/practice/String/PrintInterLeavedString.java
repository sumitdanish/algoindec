package com.algo.ds.practice.String;

public class PrintInterLeavedString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String str1 = "AB";
			String str2 = "CD";
			char[] ch = new char[str1.length() + str2.length()];
			new PrintInterLeavedString().printInterleaved(str1, str2, ch, 0);
			if (new PrintInterLeavedString().isInterleaved(str1, str2, "CABD")) {
				System.out.println("OP");
			} else {
				System.out.println("IOP");

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void printInterleaved(String str1, String str2, char[] op, int i) {
		try {
			if (str1.length() == 0 && str2.length() == 0) {
				for (char ch : op) {
					System.out.print(ch);
				}
				System.out.println();
			}
			if (str1.length() != 0) {
				op[i] = str1.charAt(0);
				printInterleaved(str1.substring(1), str2, op, i + 1);
			}
			if (str2.length() != 0) {
				op[i] = str2.charAt(0);
				printInterleaved(str1, str2.substring(1), op, i + 1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private boolean isIterleved(String str1, String str2, String str3) {
		try {
			int i = 0;
			int j = 0;
			int k = 0;
			while (k < str3.length()) {
				if (i < str1.length() && str1.charAt(i) == str3.charAt(k)) {
					i++;
				} else if (j < str2.length()
						&& str2.charAt(j) == str3.charAt(k)) {
					j++;
				} else {
					break;
				}
				k++;
			}
			if (k < (str1.length() + str2.length())) {
				return false;
			}
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private boolean isInter(String str1, String str2, String str3) {
		try {
			if (str1 == null || str2 == null || str3 == null) {
				return true;
			}
			if (str3 == null) {
				return false;
			}

			return ((str1.charAt(0) == str3.charAt(0) && isInter(str1
					.substring(1), str2, str3.substring(1))) || (str2.charAt(0) == str3
					.charAt(0) && isInter(str1, str2.substring(1), str3
					.substring(1))));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private boolean isInterleaved(String str1, String str2, String str3) {
		try {
			boolean[][] b = new boolean[str1.length() + 1][str2.length() + 1];
			for (int i = 0; i <= str1.length(); i++) {
				for (int j = 0; j <= str2.length(); j++) {
					if (i == 0 || j == 0) {
						b[i][j] = true;
					} else if (i == 0
							&& str2.charAt(j - 1) == str3.charAt(j - 1)) {
						b[i][j] = b[i][j - 1];
					} else if (j == 0
							&& str1.charAt(i - 1) == str3.charAt(i - 1)) {
						b[i][j] = b[i - 1][j];
					} else if (str1.charAt(i - 1) == str3.charAt(i + j - 1)
							&& str2.charAt(i - 1) != str3.charAt(i + j - 1)) {
						b[i][j] = b[i - 1][j];
					} else {
						b[i][j] = (b[i][j - 1] || b[i - 1][j]);
					}
				}
			}
			return b[str1.length()][str2.length()];
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
