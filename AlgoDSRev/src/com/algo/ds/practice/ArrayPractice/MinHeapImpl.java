package com.algo.ds.practice.ArrayPractice;

public class MinHeapImpl {

	/**
	 * @param args
	 * 
	 *            Print all elements in sorted order from row and column wise
	 *            sorted matrix
	 */

	MinHeapNode[] minHeap;
	int min_heap_size;

	public MinHeapImpl(MinHeapNode[] heap, int heap_size) {
		try {
			minHeap = heap;
			min_heap_size = heap_size;
			int i = (heap_size - 1) / 2;
			while (i >= 0) {
				minHepify(i);
				i--;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public MinHeapImpl() {

	}

	private void minHepify(int i) {
		try {
			int left = getLeftChildIndex(i);
			int right = getRightIndex(i);
			int s = i;
			if (left < min_heap_size
					&& minHeap[left].getElement() < minHeap[s].getElement()) {
				s = left;
			}
			if (right < min_heap_size
					&& minHeap[right].getElement() < minHeap[s].getElement()) {
				s = right;
			}
			if (s != i) {
				MinHeapNode temp = minHeap[i];
				minHeap[i] = minHeap[s];
				minHeap[s] = temp;
				minHepify(s);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int getLeftChildIndex(int i) {
		try {
			return (2 * i) + 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getRightIndex(int i) {
		try {
			return (2 * i) + 2;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private MinHeapNode getMinHeapNode() {
		try {
			return minHeap[0];
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private void replace(MinHeapNode h) {
		try {
			minHeap[0] = h;
			minHepify(0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void printMat(int[][] mat, int n) {
		try {
			MinHeapNode[] m = new MinHeapNode[n];
			for (int i = 0; i < n; i++) {
				MinHeapNode mh = new MinHeapNode(i, 1, mat[i][0]);
				m[i] = mh;
			}
			MinHeapImpl mh = new MinHeapImpl(m, n);
			for (int i = 0; i < n * n; i++) {
				MinHeapNode mn = mh.getMinHeapNode();
				System.out.print(mn.getElement() + ",");
				if (mn.i < n && mn.j < n) {
					mn.element = mat[mn.i][mn.j];
					mn.j += 1;
				} else {
					mn.element = Integer.MAX_VALUE;
				}
				mh.replace(mn);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class MinHeapNode {

	public int i;
	public int j;
	public int element;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public MinHeapNode(int i, int j, int element) {
		super();
		this.i = i;
		this.j = j;
		this.element = element;
	}

	public MinHeapNode(int i, int element) {
		super();
		this.i = i;
		this.element = element;
	}

}
