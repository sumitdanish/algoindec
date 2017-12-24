package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class ReveresInBetweenSpecificNode {

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
			cl.print(list);
			System.out.println("\n_____________________\n");
			ReveresInBetweenSpecificNode re = new ReveresInBetweenSpecificNode();
			Node li = re.reverser(list);
			cl.print(li);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/*
	 * 1->2->3->4->7->8->9->10->12->34->54->2->67->86->12 o/p
	 * 4->3->2->1->7->8->9->10->12->34->54->2->67->86->12 o/p
	 * 1->2->3->4->7->8->9->10->12->34->54->12->86->67->2
	 */
	private Node reverser(Node list) {
		try {
			Node li = list;
			Node t = null;
			Node temp = list.getNextNode();
			int i = 4;
			while (temp != null && i > 0) {
				li.setNextNode(t);
				t = li;
				li = temp;
				temp = temp.getNextNode();
				i--;
			}

			Node t1 = t;
			Node t2 = t1;
			while (t2.getNextNode() != null) {
				t2 = t2.getNextNode();
			}
			t2.setNextNode(temp);
			t2 = t;
			temp = t2;

			while (temp.getData() != 54) {
				temp = temp.getNextNode();
			}
			Node t11 = temp.getNextNode();
			temp.setNextNode(null);
			Node t111 = t11;
			Node t_11 = null;
			Node t_1 = t11.getNextNode();
			while (t_1 != null) {
				t111.setNextNode(t_11);
				t_11 = t111;
				t111 = t_1;
				t_1 = t_1.getNextNode();
			}
			temp.setNextNode(t_11);
			temp = t_11;
			temp = t2;
			return temp;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
