package com.algo.ds.practice.String;

public class PatternMatching {

	/**
	 * @param args
	 *            String matching where one string contains wildcard characters
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String str1 = "g*ks";
			String str2 = "geeks";
			if (new PatternMatching().isMatched(str1, str2)) {
				System.out.println("Matched");
			} else {
				System.out.println("Not Matched");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private boolean isMatched(String str1, String str2) {
		try {
			if (str1.length() == 0 && str2.length() == 0) {
				return true;
			} else if (str1.charAt(0) == '*' && str1.length() != 0
					&& str2.length() == 0) {
				return false;
			} else if (str1.charAt(0) == '?'
					|| str1.charAt(0) == str2.charAt(0)) {
				return isMatched(str1.substring(1), str2.substring(1));
			} else if (str1.charAt(0) == '*') {
				return isMatched(str1.substring(0), str2.substring(1))
						|| isMatched(str1.substring(1), str2.substring(0));
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
