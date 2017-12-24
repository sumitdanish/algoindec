package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class CreateCircularLinkListInSpecificNode {

	/**
	 * @param args
	 */

	static Node slow;
	static Node fast;

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
			CreateCircularLinkListInSpecificNode cs = new CreateCircularLinkListInSpecificNode();
			Node cn = cs.getCircularNode(list, 3);
			if (!cs.isLoopExist(cn)) {
				Node li = cs.removeLoop(slow, fast);
				cl.print(li);
			} else {
				System.out.println("No Loop");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private Node getCircularNode(Node list, int num) {
		try {
			Node n = list;
			Node n1 = n;
			while (n != null && num > 0) {
				n = n.getNextNode();
				num--;
			}
			Node n2 = n.getNextNode();
			Node n3 = n2;
			while (n3.getNextNode() != null) {
				n3 = n3.getNextNode();
			}
			n3.setNextNode(n2);
			n2 = n1;
			return n2;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private boolean isLoopExist(Node list) {
		try {
			Node n = list;
			slow = n;
			fast = n.getNextNode();
			boolean flag = true;
			while (flag) {
				slow = slow.getNextNode();
				fast = fast.getNextNode();
				if (fast.getNextNode() != null) {
					fast = fast.getNextNode();
				}
				if (fast == slow) {
					flag = !flag;
				}
			}
			System.out.println(fast.getData());
			return flag;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private Node removeLoop(Node slow1, Node fast1) {
		try {
			Node n = slow1;
			Node f = fast1;
			Node n1 = n;
			while (n != f) {
				n = n.getNextNode();
				f = f.getNextNode();
			}
			Node n2 = f;
			while (n2.getNextNode() != n) {
				n2 = n2.getNextNode();
			}
			n2.setNextNode(null);
			return n1;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
