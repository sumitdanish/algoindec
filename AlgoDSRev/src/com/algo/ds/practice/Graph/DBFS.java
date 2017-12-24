package com.algo.ds.practice.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DBFS {

	/**
	 * @param args
	 */
	static int[][] addVertex;
	static GraphDetails[] graph;

	public static void main(String[] args) {

		try {
			int[] t1 = new int[8];
			int[] t2 = new int[8];
			int vertex = 8;
			DBFS d = new DBFS();
			d.addVertex(0, 1);

			d.addVertex(1, 3);
			d.addVertex(1, 6);

			d.addVertex(2, 1);
			d.addVertex(2, 4);
			d.addVertex(2, 3);

			d.addVertex(3, 2);

			d.addVertex(4, 2);
			d.addVertex(4, 6);
			d.addVertex(4, 5);
			d.addVertex(4, 7);

			d.addVertex(5, 4);

			d.addVertex(6, 1);
			d.addVertex(6, 4);

			d.addVertex(7, 4);

			d.BFS(vertex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public DBFS() {
		char[] ch = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
		addVertex = new int[8][8];
		graph = new GraphDetails[8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				addVertex[i][j] = 0;
			}
			graph[i] = new GraphDetails(ch[i]);
		}
	}

	private void addVertex(int sou, int des) {
		try {
			addVertex[sou][des] = 1;
			addVertex[des][sou] = 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void displayVertex(int v, int x) {
		try {
			System.out.println(graph[v].label + "," + x);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int getUnvisited(int so, int vertex) {
		try {
			for (int i = 0; i < vertex; i++) {
				if (addVertex[so][i] == 0 && graph[i].isVisited == false) {
					return i;
				}

			}
			return -1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void dfsRecurs(int v, GraphListNode[] graph) {
		try {
			graph[v].setVisited(true);
			System.out.print(v + ",");
			GraphListNode gl = graph[v];
			while (gl != null) {
				if (!gl.isVisited()) {
					dfsRecurs(gl.getData(), graph);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void DFS1(int vertex) {
		Stack<Integer> stack = new Stack<Integer>();
		graph[0].isVisited = true;
		stack.push(0);
		while (!stack.isEmpty()) {
			int x = stack.peek();
			int v = getUnvisited(x, vertex);
			if (v == -1) {
				// System.out.println("\n\n");
				stack.pop();
			} else {

				graph[v].isVisited = true;
				stack.push(v);
				displayVertex(v, x);
			}
		}
		for (int i = 0; i < vertex; i++) {
			// System.out.print("{"+t1[i]+","+t2[i]+"}<>");
		}

	}

	private void BFS(int vertex) {
		try {
			Queue<Integer> queue = new LinkedList<Integer>();
			graph[0].isVisited = true;
			queue.add(0);
			int v;
			while (!queue.isEmpty()) {
				int x = queue.peek();
				queue.poll();
				// v=getUnvisited(x, vertex);
				while ((v = getUnvisited(x, vertex)) != -1) {
					graph[v].isVisited = true;
					queue.add(v);
					displayVertex(v, x);
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class GraphDetails {

	public char label;
	public boolean isVisited;

	public GraphDetails(char label) {
		this.label = label;
		this.isVisited = false;
	}
}
