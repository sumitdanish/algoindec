package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class IntersectionOfTwoList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

			IntersectionOfTwoList it = new IntersectionOfTwoList();
			Node li = it.createYShapedLinkeList(list, list1);
			cl.print(list);
			System.out.print("////");
			cl.print(list1);
			System.out.println();
			System.out.println("\n____________\n");
			int interSetionPoint = it.getInterSetionPoint(list, list1);
			System.out.println(interSetionPoint);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int getInterSetionPoint(Node list1, Node list2) {
		try {
			int len1 = getLen(list1);
			int len2 = getLen(list2);
			int dif = 0;
			if (len1 > len2) {
				dif = len1 - len2;
				return getInterSecti(list1, list2, dif);
			} else {
				dif = len2 - len1;
				return getInterSecti(list2, list1, dif);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getInterSecti(Node list1, Node list2, int dif) {
		try {
			Node n1 = list1;
			Node n2 = list2;
			for (int i = 0; i < dif && n1 != null; i++) {
				n1 = n1.getNextNode();
			}
			while (n1 != null && n2 != null) {
				if (n1.getData() == n2.getData()) {
					return n1.getData();
				}
				n1 = n1.getNextNode();
				n2 = n2.getNextNode();
			}
			return -1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private Node createYShapedLinkeList(Node list1, Node list2) {
		try {
			int i = 5;
			Node n1 = list1;
			Node n2 = list2;
			while (n1 != null && i > 1) {
				n1 = n1.getNextNode();
				i--;
			}
			while (n2.getNextNode() != null) {
				n2 = n2.getNextNode();
			}
			n2.setNextNode(n1);
			return list2;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private int getLen(Node n) {
		try {
			int i = 0;
			if (n == null) {
				i = -1;
			} else {
				Node h = n;
				while (h != null) {
					h = h.getNextNode();
					i++;
				}

			}
			return i;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
