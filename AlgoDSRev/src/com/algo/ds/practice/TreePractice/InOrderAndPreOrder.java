package com.algo.ds.practice.TreePractice;

public class InOrderAndPreOrder {

	/**
	 * @param args
	 */
	private static int ind = 0;

	public static void main(String[] args) {

		try {
			char[] in = { 'D', 'B', 'E', 'A', 'F', 'C' };
			char[] pre = { 'A', 'B', 'D', 'E', 'C', 'F' };
			InOrderAndPreOrder tree = new InOrderAndPreOrder();
			TreeNodeIn tn = tree.buildTree(in, pre, 0, in.length - 1,
					in.length - 1);
			tree.inOrder(tn);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private TreeNodeIn buildTree(char[] in, char[] pre, int st, int end, int len) {
		try {
			if (st > end || ind > len) {
				return null;
			}
			TreeNodeIn tn = new TreeNodeIn(pre[ind++]);
			// ind++;
			if (st == end) {
				return tn;
			}
			int index = serch(in, st, end, tn.getData());
			tn.setLeft(buildTree(in, pre, st, index - 1, len));
			tn.setRight(buildTree(in, pre, index + 1, end, len));
			return tn;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private int serch(char[] in, int st, int end, int key) {
		try {

			for (int i = st; st <= end; st++) {
				if (key == in[i]) {
					return i;
				}
			}
			return -1;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void inOrder(TreeNodeIn tn) {
		if (tn != null) {
			inOrder(tn.getLeft());
			System.out.print(tn.getData() + ",");
			inOrder(tn.getRight());
		}
	}

}

class TreeNodeIn {
	private char data;
	private TreeNodeIn left;
	private TreeNodeIn right;

	public TreeNodeIn(char data) {
		this.data = data;
	}

	public void setLeft(TreeNodeIn left) {
		this.left = left;
	}

	public void setRight(TreeNodeIn right) {
		this.right = right;
	}

	public TreeNodeIn getLeft() {
		return left;
	}

	public TreeNodeIn getRight() {
		return right;
	}

	public char getData() {
		return data;
	}
}
