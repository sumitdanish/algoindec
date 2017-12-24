package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ThreadedTree {

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
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			ThreadedTree t = new ThreadedTree();
			t.populateQueue(root, q);
			t.createThreaded(root, q);
			t.inOrderThreaded(root);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void populateQueue(TreeNode tn, Queue<TreeNode> q) {
		try {
			if (tn == null) {
				return;
			}
			if (tn.getLeftChild() != null) {
				populateQueue(tn.getLeftChild(), q);
			}
			q.add(tn.getLeftChild());
			if (tn.getRightChild() != null) {
				populateQueue(tn.getRightChild(), q);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void createThreaded(TreeNode tn, Queue<TreeNode> q) {
		try {
			if (tn == null) {
				return;
			}
			if (tn.getLeftChild() != null) {
				createThreaded(tn.getLeftChild(), q);
			}
			q.poll();
			if (tn.getRightChild() != null) {
				createThreaded(tn.getRightChild(), q);
			} else {
				tn.setRightChild(q.peek());
				tn.setIsThreaded(true);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void inOrderThreaded(TreeNode root) {
		try {
			TreeNode cur = getLeftNode(root);
			while (cur != null) {
				System.out.print(cur.getData() + ",");
				if (cur.isThreaded()) {
					cur = cur.getRightChild();
				} else {
					cur = getLeftNode(cur.getRightChild());
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private TreeNode getLeftNode(TreeNode root) {
		try {
			TreeNode tn = root;
			while (tn != null && tn.getLeftChild() != null) {
				tn = tn.getLeftChild();
			}
			return tn;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
