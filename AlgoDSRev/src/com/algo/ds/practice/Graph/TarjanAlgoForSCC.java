package com.algo.ds.practice.Graph;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class TarjanAlgoForSCC {

	/**
	 * @param args
	 */
	static int time = 0;

	public static void main(String[] args) {
		try {
			TarjanAlgoForSCC tar = new TarjanAlgoForSCC();
			Scanner sc = new Scanner(new File("tarjan.txt"));
			int vertex = sc.nextInt();
			GraphNodePathListTarjan gl = new GraphNodePathListTarjan(vertex);
			int[] desc = new int[vertex];
			int[] low = new int[vertex];
			boolean[] visited = new boolean[vertex];
			for (int i = 0; i < vertex; i++) {
				desc[i] = -1;
				low[i] = -1;
				visited[i] = false;
			}
			GraphNodePathTarjan[] graph = gl.getGraphNodeList();
			Stack<Integer> st = new Stack<Integer>();
			for (int i = 0; i < vertex; i++) {
				if (desc[i] == -1) {
					// GraphNodePathTarjan gr = graph[i];
					tar.tarjanSCC(graph, low, desc, i, visited, st);
				}
			}
			for (int i = 0; i < vertex; i++) {
				System.out.println(low[i] + "," + desc[i]);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void tarjanSCC(GraphNodePathTarjan[] graph, int[] low, int[] desc,
			int s, boolean[] visited, Stack<Integer> st) {
		try {
			time++;
			low[s] = time;
			desc[s] = time;
			visited[s] = true;
			st.push(s);
			GraphNodePathTarjan g = graph[s];
			while (g.getNext() != null) {
				if (desc[g.getData()] == -1) {
					tarjanSCC(graph, low, desc, g.getData(), visited, st);
					low[s] = getMin(low[s], low[g.getData()]);
				} else if (visited[s] == true) {
					low[s] = getMin(low[g.getData()], low[s]);
				}
				g = g.getNext();
			}
			int w = 0;
			if (low[s] == desc[s]) {
				while (st.peek() != s) {
					w = st.peek();
					System.out.print(w + ",");
					st.pop();
				}
				w = st.pop();
				System.out.print(w + "\n");
				visited[w] = false;
				// st.pop();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int getMin(int a, int b) {
		try {
			return a >= b ? b : a;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}

class GraphNodePathListTarjan {
	GraphNodePathTarjan[] graphNodeList;
	boolean[] visited;

	public GraphNodePathListTarjan(int vertex) {
		graphNodeList = new GraphNodePathTarjan[vertex];
		visited = new boolean[vertex];
		for (int i = 0; i < vertex; i++) {
			graphNodeList[i] = new GraphNodePathTarjan();
			visited[i] = false;
		}
	}

	// /sortesPath.txt

	public GraphNodePathTarjan[] getGraphNodeList() {
		try {
			return graphNodeList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void addEadge(int s, int d) {
		try {
			graphNodeList[s] = graphNodeList[s].createGraphList(
					graphNodeList[s], d);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class GraphNodePathTarjan {
	int data;

	GraphNodePathTarjan next;

	public GraphNodePathTarjan() {

	}

	public GraphNodePathTarjan(int data) {
		this.data = data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(GraphNodePathTarjan next) {
		this.next = next;
	}

	public GraphNodePathTarjan getNext() {
		return next;
	}

	public int getData() {
		return data;
	}

	public GraphNodePathTarjan createGraphList(GraphNodePathTarjan graph,
			int data) {
		try {
			if (!isDataPresent(graph, data)) {
				GraphNodePathTarjan g = new GraphNodePathTarjan(data);
				g.setNext(graph);
				graph = g;
			}
			return graph;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean isDataPresent(GraphNodePathTarjan graph, int data) {
		try {

			GraphNodePathTarjan g = graph;
			while (g != null) {
				if (g.getData() == data) {
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