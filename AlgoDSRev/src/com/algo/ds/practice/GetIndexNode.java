package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class GetIndexNode {

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
				// cl.createList(Integer.parseInt(s));
				list = cl.createListRecur(Integer.parseInt(s), list);
			}
			GetIndexNode gi = new GetIndexNode();
			Node n = gi.getIndexNode(list, 3);
			System.out.println(n.getData());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private Node getIndexNode(Node list, int index) {
		try {
			Node n = list;
			Node n1 = list;
			while (index > 0 && n1 != null) {
				n1 = n1.getNextNode();
				index--;
			}
			while (n != null && n1 != null) {
				n = n.getNextNode();
				n1 = n1.getNextNode();
			}
			return n;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
