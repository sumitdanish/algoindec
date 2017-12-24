package com.algo.ds.practice.String;

public class StringCombination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String str = "123";
			int[] a = {};

			new StringCombination().printCombinationOne("", str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void printCombinationOne(String pre, String text) {
		try {
			if (text.length() > 0) {
				System.out.print(pre + text.charAt(0) + ",");
				printCombinationOne(pre + text.charAt(0), text.substring(1));
				// printCombination(pre, text.substring(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void printCombinationTwo(String pre, String text) {
		try {

			System.out.print((pre.length() >= 1 ? pre + " ," : "") + "\n");
			for (int i = 0; i < text.length(); i++) {
				printCombinationTwo(pre + text.charAt(i), text.substring(i + 1));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
