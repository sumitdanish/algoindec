package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintTopVIew {

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
			PrintTopVIew p = new PrintTopVIew();
			p.topView(root);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void topView(TreeNode root) {
		try {
			Queue<TreeN> q = new LinkedList<TreeN>();
			TreeNode tn = root;
			HashSet<Integer> h = new HashSet<Integer>();
			q.add(new TreeN(tn, 0));
			int hd = 0;
			while (tn != null && !q.isEmpty()) {
				TreeN t = q.peek();
				q.poll();
				tn = t.getTree();
				hd = t.getHd();
				if (!h.contains(hd)) {
					h.add(hd);
					System.out.print(tn.getData() + ",");
				}
				if (tn.getLeftChild() != null) {
					q.add(new TreeN(tn.getLeftChild(), hd - 1));
				}
				if (tn.getRightChild() != null) {
					q.add(new TreeN(tn.getRightChild(), hd + 1));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class TreeN {
	TreeNode tree;
	int hd;

	public TreeN(TreeNode tn, int hd) {
		this.tree = tn;
		this.hd = hd;
	}

	public TreeNode getTree() {
		return tree;
	}

	public int getHd() {
		return hd;
	}
}
