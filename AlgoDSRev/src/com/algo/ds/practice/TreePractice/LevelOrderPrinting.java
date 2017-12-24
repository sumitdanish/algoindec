package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class LevelOrderPrinting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] a = sc.next().split(",");
			TreeNode root = null;
			MyTree mtree = new MyTree();
			for (String s : a) {
				root = mtree.createMyTree(root, Integer.parseInt(s));
			}
			LevelOrderPrinting le = new LevelOrderPrinting();
			int h = le.getHeight(root);
			// System.out.println(h);
			for (int i = 1; i <= h; i++) {
				le.leveOrder(root, i);
				System.out.println();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void leveOrder(TreeNode root, int level) {
		try {
			if (root == null) {
				return;
			}
			if (level == 1) {
				System.out.print(root.getData() + ",");
			}
			if (level > 1) {
				leveOrder(root.getLeftChild(), level - 1);
				leveOrder(root.getRightChild(), level - 1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int getHeight(TreeNode tn) {
		try {
			if (tn == null) {
				return 0;
			}
			int left = getHeight(tn.getLeftChild());
			int right = getHeight(tn.getRightChild());
			if (left >= right) {
				return left + 1;
			}
			return right + 1;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
