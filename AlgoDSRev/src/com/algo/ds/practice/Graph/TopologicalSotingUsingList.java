package com.algo.ds.practice.Graph;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSotingUsingList {

	/**
	 * @param args
	 */

	static boolean[] visi;

	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(new File("Topo.txt"));
			int vertex = Integer.parseInt(sc.next());
			TopoNodeDetails to = new TopoNodeDetails(vertex);
			TopologicalSotingUsingList t = new TopologicalSotingUsingList();
			visi = new boolean[vertex];
			while (sc.hasNext()) {
				String[] s = sc.next().split("-->");
				int source = Integer.parseInt(s[0]);
				int dest = Integer.parseInt(s[1]);
				to.addEadge(source, dest);
			}
			TopoNodeList[] top = to.getTopoList();
			Stack<Integer> st = new Stack<Integer>();
			for (int i = 0; i < vertex; i++) {
				if (visi[i] == false) {
					t.topoSort(i, st, top);
				}
			}
			while (!st.isEmpty()) {
				System.out.print(st.pop() + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void topoSort(int v, Stack<Integer> st, TopoNodeList[] top) {
		try {
			TopoNodeList t = top[v];
			visi[t.getLable()] = true;
			while (t.getNext() != null) {
				if (!t.isVisited()) {
					topoSort(t.getLable(), st, top);
				}
				t = t.getNext();
			}
			st.push(v);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class TopoNodeDetails {
	private TopoNodeList[] topoList;
	private boolean[] visited;

	public TopoNodeDetails(int vertex) {
		try {
			visited = new boolean[vertex];
			topoList = new TopoNodeList[vertex];
			for (int i = 0; i < vertex; i++) {
				topoList[i] = new TopoNodeList();
				visited[i] = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public TopoNodeList[] getTopoList() {
		return topoList;
	}

	public void setTopoList(TopoNodeList[] topoList) {
		this.topoList = topoList;
	}

	public void addEadge(int source, int dest) {
		try {
			topoList[source] = topoList[source].createList(topoList[source],
					dest);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class TopoNodeList {
	private int label; // This is nothing but vertex index , for our covinence
						// we are giving label;
	private boolean visited;
	private TopoNodeList next;

	public TopoNodeList() {

	}

	public TopoNodeList(int label) {
		this.label = label;
	}

	public void setLabel(int label) {
		this.label = label;
	}

	public void setNext(TopoNodeList next) {
		this.next = next;
	}

	public TopoNodeList getNext() {
		return next;
	}

	public int getLable() {
		return label;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public boolean isVisited() {
		return visited;
	}

	public TopoNodeList createList(TopoNodeList list, int dest) {
		try {
			if (!isVertex(list, dest)) {
				TopoNodeList top = new TopoNodeList(dest);
				top.setNext(list);
				list = top;
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private boolean isVertex(TopoNodeList gl, int dest) {
		try {
			TopoNodeList g = gl;
			while (g != null) {
				if (g.getLable() == dest) {
					return true;
				}
				g = g.getNext();
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}