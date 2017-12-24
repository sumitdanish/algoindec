package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class DeleteOperation {

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
			DeleteOperation dl = new DeleteOperation();
			int[] ar = { 5, 17 };
			cl.print(list);

			/* Simple Deletion */
			// Node li=dl.delete(ar, list);
			// System.out.println();
			// cl.print(li);
			// sc.close();
			// Node li = dl.deleteMaxNode(list);
			// System.out.println();
			// Node li = dl.deleteAlternateNode(list);
			System.out.println();
			Node li = dl.deleteMthNodeAfterNthNode(list, 2, 3);
			cl.print(li);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private Node delete(int[] data, Node list) {
		try {
			Node n = list;
			Node temp = null;
			for (int i = 0; i < data.length; i++) {
				if (n.getData() == data[i]) {
					list = list.getNextNode();
					n = null;
				} else {
					temp = n;
					while (n.getNextNode() != null) {
						if (n.getNextNode().getData() == data[i]) {
							n.setNextNode(n.getNextNode().getNextNode());
							temp = n;
							n = null;
							break;
						}
						n = n.getNextNode();
					}
					System.out.println();

				}
				n = temp;
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node deleteMaxNode(Node list) {
		try {
			Node temp = list;
			Node temp1 = temp;
			while (temp != null && temp.getNextNode() != null) {
				if (temp.getData() < temp.getNextNode().getData()) {
					Node t = temp.getNextNode();
					temp.setNextNode(t.getNextNode());
					temp = t;
					t = null;
				} else {
					temp = temp.getNextNode();
				}
			}
			return temp1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node getNode(int index, Node list) {
		try {
			Node n = list;
			for (int i = 1; i <= index && n.getNextNode() != null; i++) {
				n = n.getNextNode();
			}
			return n;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private int getSize(Node list) {
		try {
			Node n = list;
			int size = 0;
			while (n != null) {
				n = n.getNextNode();
				size++;
			}
			return size;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private Node deleteAlternateNode(Node list) {
		try {
			Node n = list;
			while (n != null && n.getNextNode() != null
					&& n.getNextNode().getNextNode() != null) {
				Node temp = n.getNextNode().getNextNode().getNextNode();
				n.setNextNode(temp);
				n = temp;
				temp = null;
				n = n.getNextNode();
			}
			System.out.println();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node deleteMthNodeAfterNthNode(Node list, int mth, int nth) {
		try {
			Node n = list;
			// Node t=n;
			for (int i = 0; i < nth && n.getNextNode() != null; i++) {
				n = n.getNextNode();
			}
			for (int j = 0; j < mth && n.getNextNode() != null; j++) {
				n = n.getNextNode();
			}
			Node temp = null;
			if (n.getNextNode() != null) {
				temp = n.getNextNode();
				n.setNextNode(temp.getNextNode());
				n = temp;
				temp = null;
			} else {
				System.out.println("Some value is wrong");
				return null;
			}
			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
