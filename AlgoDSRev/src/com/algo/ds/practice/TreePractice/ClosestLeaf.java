package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class ClosestLeaf {

	/**
	 * @param args
	 *            Find the closest leaf in a Binary Tree
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
			ClosestLeaf cl = new ClosestLeaf();
			int leaf = cl.closestLeaf(root, 12, 0, new TreeNode[18]);
			// int leaf = cl.closestLeafAcendence(root);
			System.out.println(leaf);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int closestLeaf(TreeNode tn, int tarNode, int index, TreeNode[] anc) {
		try {
			if (tn == null) {
				return Integer.MAX_VALUE;
			}
			if (tn.getData() == tarNode) {
				int res = closestLeafAcendence(tn);
				for (int i = index - 1; i >= 0; i--) {
					System.out.print(anc[i].getData() + ",");
					int an = closestLeafAcendence(anc[i]);
					res = getMin(res, index - i + an);
				}
				return res;
			}
			anc[index] = tn;
			return getMin(closestLeaf(tn.getLeftChild(), tarNode, index + 1,
					anc), closestLeaf(tn.getRightChild(), tarNode, index + 1,
					anc));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int closestLeafAcendence(TreeNode root) {
		try {
			if (root == null) {
				return Integer.MAX_VALUE;
			}
			if (root.getLeftChild() == null && root.getRightChild() == null) {
				return 0;
			}
			return getMin(closestLeafAcendence(root.getLeftChild()),
					closestLeafAcendence(root.getRightChild())) + 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMin(int a, int b) {
		try {
			return a > b ? b : a;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
