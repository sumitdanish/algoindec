package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class SplitLinkList {

	/**
	 * @param args
	 */
	static Node a1;
	static Node b;
	static Node li;

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
			SplitLinkList spl = new SplitLinkList();
			// spl.splitLinkList(list);
			// // cl.print(a1);
			// System.out.println("\n______________\n");
			// // cl.print(b);
			// Node ni = spl.sortedMerge(a1,b);
			spl.merge(list);
			li = list;
			cl.print(li);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void merge(Node list) {
		try {
			if (list == null || list.getNextNode() == null) {
				return;
			}
			splitLinkList(list);
			merge(a1);
			merge(b);
			list = sortedMerge(a1, b);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void splitLinkList(Node root) {
		try {
			Node slow = root;
			Node fast = root.getNextNode();
			a1 = slow;
			while (fast.getNextNode() != null) {
				fast = fast.getNextNode().getNextNode();
				slow = slow.getNextNode();
			}
			b = slow.getNextNode();
			slow.setNextNode(null);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private Node sortedMerge(Node a, Node b) {
		try {
			Node f = null;
			Node f1 = null;
			if (a == null || b.getNextNode() == null) {
				f = b;
			} else if (b == null || a.getNextNode() == null) {
				f = a;
			} else {
				if (a.getData() <= b.getData()) {
					f = new Node(a.getData());
					a = a.getNextNode();
				} else if (a.getData() >= b.getData()) {
					f = new Node(b.getData());
					b = b.getNextNode();
				}
				f1 = f;
				while (a != null && b != null) {
					if (a.getData() >= b.getData()) {
						f1.setNextNode(b);
						f1 = f1.getNextNode();
						b = b.getNextNode();
					} else if (a.getData() <= b.getData()) {
						f1.setNextNode(a);
						a = a.getNextNode();
						f1 = f1.getNextNode();
					}
				}
				if (a == null && b != null) {
					f1.setNextNode(b);
				} else if (b == null && a != null) {
					f1.setNextNode(a);
				}
			}
			return f;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
