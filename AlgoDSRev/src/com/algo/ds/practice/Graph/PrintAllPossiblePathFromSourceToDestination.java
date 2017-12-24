package com.algo.ds.practice.Graph;

import java.io.File;
import java.util.Scanner;

public class PrintAllPossiblePathFromSourceToDestination {

	/**
	 * @param args
	 * 
	 *            4 (Total no of vertex) 2-->3 (Source and destination)
	 *            ..Conectivity between vertex 2-->0 0-->2 0-->3 2-->1 1-->3
	 * 
	 */
	public static void main(String[] args) {
		try {
			PrintAllPossiblePathFromSourceToDestination p = new PrintAllPossiblePathFromSourceToDestination();
			Scanner sc = new Scanner(new File("sortesPath.txt"));
			int vertex = sc.nextInt();
			String[] st = sc.next().split("-->");
			int source = Integer.parseInt(st[0]);
			int dest = Integer.parseInt(st[1]);
			GraphNodePathList graph = new GraphNodePathList(vertex);
			int[] path = new int[vertex];
			int ind = 0;
			boolean[] visited = new boolean[vertex];
			while (sc.hasNext()) {
				String[] s = sc.next().split("-->");
				int so = Integer.parseInt(s[0]);
				int des = Integer.parseInt(s[1]);
				graph.addEadge(so, des);
			}
			GraphNodePath[] graphL = graph.getGraphNodeList();
			p.possiblePath(graphL, source, dest, path, ind, visited);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void possiblePath(GraphNodePath[] graph, int source, int dest,
			int[] path, int ind, boolean[] visited) {

		try {
			path[ind] = source;
			visited[source] = true;
			ind++;
			if (source == dest) {
				for (int i = 0; i < ind; i++) {
					System.out.print(path[i] + ",");
				}
				System.out.println();
			} else {
				GraphNodePath g = graph[source];
				while (g != null) {
					if (!visited[g.getData()]) {
						possiblePath(graph, g.getData(), dest, path, ind,
								visited);
					}
					g = g.getNext();
				}
			}
			ind--;
			visited[source] = false;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

class GraphNodePathList {
	GraphNodePath[] graphNodeList;
	boolean[] visited;

	public GraphNodePathList(int vertex) {
		graphNodeList = new GraphNodePath[vertex];
		visited = new boolean[vertex];
		for (int i = 0; i < vertex; i++) {
			graphNodeList[i] = new GraphNodePath();
			visited[i] = false;
		}
	}

	// /sortesPath.txt

	public GraphNodePath[] getGraphNodeList() {
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

class GraphNodePath {
	int data;

	GraphNodePath next;

	public GraphNodePath() {

	}

	public GraphNodePath(int data) {
		this.data = data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(GraphNodePath next) {
		this.next = next;
	}

	public GraphNodePath getNext() {
		return next;
	}

	public int getData() {
		return data;
	}

	public GraphNodePath createGraphList(GraphNodePath graph, int data) {
		try {
			if (!isDataPresent(graph, data)) {
				GraphNodePath g = new GraphNodePath(data);
				g.setNext(graph);
				graph = g;
			}
			return graph;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean isDataPresent(GraphNodePath graph, int data) {
		try {

			GraphNodePath g = graph;
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