package com.algo.ds.practice.ArrayPractice;

public class HeapImpl {

	/**
	 * @param args
	 */
	static int[] heap;
	static int len = 0;
	static int front = 1;

	public HeapImpl(int size) {
		try {
			heap = new int[size];
			System.out.println(len);
			heap[0] = Integer.MIN_VALUE;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int getLeftChild(int pos) {
		try {
			return (2 * pos);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getRightChild(int pos) {
		try {
			return (2 * pos + 1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getParent(int pos) {
		try {
			return (pos / 2);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void swapHeapNode(int pos, int leftOrRightNodeIndex) {
		try {
			int temp = heap[pos];
			;
			heap[pos] = heap[leftOrRightNodeIndex];
			heap[leftOrRightNodeIndex] = temp;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void minHeapify(int pos) {
		try {
			if (!isLeafNode(pos)) {
				if (heap[pos] > heap[getLeftChild(pos)]
						|| heap[pos] > heap[getRightChild(pos)]) {
					if (heap[getLeftChild(pos)] < heap[getRightChild(pos)]) {
						swapHeapNode(pos, getLeftChild(pos));
						minHeapify(getLeftChild(pos));
					} else {
						swapHeapNode(pos, getRightChild(pos));
						minHeapify(getRightChild(pos));
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void insert(int item) {
		try {
			heap[++len] = item;
			int current = len;
			while (heap[current] < heap[getParent(current)]) {
				swapHeapNode(current, getParent(current));
				current = getParent(current);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private boolean isLeafNode(int pos) {
		try {
			if (pos >= (len / 2) && pos <= len) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private void print() {
		try {
			for (int i = 1; i <= len / 2; i++) {
				System.out.println("Parent > " + heap[i]
						+ "       leftChild > " + heap[2 * i]
						+ "       rightChild" + heap[2 * i + 1]);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int remove() {
		try {
			int min = heap[front];
			heap[front] = heap[len--];
			minHeapify(front);
			front++;
			return min;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void miHeap() {
		int pos = 0;
		for (pos = len / 2; pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	public static void main(String[] args) {

		try {
			HeapImpl minHeap = new HeapImpl(15);
			minHeap.insert(5);
			minHeap.insert(3);
			minHeap.insert(17);
			minHeap.insert(10);
			minHeap.insert(84);
			minHeap.insert(19);
			minHeap.insert(6);
			minHeap.insert(22);
			minHeap.insert(9);
			minHeap.miHeap();
			minHeap.print();
			System.out.println("Min Element > " + minHeap.remove() + "\n");

			minHeap.print();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
