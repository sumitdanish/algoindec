package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class TreeFromSortedLinkList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(new File("link.txt"));
			String[] a = sc.next().split(",");
			Node list = null;
			CreateLinkList cl = new CreateLinkList();
			for (String s : a) {
				list = cl.createListRecur(Integer.parseInt(s), list);
			}
			TreeFromSortedLinkList tr = new TreeFromSortedLinkList();
			TreeNode tn = tr.getTree(list, a.length);
			tr.printInOrder(tn);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private TreeNode getTree(Node n, int len) {
		try {
			if (len <= 0) {
				return null;
			}
			// int mid = sta+((len-sta)/2);
			TreeNode left = getTree(n, len / 2);
			TreeNode tree = new TreeNode(n.getData());
			tree.setLeft(left);
			n = n.getNextNode();
			tree.setRight(getTree(n, len - ((len / 2))));
			return tree;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private void printInOrder(TreeNode tn) {
		try {
			if (tn != null) {
				printInOrder(tn.getLeft());
				System.out.print(tn.getData() + ",");
				printInOrder(tn.getRight());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
