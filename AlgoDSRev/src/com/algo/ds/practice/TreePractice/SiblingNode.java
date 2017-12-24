package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class SiblingNode {

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
			SiblingNode sb = new SiblingNode();
			if (sb.isSibling(root, 1, 11)) {
				System.out.println("Yes its sibling");
			} else {
				System.out.println("Its Not Sibling");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

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
