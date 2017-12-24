package com.algo.ds.practice.String;

import java.util.HashMap;
import java.util.Map;

public class GenratePlindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			GenratePlindrome gen = new GenratePlindrome();
			String str = "j11anaj";
			String pal = gen.genratePlaindrome(str);
			if (pal == null) {
				System.out.println("Not Palindrome");
			} else {
				System.out.println(pal);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private String genratePlaindrome(String str) {
		try {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < str.length(); i++) {
				if (map.containsKey(str.charAt(i))) {
					int val = map.get(str.charAt(i));
					map.put(str.charAt(i), val + 1);
				} else {
					map.put(str.charAt(i), 1);
				}
			}

			int oddChar = 0;
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				if (entry.getValue() % 2 != 0) {
					oddChar++;
					if (oddChar > 1) {
						return null;
					}
				}
			}

			int len = str.length();
			int mid = len / 2;
			char midChar = ' ';
			StringBuilder str1 = new StringBuilder();
			for (Map.Entry<Character, Integer> entr : map.entrySet()) {
				char ch = entr.getKey();
				int val = entr.getValue();
				if (val % 2 != 0) {
					midChar = ch;
				}
				int i = val / 2;
				while (i > 0) {
					str1.append(ch);
					str1.insert(0, ch);
					i--;
				}
			}
			if (midChar != ' ') {
				str1.insert(mid, midChar);
			}
			return str1.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
