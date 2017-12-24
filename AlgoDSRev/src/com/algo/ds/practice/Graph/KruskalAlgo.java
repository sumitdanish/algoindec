package com.algo.ds.practice.Graph;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class KruskalAlgo {

	/**
	 * @param args
	 */
	static char[] parent;
	static int[] ranke;

	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(new File("kruskal.txt"));
			String[] s = sc.next().split(",");
			KruskalAlgo ks = new KruskalAlgo();
			ks.MARKSET(s);
			ArrayList<Eadge> al = ks.createEadge(sc);
			ArrayList<Eadge> keadgeList = ks.kruskalAlgo(al);
			for (Eadge e : keadgeList) {
				System.out.println("(" + e.getV1() + "," + e.getV2() + ") : "
						+ e.getW());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public KruskalAlgo() {
		parent = new char[256];
		ranke = new int[256];
		;
	}

	private ArrayList<Eadge> createEadge(Scanner sc) {
		try {
			ArrayList<Eadge> eadge = new ArrayList<Eadge>();
			while (sc.hasNext()) {
				String[] s = sc.next().split("->");
				char vertex1 = s[0].charAt(0);
				char vertex2 = s[1].charAt(0);
				int w = Integer.parseInt(s[2]);
				Eadge ea = new Eadge(vertex1, vertex2, w);
				eadge.add(ea);
			}
			Collections.sort(eadge, new EadgeSort());
			return eadge;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private void MARKSET(String[] s) {
		try {
			for (int i = 0; i < s.length; i++) {
				parent[s[i].charAt(0)] = s[i].charAt(0);
				ranke[s[i].charAt(0)] = 0;
				System.out.println(i + ">" + s[i].charAt(0));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private char FIND(char ch) {
		try {
			if (parent[ch] == ch) {
				return parent[ch];
			} else {
				return FIND(parent[ch]);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ' ';
	}

	private void UNION(char v1, char v2) {
		try {
			if (ranke[v1] > ranke[v2]) {
				parent[v2] = v1;
			} else if (ranke[v2] > ranke[v1]) {
				parent[v1] = v2;
			} else {
				parent[v1] = v2;
				ranke[v2]++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private ArrayList<Eadge> kruskalAlgo(ArrayList<Eadge> eadgeList) {
		try {
			ArrayList<Eadge> keadgeList = new ArrayList<Eadge>();
			for (Eadge e : eadgeList) {
				if (FIND(e.getV1()) != e.getV2()) {
					keadgeList.add(e);
					UNION(e.getV1(), e.getV2());
				}
			}
			return keadgeList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}

class Eadge {
	private char v1;
	private char v2;
	private int w;

	public Eadge(char v1, char v2, int w) {
		this.w = w;
		this.v1 = v1;
		this.v2 = v2;
	}

	public char getV1() {
		return v1;
	}

	public void setV1(char v1) {
		this.v1 = v1;
	}

	public char getV2() {
		return v2;
	}

	public void setV2(char v2) {
		this.v2 = v2;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}
}

class EadgeSort implements Comparator<Eadge> {

	@Override
	public int compare(Eadge o1, Eadge o2) {
		return o1.getW() - o2.getW();
	}

}