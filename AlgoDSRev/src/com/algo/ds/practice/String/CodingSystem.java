package com.algo.ds.practice.String;

public class CodingSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String str = "123";
			new CodingSystem().genrateCoding(null, str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void genrateCoding(String array, String text) {
		try {
			if (array != null || !array.equals("")) {
				System.out.println(Integer.parseInt(array) < 27 ? array : "");
			}
			for (int i = 0; i < text.length(); i++) {
				genrateCoding(array + text.charAt(i), text.substring(i + 1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
