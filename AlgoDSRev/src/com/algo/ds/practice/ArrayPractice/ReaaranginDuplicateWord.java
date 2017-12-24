package com.algo.ds.practice.ArrayPractice;

public class ReaaranginDuplicateWord {

	/**
	 * @param args
	 */
	static MaxHeap[] maxHeap;
	static int maxSize = 256;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String str = "aabbcc";
			ReaaranginDuplicateWord re = new ReaaranginDuplicateWord();
			re.insert(str);
			for (int i = 0; i < str.length(); i++) {
				int f = re.extract(maxSize - i);
				System.out.print(f + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int extract(int max) {
		try {
			int fr = 0;
			if (max > 1) {
				maxHeap[0] = maxHeap[max - 1];
				fr = maxHeap[0].getFre();
				maxHepify(0);
			}
			return fr;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void insert(String str) {
		try {
			MaxHeap[] maxHeap1 = new MaxHeap[maxSize];
			char[] ch = new char[256];
			for (int i = 0; i < str.length(); i++) {
				char ch1 = str.charAt(i);
				ch[ch1]++;
				MaxHeap m = new MaxHeap();
				m.setCh(ch1);
				m.setFre(ch[str.charAt(i)]);
				maxHeap1[str.charAt(i)] = m;
			}
			// for(int i=0;i<str.length();i++)
			// {
			// char ch2 = str.charAt(i);
			// if(maxHeap1[ch2].getFre()==0)
			// {
			// maxHeap1[ch2].setCh(ch2);
			// }
			// int f = maxHeap1[ch2].getFre();
			// maxHeap1[ch2].setFre(f++);
			// }
			buildHeap(maxHeap1, maxSize);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void buildHeap(MaxHeap[] maxHeap1, int size) {
		maxHeap = maxHeap1;
		int i = (size - 1) / 2;
		while (i >= 0) {
			maxHepify(i);
			i--;
		}
	}

	private void maxHepify(int i) {
		try {
			int left = getLeft(i);
			int right = getRight(i);
			int s = i;
			if (left < maxSize && maxHeap[left].getFre() > maxHeap[s].getFre()) {
				s = left;
			}
			if (right < maxSize
					&& maxHeap[right].getFre() > maxHeap[s].getFre()) {
				s = right;
			}
			if (s != i) {
				MaxHeap m = maxHeap[i];
				maxHeap[i] = maxHeap[s];
				maxHeap[s] = m;
				maxHepify(s);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int getParent(int i) {
		return 2 * i;
	}

	public int getLeft(int i) {
		return 2 * i + 1;
	}

	public int getRight(int i) {
		return 2 * i + 2;
	}

}

class MaxHeap {
	private char ch;
	private int fre = 0;

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

	public int getFre() {
		return fre;
	}

	public void setFre(int fre) {
		this.fre = fre;
	}

}