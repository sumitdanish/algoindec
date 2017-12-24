package com.algo.ds.practice.String;

public class KMPAlgoritham {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String pattern = "abcabdabc";
			String text = "abcabdabcabdabcabdabdabc";
			new KMPAlgoritham().searchPattern(text, pattern);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int[] preProcessingTable(String pattern) {
		try {
			int i = 0;
			int j = -1;
			int[] b = new int[pattern.length() + 1];
			b[0] = -1;
			for (; i < pattern.length();) {
				while (j >= 0 && pattern.charAt(i) != pattern.charAt(j)) {
					j = b[j];
				}
				i++;
				j++;
				b[i] = j;
			}
			for (int l = 0; l < b.length; l++) {
				System.out.print(b[l] + ",");
			}
			return b;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private void searchPattern(String text, String pattern) {
		try {
			int i = 0;
			int[] b = preProcessingTable(pattern);
			int j = 0;
			for (; i < text.length();) {
				while (j >= 0 && text.charAt(i) != pattern.charAt(j)) {
					j = b[j];
				}
				i++;
				j++;
				if (j == pattern.length()) {
					//System.out.println("\nPattern Found > " + i);
					j = b[j];
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
