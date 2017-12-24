package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class FlattenAMultilevelLinkedList {

	/**
	 * @param args
	 */

	static Node child1;
	static Node child2;
	static Node child3;
	static Node child4;
	static Node child5;
	static Node child6;
	static Node child7;

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
			sc.close();
			String[] childFileName = { "child1.txt", "child2.txt",
					"child3.txt", "child4.txt", "child5.txt", "child6.txt",
					"child7.txt" };
			Node[] childNode = { child1, child2, child3, child4, child5,
					child6, child7 };
			for (int i = 0; i < childFileName.length; i++) {
				sc = new Scanner(new File(childFileName[i]));
				String[] a1 = sc.next().split(",");
				Node child = childNode[i];
				for (String s : a1) {
					// cl.createList(Integer.parseInt(s));
					child = cl.createListRecur(Integer.parseInt(s), child);
				}
				childNode[i] = child;
				sc.close();
			}
			Node n = childNode[4];
			if (n == null) {
				System.out.println("kjhgk");
			}
			cl.print(list);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void createFlatternList(Node list, Node[] childList) {
		try {

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
