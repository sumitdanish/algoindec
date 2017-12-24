package com.algo.ds.practice.String;

public class PermutationInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String str = "AB";
			new PermutationInString().permuteInOrder("", str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void permuteInOrder(String pre, String text) {
		try {
			int len = text.length();
			if (len == 0) {
				System.out.println(pre + " ");
			} else {
				for (int i = 0; i < len; i++) {
					permuteInOrder(pre + text.charAt(i) + "", text.substring(0,
							i)
							+ text.substring(i + 1, len));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void permuteInNonOrder(char[] a, int n) {
		try {
			if (n == 1) {
				System.out.println(String.valueOf(a));
				return;
			} else {
				for (int i = 0; i < n; i++) {
					swap(a, i, n - 1);
					permuteInNonOrder(a, n - 1);
					swap(a, i, n - 1);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void swap(char[] a, int i, int j) {
		try {
			char temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
