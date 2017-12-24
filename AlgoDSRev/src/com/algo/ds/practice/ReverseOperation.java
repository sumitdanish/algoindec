package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class ReverseOperation {

	/**
	 * @param args
	 */
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
			sc.close();
			sc = new Scanner(new File("link1.txt"));
			String[] a1 = sc.next().split(",");
			Node list1 = null;
			CreateLinkList cl1 = new CreateLinkList();
			for (String s : a1) {
				list1 = cl1.createListRecur(Integer.parseInt(s), list1);
			}
			ReverseOperation re = new ReverseOperation();
			cl.print(list);
			System.out.println();
			cl.print(list1);
			System.out
					.println("\n__________________________________________________________________________________________________\n");
			// Node li = re.swapNode(list);
			// Node li = re.swapAlterNateNode(list);
			// Node li = re.swapNodeUsingRecur(list);
			Node li = re.mergerLinkList(list, list1);
			cl.print(li);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Node reverse(Node list) {
		try {
			Node n = list;
			Node k = null;
			Node temp = n.getNextNode();
			int i = 0;
			while (true) {
				if (temp == null) {
					break;
				}
				n.setNextNode(k);
				k = n;
				n = temp;
				temp = temp.getNextNode();

			}
			return k;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	// 2-->5-->1-->11-->23-->10-->34-->21-->17-->18-->7-->8-->4-->9
	// 1->2->3->4->5->6
	// 2->1->4->3->6->5

	private Node swapAlterNateNode(Node list) {
		try {
			Node n = list;
			while (n != null && n.getNextNode() != null) {
				int temp = n.getData();
				n.setData(n.getNextNode().getData());
				n.getNextNode().setData(temp);
				n = n.getNextNode().getNextNode();
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node swapNode(Node list) {
		try {
			Node n = list;
			Node cur = list.getNextNode();
			Node c = cur;
			while (true) {
				Node temp = cur.getNextNode();
				cur.setNextNode(n);

				if (temp == null || temp.getNextNode() == null) {
					n.setNextNode(temp);
					break;
				}
				n.setNextNode(temp.getNextNode());
				n = temp;
				cur = n.getNextNode();
			}
			return c;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node swapNodeUsingRecur(Node n) {
		try {
			if (n == null || n.getNextNode() == null) {
				return n;
			}
			Node re = n.getNextNode().getNextNode();
			// The work of this line is appending the node when swapping from
			// one node to other node
			Node h = n.getNextNode();
			n.getNextNode().setNextNode(n);
			n.setNextNode(swapNodeUsingRecur(re));
			return h;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private Node mergerLinkList(Node list, Node list1) {
		try {
			Node t1 = list;
			Node t1_1 = null;
			Node t2 = list1;
			Node t2_2 = null;
			while (t1 != null && t2 != null) {
				t1_1 = t1.getNextNode();
				t2_2 = t2.getNextNode();
				t1.setNextNode(t2);
				t2.setNextNode(t1_1);
				t1 = t1_1;
				t2 = t2_2;
			}
			if (t2_2 != null) {
				Node temp = list;
				Node te = temp;
				while (te.getNextNode() != null) {
					te = te.getNextNode();
				}
				te.setNextNode(t2_2);
				t2 = temp;
				// list=t2_2;
			}
			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
