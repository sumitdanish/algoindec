package com.algo.ds.practice.String;

public class RemoveAdjacentElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String s = "hahhaaha";
			new RemoveAdjacentElement().remove(s.toCharArray());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void remove(char[] ch) {
		try {
			int j = 0;
			for (int i = 1; i < ch.length; i++) {
				while (j > 0 && ch[i] == ch[j]) {
					System.out.println(ch[i]);
					i++;
					j--;
				}

				ch[++j] = ch[i];

			}
			System.out.println(String.valueOf(ch));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
