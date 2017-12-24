package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class CreateTree {

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

			int si = mtree.size(root);
			System.out.println(si);
			// int dep = mtree.depth(root);
			// System.out.println(dep);
			// mtree.inOrder(root);
			// System.out.println("\n\n");
			// mtree.iterativeInoRder(root);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

class MyTree {
	public MyTree() {

	}

	public TreeNode createMyTree(TreeNode root, int data) {
		try {
			TreeNode leaf = new TreeNode(data);
			if (root == null) {
				root = leaf;
			} else if (root.getData() < data) {
				root.setRightChild(createMyTree(root.getRightChild(), data));
			} else if (root.getData() > data) {
				root.setLeftChild(createMyTree(root.getLeftChild(), data));
			}
			return root;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void inOrder(TreeNode root) {
		try {
			if (root != null) {
				inOrder(root.getLeftChild());
				System.out.print(root.getData() + ",");
				inOrder(root.getRightChild());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.getData() + ",");
			preOrder(root.getLeftChild());
			preOrder(root.getRightChild());
		}
	}

	public void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.getLeftChild());
			postOrder(root.getRightChild());
			System.out.print(root.getData() + ",");
		}
	}

	public void iterativeInoRder(TreeNode root) {
		try {
			TreeNode tn = root;
			Stack<TreeNode> st = new Stack<TreeNode>();
			st.push(tn);
			while (true) {
				if (st.isEmpty()) {
					break;
				}
				if (tn.getLeftChild() != null) {
					st.push(tn.getLeftChild());
					tn = tn.getLeftChild();
				} else {
					tn = st.peek();
					st.pop();
					System.out.print(tn.getData() + ",");
					if (tn.getRightChild() != null) {
						st.push(tn.getRightChild());
						tn = tn.getRightChild();
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void iterativePreOrder(TreeNode root) {
		try {
			TreeNode tn = root;
			Stack<TreeNode> st = new Stack<TreeNode>();
			st.push(tn);
			while (true) {
				if (st.isEmpty()) {
					break;
				} else {
					TreeNode t = st.peek();
					st.pop();
					System.out.print(t.getData() + ",");
					if (t.getRightChild() != null) {
						st.push(t.getRightChild());
						// t=t.getLeftChild();
					}
					if (t.getLeftChild() != null) {
						st.push(t.getLeftChild());
						// t=t.getRightChild();
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/* Maximum Depth of the tree is height of the tree */

	public int depth(TreeNode root) {
		try {
			if (root == null) {
				return 0;
			} else {
				int leftDepth = depth(root.getLeftChild());
				int rightDepth = depth(root.getRightChild());
				if (leftDepth >= rightDepth) {
					return leftDepth + 1;
				}
				return rightDepth + 1;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	public int size(TreeNode root) {
		try {
			if (root == null) {
				return 0;
			}
			return (size(root.getLeftChild()) + size(root.getRightChild()) + 1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}

class TreeNode {
	int data;
	TreeNode leftChild;
	TreeNode rightChild;
	TreeNode random;
	private boolean isThreaded;

	public TreeNode(int data) {
		this.data = data;
	}

	public int getData() {
		try {
			return data;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	public TreeNode getLeftChild() {
		try {
			return leftChild;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public TreeNode getRightChild() {
		try {
			return rightChild;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void setLeftChild(TreeNode leftChild) {
		try {
			this.leftChild = leftChild;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setRightChild(TreeNode rightChild) {
		try {
			this.rightChild = rightChild;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setIsThreaded(boolean isThreaded) {
		try {
			this.isThreaded = isThreaded;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public TreeNode getRandom() {
		return random;
	}

	public void setRandom(TreeNode random) {
		this.random = random;
	}

	public boolean isThreaded() {
		try {
			return isThreaded;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}