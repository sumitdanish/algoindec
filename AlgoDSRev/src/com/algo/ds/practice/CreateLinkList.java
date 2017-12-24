package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class CreateLinkList {

	/**
	 * @param args
	 */
	static Node list;

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
			// sc = new Scanner(new File("head.txt"));
			// String[] a1 = sc.next().split(",");
			// for(String s : a1)
			// {
			// cl.insertIntoHead(Integer.parseInt(s));
			// }
			// cl.insertIntoMid(24,23) ;
			cl.print(list);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void createList(int data) {
		try {
			Node n = new Node(data);
			if (list == null) {
				list = n;
			} else {
				Node l = list;
				while (l.getNextNode() != null) {
					l = l.getNextNode();
				}
				l.setNextNode(n);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Node createListRecur(int data, Node node) {
		try {
			Node n = new Node(data);
			if (node == null) {
				node = n;
				return node;
			}
			node.setNextNode(createListRecur(data, node.getNextNode()));
			return node;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void insertIntoHead(int data) {
		try {
			Node n = new Node(data);
			n.setNextNode(list);
			list = n;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void insertIntoMid(int data, int key) {
		try {
			Node n = new Node(data);
			Node list1 = list;
			while (list1.getNextNode() != null) {
				if (list1.getData() == key) {
					n.setNextNode(list1.getNextNode());
					list1.setNextNode(n);
				}
				list1 = list1.getNextNode();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void print(Node list) {
		try {
			Node n = list;
			while (n != null) {
				System.out.print(n.getData() + "-->");
				n = n.getNextNode();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
