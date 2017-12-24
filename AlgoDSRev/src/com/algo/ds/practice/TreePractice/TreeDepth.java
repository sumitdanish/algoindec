package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class TreeDepth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] a = sc.next().split(",");
			TreeNode root = null;
			MyTree mtree = new MyTree();
			for (String s : a) {
				root = mtree.createMyTree(root, Integer.parseInt(s));
			}
			TreeDepth td = new TreeDepth();
			int dep = td.depth(root);
			System.out.println(dep);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public int depth(TreeNode root) {
		try {
			if (root == null) {
				return 0;
			} else {
				int leftDepth = depth(root.getLeftChild());
				int rightDepth = depth(root.getRightChild());
				if (leftDepth >= rightDepth) {
					return leftDepth + 1;
				}
				return rightDepth + 1;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
