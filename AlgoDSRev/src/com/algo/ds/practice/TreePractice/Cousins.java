package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class Cousins {

	/**
	 * @param args
	 *            ALGO : For getting cousin in the tree two condition should be
	 *            must valid 1. both child should not be from same parents 2.
	 *            both child should be in same level
	 * 
	 * 
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
			Cousins c = new Cousins();
			if (c.isCousin(root, 1, 9)) {
				System.out.println("They Are");
			} else {
				System.out.println("They Are Not");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private boolean isCousin(TreeNode root, int t1, int t2) {
		try {
			if (root == null) {
				return false;
			}
			// System.out.println(getLevel(root, t1,1)+" > "+getLevel(root,
			// t2,1));
			if ((getLevel(root, t1, 1) == getLevel(root, t2, 1))
					&& !isSibling(root, t1, t2)) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private int getLevel(TreeNode root, int tn, int level) {
		try {
			if (root == null) {
				return 0;
			}
			if (root.getData() == tn) {
				return level;
			}
			int leftLevel = getLevel(root.getLeftChild(), tn, level + 1);
			if (leftLevel != -1 || leftLevel != 0) {
				return leftLevel;
			}
			return getLevel(root.getRightChild(), tn, level + 1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private boolean isSibling(TreeNode root, int tn1, int tn2) {
		try {
			if (root == null) {
				return false;
			}
			if (root.getLeftChild() != null && root.getRightChild() != null) {
				return (((root.getLeftChild().getData() == tn1 && root
						.getRightChild().getData() == tn2) || (root
						.getRightChild().getData() == tn1 && root
						.getLeftChild().getData() == tn2))
						|| isSibling(root.getLeftChild(), tn1, tn2) || isSibling(
						root.getRightChild(), tn1, tn2));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
