package com.algo.ds.practice.TreePractice;

public class HeightOfTreeByArray {

	/**
	 * @param args
	 *            Find Height of Binary Tree represented by Parent array
	 */
	public static void main(String[] args) {

		try {
			int[] parent = { -1, 0, 0, 1, 1, 3, 5 };
			;
			new HeightOfTreeByArray().height(parent);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void height(int[] parent) {
		int max = Integer.MIN_VALUE;
		int[] depth = new int[parent.length];
		for (int i = 0; i < parent.length; i++) {
			if (parent[i] == -1) {
				depth[i] = 1;
			} else if (depth[parent[i]] == 0) {
				depth[parent[i]] = 1;
			} else {
				depth[i] = depth[parent[i]] + 1;
			}
			if (max < depth[i]) {
				max = depth[i];
			}
		}
		System.out.println(max);
	}

}
