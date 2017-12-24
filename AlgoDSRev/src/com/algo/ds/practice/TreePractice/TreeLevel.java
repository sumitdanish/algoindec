package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class TreeLevel {

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
			TreeLevel tl = new TreeLevel();
			int le = tl.getLevel(root, new TreeNode(11), 1);
			System.out.println(le);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getLevel(TreeNode root, TreeNode tn, int level) {
		try {
			if (root == null) {
				return level;
			}
			if (root.getData() == tn.getData()) {
				return level;
			}
			int le = getLevel(root.getLeftChild(), tn, level + 1);
			if (le != -1 || le != 0) {
				return le;
			}
			return getLevel(root.getRightChild(), tn, level + 1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
