package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class SortLinkList {

	/**
	 * @param args
	 */

	Node newHead;
	Node newEnd;
	Node tail;
	Node end;

	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(new File("link.txt"));
			String[] a = sc.next().split(",");
			Node list = null;
			SortLinkList cl = new SortLinkList();
			Node end = null;
			for (String s : a) {
				list = cl.createList(list, Integer.parseInt(s));
			}
			sc.close();
			// cl.print(list);
			end = cl.getTail(list);
			cl.quick(list, end);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void quick(Node head, Node end) {
		try {
			Node n = quickSort(head, end);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private Node partioned(Node head, Node end) {
		try {
			Node current = head;
			Node tail;
			Node pivot = end;
			Node pre = null;
			tail = pivot;
			while (current != pivot) {
				if (pivot.getData() < current.getData()) {
					if (newHead == null) {
						newHead = current;
					}
					pre = current;
					current = current.getNextNode();
				} else {
					if (pre != null) {
						pre.setNextNode(current.getNextNode());
					}
					Node temp = current.getNextNode();
					current.setNextNode(null);
					tail.setNextNode(current);
					tail = current;
					current = temp;
				}
			}
			if (newHead == null) {
				newHead = current;
			}
			if (newEnd == null) {
				newEnd = pivot;
			}
			return pivot;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node quickSort(Node head, Node end) {
		try {
			if (head == null || head == end) {
				return head;
			}
			Node pivot;
			pivot = partioned(head, end);
			//System.out.println(newHead.getData());
			if (newHead != pivot) {
				Node temp = newHead;
				while (temp.getNextNode() != null) {
					temp = temp.getNextNode();
				}
				temp.setNextNode(null);
				newHead = quickSort(head, temp);
				temp = getTail(newHead);
				temp.setNextNode(pivot);
			}
			pivot.setNextNode(quickSort(pivot.getNextNode(), newEnd));
			return newHead;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node getTail(Node head) {
		try {
			Node temp = head;
			while (temp != null && temp.getNextNode() != null) {
				temp = temp.getNextNode();
			}
			return temp;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node createList(Node list, int data) {
		try {
			Node n = new Node(data);
			if (list == null) {
				list = n;
			} else {
				list.setNextNode(createList(list.getNextNode(), data));
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private void print(Node n) {
		try {
			Node h = n;
			while (h != null) {
				System.out.print(h.getData() + ",");
				h = h.getNextNode();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
