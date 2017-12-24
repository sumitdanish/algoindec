package com.algo.ds.practice.String;

public class ISStringSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String str1 = "ADXCP1Y";
			String str2 = "AXY";
			ISStringSubSequence sub = new ISStringSubSequence();
			if (sub.isSubsequence(str1, str2)) {
				System.out.println("Exist");
			} else {
				System.out.println("Not Exist");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private boolean isSubsequence(String str1, String str2) {
		try {
			int i = 0;
			int j = 0;
			while (i < str1.length() && j < str2.length()) {
				if (str1.charAt(i) == str2.charAt(j)) {
					j++;
					i++;
				} else {
					if (j == str2.length() - 1) {
						return true;
					} else {
						i++;
					}
				}
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
