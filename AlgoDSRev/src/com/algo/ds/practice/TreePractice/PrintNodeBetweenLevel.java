package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintNodeBetweenLevel {

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
			PrintNodeBetweenLevel p = new PrintNodeBetweenLevel();
			p.printLeveRecu(root, 2, 7);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void printLeve(TreeNode root, int min, int max) {
		try {
			TreeNode tn = root;
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			int lev = 1;
			q.add(tn);
			int n = 0;
			while (true) {
				n = q.size();
				if (n == 0) {
					break;
				} else {
					while (n > 0) {
						tn = q.peek();
						q.poll();
						if (lev >= min && lev <= max) {
							System.out.print(tn.getData() + ",");
						}
						if (tn.getLeftChild() != null) {
							q.add(tn.getLeftChild());
						}
						if (tn.getRightChild() != null) {
							q.add(tn.getRightChild());
						}
						n--;
					}
					System.out.println();
					lev++;
				}
			}
		} catch (Exception ex) {

		}
	}

	private void printLeveRecu(TreeNode root, int min, int max) {
		for (int level = min; level <= max; level++) {
			printLeve1(root, level);
			System.out.println();
		}
	}

	private void printLeve1(TreeNode root, int level) {
		try {
			if (root == null) {
				return;
			}
			if (level == 1) {
				System.out.print(root.getData() + ",");
			}
			if (level > 1) {
				printLeve1(root.getLeftChild(), level - 1);
				printLeve1(root.getRightChild(), level - 1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
