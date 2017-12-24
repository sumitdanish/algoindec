package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class RotateLinkList {

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
			sc.close();
			RotateLinkList rotate = new RotateLinkList();
			cl.print(list);
			System.out.println("\n_____________________________________\n");
			Node li = rotate.reverseAlternateKGroupOfNode(list, 3);
			cl.print(li);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private Node rotateList(Node list, int k) {
		try {
			Node n = list;
			while (n != null && k > 0) {
				n = n.getNextNode();
				k--;
			}
			if (n == null) {
				return n;
			}
			Node n1 = n;
			while (n.getNextNode() != null) {
				n = n.getNextNode();
			}
			n.setNextNode(list);
			list = n1.getNextNode();
			n1.setNextNode(null);
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node rotateALterNate(Node list, int k) {
		try {
			Node n = list;
			Node temp = null;
			Node n1 = null;
			Node n2 = null;
			int k1 = k;
			while (n != null) {
				Node t = null;
				temp = n.getNextNode();
				k1 = k;
				while (temp != null && k1 > 0) {
					n.setNextNode(t);
					t = n;
					n = temp;
					temp = temp.getNextNode();
					k1--;
				}
				if (n1 == null) {
					n1 = t;
					n2 = n1;
				} else {
					while (n1.getNextNode() != null) {
						n1 = n1.getNextNode();
					}
					n1.setNextNode(t);
					n1 = t;
				}
				k1 = k;
				n = temp;
			}
			list = n2;
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node reverAlterNateNodeUsingRecursion(Node list, int k) {
		try {
			Node result = list;
			Node pre = null;
			Node n = null;
			int k1 = k;
			while (result != null && k > 0) {
				n = result.getNextNode();
				result.setNextNode(pre);
				pre = result;
				result = n;
				k--;
			}
			if (n != null) {
				list.setNextNode(reverAlterNateNodeUsingRecursion(n, k1));
			}
			return pre;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node reverseAlternateKGroupOfNode(Node list, int k) {
		try {
			Node n = list;
			Node pre = null;
			Node n1 = null;
			int k1 = k;
			while (n != null && k > 0) {
				n1 = n.getNextNode();
				n.setNextNode(pre);
				pre = n;
				n = n1;
				k--;
			}
			if (n != null) {
				list.setNextNode(n);
			}
			int k2 = k1;
			while (n != null && k1 > 0) {
				n = n.getNextNode();
				k1--;
			}
			if (n != null) {
				n
						.setNextNode(reverseAlternateKGroupOfNode(n
								.getNextNode(), k2));
			}
			return pre;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
