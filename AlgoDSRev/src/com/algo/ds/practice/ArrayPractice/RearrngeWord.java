package com.algo.ds.practice.ArrayPractice;

public class RearrngeWord {

	public static void main(String[] args) {
		try {
			String str = "aabbcc";
			int d = 2;
			String st = new RearrngeWord().arrange(str, d);
			System.out.println(st);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private String arrange(String str, int d) {
		try {
			int[] count1 = count(str);
			char[] ch = new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				int f = count1[str.charAt(i)];
				if (f != 0) {
					System.out.println(f + " > " + str.charAt(i));
					char c = str.charAt(i);
					int p = i;
					while (ch[p] != '\0') {
						p++;
					}
					for (int k = 0; k < f; k++) {
						if (p + k * d > str.length()) {
							System.exit(0);
							break;
						} else if (p + k * d < str.length()) {
							ch[p + k * d] = str.charAt(i);
						}
					}
				}
			}
			return String.valueOf(ch);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private int[] count(String str) {
		try {
			int[] count1 = new int[256];
			for (int i = 0; i < str.length(); i++) {
				count1[str.charAt(i)]++;
			}
			return count1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
