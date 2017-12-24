package com.algo.ds.practice.ArrayPractice;

public class MedainOfStream {

	/**
	 * @param args
	 */

	static HeapData[] maxHeap;
	static HeapData[] minHeap;
	static int max_heap_size;
	static int min_heap_size;
	static int st_heap_size = 0;
	static int sm_heap_size = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class MinHeap {
		public MinHeap(int maxSize) {
			min_heap_size = maxSize;
			minHeap = new HeapData[min_heap_size];
		}

		private int getParent(int i) {
			try {
				return 2 * i;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return -1;
		}

		private int getLeftChild(int i) {
			try {
				return (2 * i + 1);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return -1;
		}
	}

	class MaxHeap {

		public MaxHeap(int maxSize) {
			max_heap_size = maxSize;
			maxHeap = new HeapData[maxSize];
		}

		public int getParent(int i) {
			try {
				return (2 * i);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return -1;
		}

		public int getLeftChild(int i) {
			try {
				return (2 * i + 1);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return -1;
		}

		public int getRightChild(int i) {
			try {
				return (2 * i + 2);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return -1;
		}

		public void maxHeapify(int i) {
			try {
				int lc = getLeftChild(i);
				int rc = getRightChild(i);
				int s = i;
				if (lc < max_heap_size && maxHeap[lc].ele > maxHeap[s].ele) {
					s = lc;
				}
				if (rc < max_heap_size && maxHeap[rc].ele > maxHeap[s].ele) {
					s = rc;
				}
				if (s != i) {
					swapHeap(i, s);
					maxHeapify(s);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		public void swapHeap(int i, int s) {
			try {
				HeapData he = maxHeap[i];
				maxHeap[i] = maxHeap[s];
				maxHeap[s] = he;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		private void swiftMaxHeap(int i) {
			try {
				int p = getParent(i);
				if (maxHeap[p].ele < maxHeap[i].ele) {
					swapHeap(p, i);
					swiftMaxHeap(p);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		private void maxInsert(int val) {
			try {
				int index = st_heap_size;
				HeapData h = new HeapData(val, index);
				maxHeap[index] = h;
				swiftMaxHeap(index);
				st_heap_size++;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	class HeapData {
		public int ele;
		public int index;

		public void setEle(int ele) {
			this.ele = ele;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public int getEle() {
			return ele;
		}

		public int getIndex() {
			return index;
		}

		public HeapData(int ele, int index) {
			this.ele = ele;
			this.index = index;
		}
	}

}
