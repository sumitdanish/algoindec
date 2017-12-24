package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class SwapingKthNodeFromEndAndBeg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(new File("link.txt"));
			String[] a = sc.next().split("->");
			Node list = null;
			CreateLinkList cl = new CreateLinkList();
			for (String s : a) {
				list = cl.createListRecur(Integer.parseInt(s), list);
			}
			SwapingKthNodeFromEndAndBeg sw = new SwapingKthNodeFromEndAndBeg();
			cl.print(list);
			System.out
					.println("\n___________________________________________________________\n");
			Node li = sw.swapKNodeFromBothEnd(list, 3);

			cl.print(li);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * 
	 * What we are doing here 1. we are travelling from 1st node to the kth
	 * node; and then we are going kth node from last node 2. Then we are saving
	 * previous link of the node which is in kth node and same is from last node
	 * i.e (see list_1 and list_2) 3. then we implementing logic of swapping the
	 * address of node; we can also by swapping the data (Not good idea)
	 */

	private Node swapNode(Node list, int kth, int size) {
		try {
			Node list1 = list;
			Node list2 = list;
			Node list_1 = null;
			Node list_2 = null;
			int i = 0;
			while (i < kth - 1 && list1 != null) {
				list_1 = list1;
				list1 = list1.getNextNode();
				i++;
			}
			i = 0;
			while (i < size - kth && list2 != null) {
				list_2 = list2;
				list2 = list2.getNextNode();
				i++;
			}
			list_1.setNextNode(list2);
			list_2.setNextNode(list1);
			Node temp = list1.getNextNode();
			list1.setNextNode(list2.getNextNode());
			list2.setNextNode(temp);
			list1 = temp;
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node swapKNodeFromBothEnd(Node list, int k) {
		try {
			Node n1 = list;
			Node n2 = getIndexNode(list, k);
			Node x2 = n2;
			Node n11 = n1;
			while (k > 0 && n1 != null) {
				n1 = n1.getNextNode();
				k--;
			}
			Node x = n1;
			while (x2.getNextNode() != null) {
				x2 = x2.getNextNode();
			}
			x2.setNextNode(x);
			x2 = x;
			while (x2.getNextNode() != x) {
				System.out.println(x2.getData());
				x2 = x2.getNextNode();
			}
			// x2.setNextNode(n11);
			// x2=n11;
			// return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node getIndexNode(Node list, int kth) {
		try {
			Node n1 = list;
			Node n2 = list;
			while (kth > 0 && n2 != null) {
				n2 = n2.getNextNode();
				kth--;
			}
			while (n1 != null && n2 != null) {
				n1 = n1.getNextNode();
				n2 = n2.getNextNode();
			}
			return n1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
