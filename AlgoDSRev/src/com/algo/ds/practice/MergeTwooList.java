package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class MergeTwooList {

	/**
	 * @param args
	 */

	Node mergeList;

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
			sc = new Scanner(new File("link1.txt"));
			String[] a1 = sc.next().split(",");
			Node list1 = null;
			for (String s : a1) {
				list1 = cl.createListRecur(Integer.parseInt(s), list1);
			}
			MergeTwooList me = new MergeTwooList();
			Node li = me.getMergeList(list, list1);
			cl.print(li);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private Node getMergeList(Node a, Node b) {
		try {

			Node f = null;
			boolean flag = false;
			if (a.getData() <= b.getData()) {
				f = new Node(a.getData());
				a = a.getNextNode();
				flag = !flag;
			}
			if (a.getData() >= b.getData()) {
				f = new Node(b.getData());
				b = b.getNextNode();
				flag = !flag;
			}
			Node f1 = f;
			while (a != null && b != null) {
				if (a.getData() <= b.getData()) {
					f1.setNextNode(a);
					a = a.getNextNode();
					f1 = f1.getNextNode();
				} else if (a.getData() >= b.getData()) {
					f1.setNextNode(b);
					b = b.getNextNode();
					f1 = f1.getNextNode();
				}
			}
			if (a != null) {
				f1.setNextNode(a);
			} else if (b != null) {
				f1.setNextNode(b);
			}
			return f;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node mergerSortedListUsingRecursion(Node a, Node b) {
		try {
			Node result = null;
			if (a == null) {
				return b;
			}
			if (b == null) {
				return a;
			}
			if (a.getData() < b.getData()) {
				result.setNextNode(mergerSortedListUsingRecursion(a, b
						.getNextNode()));
			} else if (a.getData() > b.getData()) {
				result.setNextNode(mergerSortedListUsingRecursion(a
						.getNextNode(), b));
			}
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
