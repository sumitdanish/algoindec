package com.algo.ds.practice.TreePractice;

import java.util.Arrays;

public class TreeFromInOrderLevelOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] in = { 4, 8, 10, 12, 14, 20, 22 };
			int[] level = { 20, 8, 22, 4, 12, 10, 14 };
			TreeFromInOrderLevelOrder tree = new TreeFromInOrderLevelOrder();
			TreeNode tr = tree
					.buildTree(in, level, 0, in.length - 1, in.length);
			tree.inOrder(tr);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void inOrder(TreeNode tn) {
		try {
			if (tn != null) {
				inOrder(tn.getLeftChild());
				System.out.print(tn.getData() + ",");
				inOrder(tn.getRightChild());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private TreeNode buildTree(int[] in, int[] level, int start, int end, int n) {
		try {
			if (start > end) {
				return null;
			}
			TreeNode node = new TreeNode(level[0]);
			if (start == end) {
				return node;
			}
			int index = search(in, start, end, node.getData());
			int[] leftLevel = extractKey(in, level, index, n);
			int[] rightNewLevel = Arrays.copyOfRange(in, index + 1, n);
			int[] rightLevel = extractKey(rightNewLevel, level, n - index - 1,
					n);
			node.setLeftChild(buildTree(in, leftLevel, start, index - 1, n));
			node.setRightChild(buildTree(in, rightLevel, index + 1, end, n));
			return node;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private int[] extractKey(int[] in, int[] lev, int index, int n) {
		try {
			int[] newLev = new int[index];
			int j = 0;
			for (int i = 0; i < index; i++) {

				if (search(in, 0, index - 1, lev[i]) != -1) {
					newLev[j] = lev[i];
					j++;
				}
			}
			return newLev;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private int search(int[] inoder, int start, int end, int key) {
		try {
			for (int i = start; i <= end; i++) {
				if (inoder[i] == key) {
					System.out.println(key + " > " + i);
					return i;
				}
			}
			return -1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
