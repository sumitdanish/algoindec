package com.algo.ds.practice.ArrayPractice;

public class MinHeapSortNearlySortedArray {

	int min_size = 0;
	MinHeapNode1[] min;

	public MinHeapSortNearlySortedArray() {

	}

	public MinHeapSortNearlySortedArray(MinHeapNode1[] min, int min_size) {
		super();
		this.min = min;
		this.min_size = min_size;
		int x = min_size;
		try {
			int i = (x - 1) / 2;
			while (i >= 0) {
				minHepify(i);
				i--;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int getLeftChild(int i) {
		try {
			return (2 * i + 1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getRightChild(int i) {
		try {
			return (2 * i + 2);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getParent(int i) {
		try {
			return 2 * i;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void minHepify(int i) {
		try {
			int left = getLeftChild(i);
			int right = getRightChild(i);
			int s = i;
			if (left < min_size && min[left].getElement() < min[s].getElement()) {
				s = left;
			}
			if (right < min_size
					&& min[right].getElement() < min[s].getElement()) {
				s = right;
			}
			if (s != i) {
				MinHeapNode1 h = min[i];
				min[i] = min[s];
				min[s] = h;
				minHepify(s);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int replace(int i) {
		try {
			MinHeapNode1 mh = new MinHeapNode1(i, i);
			int val = min[0].getElement();
			min[0] = mh;
			if (val < i) {
				minHepify(0);
			}
			return val;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int extractRemaingElement() {
		try {
			int val = min[0].getElement();
			if (min_size > 1) {
				System.out.println(">>" + min_size);
				min[0] = min[min_size--];
				minHepify(0);
			}
			return val;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	public void printArray(int[] a, int k) {
		try {
			int i = 0;
			int ti = 0;
			MinHeapNode1[] m = new MinHeapNode1[k + 1];
			for (i = 0; i < k && i < a.length; i++) {
				MinHeapNode1 mi = new MinHeapNode1(i, a[i]);
				m[i] = mi;
			}
			MinHeapSortNearlySortedArray mh = new MinHeapSortNearlySortedArray(
					m, k + 1);
			for (i = k, ti = 0; i < a.length && ti < a.length; ti++, i++) {
				if (i < a.length) {
					a[ti] = mh.replace(a[i]);
				} else {
					a[ti] = mh.extractRemaingElement();
				}
			}

			for (int p = 0; p < a.length; p++) {
				System.out.print(a[p] + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
