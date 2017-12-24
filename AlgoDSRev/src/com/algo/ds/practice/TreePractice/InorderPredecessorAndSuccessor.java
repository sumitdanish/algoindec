package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class InorderPredecessorAndSuccessor {

	/**
	 * @param args
	 */

	static TreeNode pre;
	static TreeNode suc;

	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] a = sc.next().split(",");
			TreeNode root = null;
			MyTree mtree = new MyTree();
			for (String s : a) {
				root = mtree.createMyTree(root, Integer.parseInt(s));
			}
			InorderPredecessorAndSuccessor in = new InorderPredecessorAndSuccessor();
			in.inOrderPredeSuccesor(root, 9);
			System.out.println("Pre > " + pre.getData() + " Succ > "
					+ suc.getData());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void inOrderPredeSuccesor(TreeNode root, int key) {
		try {
			if (root == null) {
				return;
			}
			if (root.getData() == key) {
				if (root.getLeftChild() != null) {
					TreeNode tn = root.getLeftChild();
					while (tn != null && tn.getRightChild() != null) {
						tn = tn.getRightChild();
					}
					pre = tn.getRightChild();
				}
				if (root.getRightChild() != null) {
					TreeNode tn = root.getRightChild();
					while (tn != null && tn.getLeftChild() != null) {
						tn = tn.getLeftChild();
					}
					suc = tn.getLeftChild();
				}
				return;
			}
			if (root.getData() > key) {
				suc = root;
				inOrderPredeSuccesor(root.getLeftChild(), key);
			}
			if (root.getData() < key) {
				pre = root;
				inOrderPredeSuccesor(root.getRightChild(), key);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
