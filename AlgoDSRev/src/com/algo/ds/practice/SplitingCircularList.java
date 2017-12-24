package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class SplitingCircularList {

	/**
	 * @param args
	 */

	static Node circularList;
	static Node head;
	static Node head2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Scanner sc = new Scanner(new File("link.txt"));
			String[] a = sc.next().split(",");
			Node list = null;
			SplitingCircularList cl = new SplitingCircularList();
			for (String s : a) {
				cl.createCircularList(Integer.parseInt(s));
			}
			cl.split(circularList);
			cl.print(head);
			System.out.println("\n_____________________________\n");
			cl.print(head2);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void split(Node n) {
		try {
			head = n;
			Node slow = n;
			Node fast = n;
			Node f = fast;
			while (fast.getNextNode() != head
					&& fast.getNextNode().getNextNode() != head) {
				fast = fast.getNextNode().getNextNode();
				slow = slow.getNextNode();
			}
			if (fast.getNextNode().getNextNode() == head) {
				fast = fast.getNextNode();
			}
			head2 = slow.getNextNode();
			fast.setNextNode(slow.getNextNode());
			slow.setNextNode(head);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void createCircularList(int data) {
		try {
			Node n = new Node(data);
			if (circularList == null) {
				circularList = n;
				circularList.setNextNode(n);
			}
			Node n1 = circularList;
			while (n1.getNextNode() != circularList) {
				n1 = n1.getNextNode();
			}
			n.setNextNode(circularList);
			n1.setNextNode(n);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void print(Node n) {
		try {
			Node n1 = n;
			while (true) {
				System.out.print(n1.getData() + ",");
				n1 = n1.getNextNode();
				if (n1 == n) {
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
