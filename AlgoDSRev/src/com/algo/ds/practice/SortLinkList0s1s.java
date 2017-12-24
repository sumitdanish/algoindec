package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class SortLinkList0s1s {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("0s1s.txt"));
			String[] a = sc.next().split(",");
			Node list = null;
			CreateLinkList cl = new CreateLinkList();
			for (String s : a) {
				list = cl.createListRecur(Integer.parseInt(s), list);
			}
			SortLinkList0s1s sort = new SortLinkList0s1s();
			cl.print(list);
			System.out
					.println("\n_________________________________________________________________________\n");
			Node li = sort.getSortList(list);
			cl.print(li);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private Node getSortList(Node list) {
		try {
			Node n = list;
			Node p = list;
			int i = 0;
			int[] count = { 0, 0, 0 };
			while (n != null) {
				count[n.getData()]++;
				n = n.getNextNode();
			}
			n = list;
			while (p != null) {
				if (count[i] == 0) {
					i++;
				} else {
					p.setData(i);
					count[i]--;
					p = p.getNextNode();
				}
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
