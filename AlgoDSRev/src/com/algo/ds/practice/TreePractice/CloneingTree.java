package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class CloneingTree {

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
			CloneingTree cl = new CloneingTree();
			TreeNode t = cl.clone(root);
			cl.inOrder(t);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private TreeNode clone(TreeNode root) {
		try {
			if (root == null) {
				return null;
			}
			HashMap<TreeNode, TreeNode> cloneMap = new HashMap<TreeNode, TreeNode>();
			TreeNode clone = cloneTree(root, cloneMap);
			cloneRandomPointer(root, clone, cloneMap);
			return clone;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public TreeNode cloneTree(TreeNode root,
			HashMap<TreeNode, TreeNode> cloneMap) {
		try {
			if (root == null) {
				return null;
			}
			TreeNode cloneTree = new TreeNode(root.getData());
			cloneMap.put(root, cloneTree);
			cloneTree.setLeftChild(cloneTree(root.getLeftChild(), cloneMap));
			cloneTree.setRightChild(cloneTree(root.getRightChild(), cloneMap));
			return cloneTree;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void cloneRandomPointer(TreeNode root, TreeNode clone,
			HashMap<TreeNode, TreeNode> cloneMap) {
		try {
			if (root == null || cloneMap == null) {
				return;
			}
			clone.setRandom(cloneMap.get(root));
			cloneRandomPointer(root.getLeftChild(), clone.getLeftChild(),
					cloneMap);
			cloneRandomPointer(root.getRightChild(), clone.getRightChild(),
					cloneMap);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void inOrder(TreeNode root) {
		try {
			if (root != null) {
				inOrder(root.getLeftChild());
				System.out.print("{" + root.getData() + "-");
				if (root.getRandom() == null) {
					System.out.print("null }\n");
				} else {
					System.out.print(root.getRandom().getData() + " } \n");
				}
				inOrder(root.getRightChild());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
