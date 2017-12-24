package com.algo.ds.practice.String;

public class CheckRotationOfString {

	/**
	 * @param args
	 */
	static char[] st;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "aaaad";
		st = str.toCharArray();
		CheckRotationOfString che = new CheckRotationOfString();
		if (che.isRotation(str.length())) {
			System.out.println("Yup's its rotation of the string");
		}
	}

	private void stringRotation() {
		char ch = st[0];
		int i = 0;
		for (i = 0; i < st.length - 1; i++) {
			st[i] = st[i + 1];
		}
		st[i] = ch;
	}

	private boolean isRotation(int len) {
		try {
			for (int i = 0; i < len; i++) {
				stringRotation();
				if (isPalindrome(String.valueOf(st))) {
					System.out
							.println("String is rotation of the palindrome > "
									+ String.valueOf(st));
					return true;
				}
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private boolean isPalindrome(String str) {
		try {
			if (str.length() == 0 || str.length() == 1) {
				return true;
			}
			if (str.charAt(0) == str.charAt(str.length() - 1)) {
				return isPalindrome(str.substring(1, str.length() - 1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
