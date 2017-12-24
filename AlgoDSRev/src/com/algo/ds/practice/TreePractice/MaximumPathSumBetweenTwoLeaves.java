package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class MaximumPathSumBetweenTwoLeaves {

	/**
	 * @param args
	 */
	static int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] a = sc.next().split(",");
			TreeNode root = null;
			MyTree mtree = new MyTree();
			for (String s : a) {
				root = mtree.createMyTree(root, Integer.parseInt(s));
			}
			MaximumPathSumBetweenTwoLeaves m = new MaximumPathSumBetweenTwoLeaves();
			int sum = m.maxSum(root);
			System.out.println(sum);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int maxSum(TreeNode root) {
		try {
			if (root == null) {
				return 0;
			}
			int leftSum = maxSum(root.getLeftChild());
			int rightSum = maxSum(root.getRightChild());
			int currSum = getMax((leftSum + rightSum) + root.getData(), getMax(
					leftSum, rightSum));
			if (currSum > maxSum) {
				maxSum = currSum;
			}
			return getMax(leftSum, rightSum) + root.getData();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMax(int a, int b) {
		try {
			return a >= b ? a : b;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
