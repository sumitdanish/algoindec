package com.algo.ds.practice.String;

public class FindPossibleDecoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String data = "123";
			int count = new FindPossibleDecoding().countDecoding(data
					.toCharArray(), data.length());
			// int c = new FindPossibleDecoding().countDecoding(data, len)
			System.out.println(count);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	//

	private int CountDecoding(char[] data, int len) {
		try {
			if (len == 0 || len == 1) {
				return 1;
			}
			int count = 0;
			if (data[len - 1] > '0') {
				count += CountDecoding(data, len - 1);
			}
			if (data[len - 2] < '2'
					|| (data[len - 2] == '2' && data[len - 1] < '7')) {
				count += CountDecoding(data, len - 2);
			}
			return count;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int countDecoding(char[] data, int len) {
		try {
			int[] count = new int[data.length + 1];
			count[0] = 1;
			count[1] = 1;
			int len1 = data.length;
			for (int i = 2; i <= data.length; i++) {
				count[i] = 0;
				if (data[i - 1] > '0') {
					count[i] = count[i - 1];
				}
				if (data[i - 2] < '2'
						|| (data[i - 2] == '2' && data[i - 1] < '7')) {
					count[i] += count[i - 2];
				}
			}
			return count[data.length];
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
