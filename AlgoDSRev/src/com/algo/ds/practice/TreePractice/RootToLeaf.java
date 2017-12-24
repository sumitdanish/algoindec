package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class RootToLeaf {

	/**
	 * @param args
	 */
	static int max = Integer.MIN_VALUE;
	static TreeNode tar;

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

			RootToLeaf r = new RootToLeaf();
			int sum = 0;

			r.getSumRootToLeaf(root, sum);
			System.out.println(max + " > " + tar.getData());
			r.printPath(root, tar);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void getSumRootToLeaf(TreeNode root, int sum) {
		try {
			if (root == null) {
				return;
			}
			sum += root.getData();
			if (root.getLeftChild() == null && root.getRightChild() == null) {
				if (sum > max) {
					max = sum;
					tar = root;
				}
			}
			getSumRootToLeaf(root.getLeftChild(), sum);
			getSumRootToLeaf(root.getRightChild(), sum);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private boolean printPath(TreeNode tree, TreeNode tar) {
		try {
			if (tree == null) {
				return false;
			}
			if (tree.getData() == tar.getData()
					|| printPath(tree.getLeftChild(), tar)
					|| printPath(tree.getRightChild(), tar)) {
				System.out.print(tree.getData() + ",");
				return true;
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
