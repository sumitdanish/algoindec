package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class PalindromOfLinkList {

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
			PalindromOfLinkList pl = new PalindromOfLinkList();
			if (pl.isPlaindrome(list)) {
				System.out.println("YUPs");
			} else {
				System.out.println("Sorry its Nod");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private boolean isPlaindrome(Node list) {
		try {
			Node slow = list;
			Node fast = list;
			Node s = slow;
			Node midNode = null;
			while (fast.getNextNode() != null
					&& fast.getNextNode().getNextNode() != null) {
				slow = slow.getNextNode();
				fast = fast.getNextNode().getNextNode();
			}
			if (fast.getNextNode().getNextNode() == null) {
				midNode = slow.getNextNode();
			}
			slow.setNextNode(null);
			Node rev = reverse(s);
			while (rev != null) {
				System.out.println(rev.getData());
				rev = rev.getNextNode();
			}
			while (midNode != null && rev != null) {
				System.out.println(midNode.getData() + "> " + rev.getData());
				if (midNode.getData() != rev.getData()) {
					return false;
				}
				midNode = midNode.getNextNode();
				rev = rev.getNextNode();
			}
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private Node reverse(Node list) {
		try {
			Node n = list;
			Node t = null;
			Node temp = null;
			while (temp != null) {
				temp = n.getNextNode();
				n.setNextNode(t);
				t = n;
				n = temp;
				temp = temp.getNextNode();
			}
			return t;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
