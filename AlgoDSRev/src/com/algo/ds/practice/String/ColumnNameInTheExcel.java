package com.algo.ds.practice.String;

public class ColumnNameInTheExcel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int num = 80;
			String cn = new ColumnNameInTheExcel().getColumnName(num);
			System.out.println(cn);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private String getColumnName(int num) {
		try {
			int rem = 0;
			char[] ch = new char[10];
			String cn = new String();
			int i = 0;
			while (num > 0) {
				rem = num % 26;
				if (rem == 0) {
					ch[i] = 'Z';
					num = (num / 26) - 1;
				} else {
					ch[i] = (char) ((rem - 1) + 'A');
					num = num / 26;
				}
				i++;
			}
			for (int i1 = ch.length - 1; i1 >= 0; i1--) {
				if (ch[i1] != ' ' || ch[i1] != '\0') {
					cn += String.valueOf(ch[i1]);
				}
			}
			return cn;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
