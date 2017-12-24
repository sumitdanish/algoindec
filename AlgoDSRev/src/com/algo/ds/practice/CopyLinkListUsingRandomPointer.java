package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class CopyLinkListUsingRandomPointer {

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
				// cl.createList(Integer.parseInt(s));
				list = cl.createListRecur(Integer.parseInt(s), list);
			}
			CopyLinkListUsingRandomPointer co = new CopyLinkListUsingRandomPointer();
			cl.print(list);
			System.out
					.println("\n___________________________________________\n");
			Node li = co.getCopyOfList(list);
			cl.print(li);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private Node getCopyOfList(Node list) {
		try {
			Node n = list;
			/* Original node : o, Copy Node : c */
			/*
			 * By using this loop we are inserting first node between two node
			 * in the linkList
			 */
			/* The resultant list will be o->c->o->c->o->c.... */
			while (n != null) {
				Node copy = new Node(n.getData());
				copy.setNextNode(n.getNextNode());
				n.setNextNode(copy);
				n = copy.getNextNode();
			}
			n = list;

			/*
			 * By Using this loop we are copy the random pinter from given
			 * pointer
			 */
			while (n != null) {
				if (n.getNextNode() != null) {
					// System.out.println(n.getRandomNode().getData());
					n.getNextNode().setRandomNode(
							n.getRandomNode().getNextNode());
				}
				n = n.getNextNode().getNextNode();
			}
			/* o->c->o->c->o->c */
			/*
			 * By using this loop we are separating the link list o->o->o->o...
			 * c->c->c->c...
			 */
			n = list;
			Node temp = list.getNextNode();
			while (n != null) {
				Node t = n.getNextNode();
				n.setNextNode(t.getNextNode());
				if (t.getNextNode() != null) {
					t = t.getNextNode().getNextNode();
				}
				n = n.getNextNode();
			}
			return temp;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
