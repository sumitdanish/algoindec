package com.algo.ds.practice.Graph;

import java.io.File;
import java.util.Scanner;

public class DetectCycleUsingDisjointDSIn_UNDAG {

	/**
	 * @param args
	 * cycleds.txt
	 *  5
		0--1
		0--2
		1--0
		1--2
		2--1
		2--0
		0--3
		3--0
		3--4
		4--3

	 */
	static EadgeCycle[] eadge;

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("cycleds.txt"));
			int eadgeLen = sc.nextInt();
			int[] parent = new int[eadgeLen];
			eadge = new EadgeCycle[eadgeLen];
			int i = 0;
			while (sc.hasNext() && i < eadgeLen) {
				String[] s = sc.next().split("--");
				int src = Integer.parseInt(s[0]);
				int dest = Integer.parseInt(s[1]);
				eadge[i] = new EadgeCycle(src, dest);
				i++;
			}
			DetectCycleUsingDisjointDSIn_UNDAG de = new DetectCycleUsingDisjointDSIn_UNDAG();
			parent = de.MEMSET(parent, eadgeLen);
			boolean b = de.isCycle(parent, eadge, eadgeLen);
			if (b) {
				System.out.println("jshgdkjfh");
			} else {
				System.out.println("oiweuor");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public DetectCycleUsingDisjointDSIn_UNDAG() {
		try {

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private boolean isCycle(int[] parent, EadgeCycle[] eadge, int len) {
		try {
			for (int i = 0; i < len; i++) {
				int src = FIND(parent, eadge[i].getSrc());
				int dest = FIND(parent, eadge[i].getDest());
				if (src == dest) {
					return true;
				}
				UNION(parent, src, dest);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private int[] MEMSET(int[] parent, int eadge) {
		try {
			for (int i = 0; i < eadge; i++) {
				parent[i] = i;
			}
			return parent;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private void UNION(int[] parent, int x, int y) {
		try {
			parent[x] = y;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int FIND(int[] parent, int i) {
		try {
			if (parent[i] == i) {
				return i;
			}
			return FIND(parent, parent[i]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}
}

class EadgeCycle {
	private int src;
	private int dest;

	public EadgeCycle(int src, int dest) {
		this.src = src;
		this.dest = dest;
	}

	public void setSrc(int src) {
		this.src = src;
	}

	public void setDest(int dest) {
		this.dest = dest;
	}

	public int getSrc() {
		return src;
	}

	public int getDest() {
		return dest;
	}
}