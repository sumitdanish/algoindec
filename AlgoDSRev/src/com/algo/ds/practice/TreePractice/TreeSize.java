package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class TreeSize {

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
			TreeSize ts = new TreeSize();
			int si = ts.size(root);
			System.out.println(si);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public int size(TreeNode root) {
		try {
			if (root == null) {
				return 0;
			}
			return (size(root.getLeftChild()) + size(root.getRightChild()) + 1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
