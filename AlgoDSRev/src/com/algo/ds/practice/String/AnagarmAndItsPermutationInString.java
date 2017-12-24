package com.algo.ds.practice.String;

public class AnagarmAndItsPermutationInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			String pattern = "ABCD";
			String text = "BACDGABCDA";
			AnagarmAndItsPermutationInString an = new AnagarmAndItsPermutationInString();
			an.printIndex(pattern, text);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void printIndex(String pattern, String text) {
		try {
			int ps = pattern.length();
			char[] countPat = new char[256];
			char[] countText = new char[256];
			for (int i = 0; i < pattern.length(); i++) {
				countPat[pattern.charAt(i)]++;
				countText[text.charAt(i)]++;
			}

			for (int i = pattern.length(); i < text.length(); i++) {
				if (isEquals(countPat, countText, ps)) {
					System.out.println("Pattern found at > " + (i - ps));
				}
				countText[text.charAt(i)]++;
				countText[text.charAt(i - ps)]--;
			}
			if (isEquals(countPat, countText, ps)) {
				System.out.println("Pattern found at > "
						+ (text.length() - pattern.length()));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private boolean isEquals(char[] pattern, char[] text, int ps) {
		try {
			for (int i = 0; i < 256; i++) {
				if (pattern[i] != text[i]) {
					return false;
				}
			}
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
