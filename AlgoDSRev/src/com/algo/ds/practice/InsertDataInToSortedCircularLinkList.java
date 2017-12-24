package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class InsertDataInToSortedCircularLinkList {

	/**
	 * @param args
	 */

	static Node cirList;

	public static void main(String[] args) {

		try {
			InsertDataInToSortedCircularLinkList l = new InsertDataInToSortedCircularLinkList();
			Scanner sc = new Scanner(new File("link.txt"));
			String[] a = sc.next().split(",");
			for (String s : a) {
				l.createCicularList(Integer.parseInt(s));
			}
			sc.close();
			l.print(cirList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void createCicularList(int data) {
		try {
			Node n = new Node(data);
			if (cirList == null) {
				cirList = n;
				cirList.setNextNode(n);
			} else {
				Node t = cirList;
				while (t.getNextNode() != cirList) {
					t = t.getNextNode();
				}
				t.setNextNode(n);
				n.setNextNode(cirList);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void print(Node cl) {
		Node n = cl;
		while (n != null) {
			System.out.print(n.getData() + ",");
			n = n.getNextNode();
			if (n == cl) {
				break;
			}
		}
	}

}
