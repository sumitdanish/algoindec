package com.algo.ds.practice.Graph;

import java.io.File;
import java.util.Scanner;

public class ArticulationPoint {

	/**
	 * @param args
	 */
	static int time = 0;

	public static void main(String[] args) {
		try {

			Scanner sc = new Scanner(new File("art.txt"));
			int vertex = sc.nextInt();
			ArticulationPoint a = new ArticulationPoint();
			boolean[] ap = new boolean[vertex];
			int[] low = new int[vertex];
			int[] desc = new int[vertex];
			boolean[] visited = new boolean[vertex];
			int[] parent = new int[vertex];
			for (int i = 0; i < vertex; i++) {
				low[i] = -1;
				desc[i] = -1;
				parent[i] = -1;
			}
			GraphNodePathListArticulation gp = new GraphNodePathListArticulation(
					vertex, sc);
			GraphNodePathArticulation[] graph = gp.getGraphNodeList();
//			GraphNodePathArticulation gr = graph[0];
//			while(gr != null){
//				System.out.print(gr.getData()+",");
//				gr = gr.getNext();
//			}
			for (int i = 0; i < vertex; i++) {
				if (!visited[i]) {
					a.artiAlgo(low, desc, graph, i, visited, ap, parent);
				}
			}
			for (int i = 0; i < vertex; i++) {
				// System.out.print(i+",");
				if (ap[i] == true) {
					System.out.print(i + ",");
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void artiAlgo(int[] low, int[] desc,
			GraphNodePathArticulation[] graph, int s, boolean[] visited,
			boolean[] ap, int[] parent) {
		try {
			int child = 0;
			time++;
			low[s] = desc[s] = time;
			visited[s] = true;
			GraphNodePathArticulation g = graph[s];
			while (g != null) {
				if (visited[g.getData()] == false) {
					child++;
					parent[g.getData()] = s;
					artiAlgo(low, desc, graph, g.getData(), visited, ap, parent);
					low[s] = getMin(low[s], low[g.getData()]);
					if (parent[s] == -1 && child > 1) {
						ap[s] = true;
					}
					if (parent[s] != -1 && low[g.getData()] >= low[s]) {
						ap[s] = true;
					}
				} else if (visited[g.getData()] == true
						&& parent[s] != g.getData()) {
					low[s] = getMin(low[s], desc[g.getData()]);
				}
				g = g.getNext();
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

class GraphNodePathListArticulation {
	GraphNodePathArticulation[] graphNodeList;
	boolean[] visited;

	public GraphNodePathListArticulation(int vertex, Scanner sc) {
		graphNodeList = new GraphNodePathArticulation[vertex];
		visited = new boolean[vertex];
		for (int i = 0; i < vertex; i++) {
			graphNodeList[i] = new GraphNodePathArticulation();
			visited[i] = false;
		}
		while (sc.hasNext()) {
			String[] s = sc.next().split("-->");
			int source = Integer.parseInt(s[0]);
			int dest = Integer.parseInt(s[1]);
			addEadge(source, dest);
			// graphNodeList[source] =
			// graphNodeList[source].createGraphList(graphNodeList[source],dest);
		}
	}

	// /sortesPath.txt

	public GraphNodePathArticulation[] getGraphNodeList() {
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
			graphNodeList[d] = graphNodeList[d].createGraphList(
					graphNodeList[d], s);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class GraphNodePathArticulation {
	int data;

	GraphNodePathArticulation next;

	public GraphNodePathArticulation() {

	}

	public GraphNodePathArticulation(int data) {
		this.data = data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(GraphNodePathArticulation next) {
		this.next = next;
	}

	public GraphNodePathArticulation getNext() {
		return next;
	}

	public int getData() {
		return data;
	}

	public GraphNodePathArticulation createGraphList(
			GraphNodePathArticulation graph, int data) {
		try {
			if (!isDataPresent(graph, data)) {
				GraphNodePathArticulation g = new GraphNodePathArticulation(
						data);
				g.setNext(graph);
				graph = g;
			}
			return graph;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean isDataPresent(GraphNodePathArticulation graph, int data) {
		try {

			GraphNodePathArticulation g = graph;
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