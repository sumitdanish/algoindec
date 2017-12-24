package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class SumOfTwoList {

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
			sc = new Scanner(new File("link1.txt"));
			String[] a1 = sc.next().split(",");
			Node list1 = null;
			CreateLinkList cl1 = new CreateLinkList();
			for (String s : a1) {
				list1 = cl1.createListRecur(Integer.parseInt(s), list1);
			}
			SumOfTwoList sum = new SumOfTwoList();
			cl.print(list);
			System.out.println("\n___________________________________\n");
			cl1.print(list1);
			System.out.println("\n____________________________________\n");
			Node li = sum.sumOfList(list, list1);
			// Node li = sum.addNodeValueOfSameSizeList(list, list1,0);
			cl.print(li);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/*
	 * This is the sum of list when first node is least significant digit and
	 * right most digit is most significant digit
	 */

	private Node sumOfList(Node list1, Node list2) {
		try {
			CreateLinkList cl = new CreateLinkList();
			int carry1 = 0;
			if (list1 == null) {
				return list2;
			}
			if (list2 == null) {
				return list1;
			}
			Node n1 = list1;
			Node n2 = list2;
			Node newList = null;
			int carry = 0;
			int sum = 0;
			while (n1 != null || n2 != null) {
				if (n1 == null) {
					sum = n2.getData();
					n2 = n2.getNextNode();
				} else if (n2 == null) {
					sum = n1.getData();
					n1 = n1.getNextNode();
				} else {
					sum = n1.getData() + n2.getData();
					n1 = n1.getNextNode();
					n2 = n2.getNextNode();
				}
				sum += carry;
				carry = sum / 10;
				carry1 = sum % 10;
				newList = cl.createListRecur(carry1, newList);
			}
			if (carry >= 1) {
				newList = cl.createListRecur(carry, newList);
			}
			return newList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/*
	 * This is the sum of the two list when first node is most significant digit
	 * and last node is become least significant ALgo 1. We will call
	 * recursively and we will store sum until we will reach to the end of the
	 * both list 2. After reaching the end of the list we will flow the carry to
	 * the left of the newly created list;
	 */

	private Node insertIntoHead(Node n, int data) {
		try {
			Node newNode = new Node(data);
			newNode.setNextNode(n);
			n = newNode;
			return n;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node addNodeValueOfSameSizeList(Node list, Node list1, int carry) {
		try {
			Node newList = null;
			if (list1 == null) {
				return null;
			}
			if (newList == null) {
				carry = (list1.getData() + list.getData()) / 10;
				newList = new Node(list1.getData() + list.getData());
				return newList;
			} else {
				int sum = 0;
				newList.setNextNode(addNodeValueOfSameSizeList(list
						.getNextNode(), list1.getNextNode(), carry));
				sum = list.getData() + list1.getData() + carry;
				carry = sum / 10;
				sum = sum % 10;
				newList.setData(sum);
				return newList;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
