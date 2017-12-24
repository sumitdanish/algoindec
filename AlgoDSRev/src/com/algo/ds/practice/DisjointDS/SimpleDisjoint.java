package com.algo.ds.practice.DisjointDS;

public class SimpleDisjoint {

	/**
	 * @param args
	 */
	static char[] pare = new char[300];
	static int[] rank;

	public SimpleDisjoint() {
		rank = new int[300];
	}

	public static void main(String[] args) {

		try {
			SimpleDisjoint sd = new SimpleDisjoint();
			char[] ch = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
			sd.MRKERByRank(ch);
			sd.UNIONByRank('G', 'H');
			char find = sd.FINDByRank('D');
			System.out.println(find);
			sd.UNIONByRank('G', 'C');
			find = sd.FINDByRank('H');
			System.out.println(find + " > " + rank['G']);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private char FIND(char c) {
		try {
			if (pare[c] == c) {
				return pare[c];
			}
			return FIND(pare[c]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ' ';
	}

	private void UNION(char ch, char ch1) {
		try {
			pare[ch] = ch1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void MARKER(char[] ch) {
		try {
			for (char c : ch) {
				pare[c] = c;
			}
			/*Parent of d*/
			pare['D'] = 'B';
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/* Union,Find and Marker and By Rank */

	private void MRKERByRank(char[] ch) {
		try {
			for (char c : ch) {
				pare[c] = c;
				rank[c] = 0;
			}
			pare['D'] = 'B';
			rank['B'] = 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private char FINDByRank(char ch) {
		try {
			if (pare[ch] == ch) {
				return pare[ch];
			}
			return FINDByRank(pare[ch]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ' ';
	}

	/* By implementing rank concept we can */

	private void UNIONByRank(char ch1, char ch2) {
		try {
			if (rank[ch1] > rank[ch2]) {
				pare[ch2] = ch1;
				rank[ch1]++;
			} else if (rank[ch1] < rank[ch2]) {
				pare[ch1] = ch2;
				rank[ch2]++;
			} else {
				System.out.println(rank[ch1]);
				pare[ch2] = ch1;
				rank[ch1]++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
