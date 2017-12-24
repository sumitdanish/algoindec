package com.algo.ds.practice.Graph;

import java.util.ArrayList;

public class AdjacencyList {

	/** 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int vertex = 5;
			GraphList gp = new GraphList(vertex);
			gp.addEadge(0, 1);
			gp.addEadge(0, 4);

			gp.addEadge(1, 4);
			gp.addEadge(1, 2);
			gp.addEadge(1, 3);

			gp.addEadge(2, 1);
			gp.addEadge(2, 3);

			gp.addEadge(3, 1);
			gp.addEadge(3, 2);
			gp.addEadge(3, 4);

			gp.addEadge(4, 0);
			gp.addEadge(4, 1);
			gp.addEadge(4, 3);

			GraphListNode[] gpl = gp.getGraphListNode();
			GraphListNode list = gpl[0];
			while (list != null) {
				System.out.print(list.getData() + ",");
				list = list.getNext();
			}
			System.out.println("--------");
			// list=gp.removeEadge(gpl[1],4);// Here we are deleting vertex , we
			// are not removing eadge between the vertex
			// while(list.getNext()!=null)
			// {
			// System.out.print(list.getData()+",");
			// list=list.getNext();
			// }
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

class GraphList {
	private GraphListNode[] graphListNode;
	private int vertex;

	public GraphList(int vertex) {
		this.vertex = vertex;
		graphListNode = new GraphListNode[vertex];

		for (int i = 0; i < vertex; i++) {

			graphListNode[i] = new GraphListNode();
		}
	}

	public void addEadge(int sour, int dest) {
		try {
			graphListNode[sour] = graphListNode[sour].createList(
					graphListNode[sour], dest);
			graphListNode[dest] = graphListNode[dest].createList(
					graphListNode[dest], sour);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public GraphListNode[] getGraphListNode() {
		return graphListNode;
	}

	public void setGraphListNode(GraphListNode[] createGrapList) {
		this.graphListNode = graphListNode;
	}

	public GraphListNode removeEadge(GraphListNode graphList, int des) {
		try {

			if (graphList.getData() == des) {
				GraphListNode temp = graphList;
				graphList = graphList.getNext();
				temp = null;
			} else {
				GraphListNode gl = graphList;
				while (gl.getNext() != null) {
					if (gl.getNext().getData() == des) {
						GraphListNode g = gl.getNext();
						gl.setNext(g.getNext());
						break;
					}
					gl = gl.getNext();
				}
			}
			return graphList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}

class CreateGraphList {

}

class GraphListNode {
	int data;
	GraphListNode next;
	boolean isVisited;

	public GraphListNode() {

	}

	public GraphListNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public GraphListNode getNext() {
		return next;
	}

	public void setNext(GraphListNode next) {
		this.next = next;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public GraphListNode createList(GraphListNode list, int data) {
		try {
			if (!isVertex(list, data)) {
				GraphListNode graph = new GraphListNode(data);
				graph.setNext(list);
				list = graph;
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	// This method is for avoiding duplicate vertex insertion in the graph
	private boolean isVertex(GraphListNode gl, int dest) {
		try {
			GraphListNode g = gl;
			while (g != null) {
				if (g.getData() == dest) {
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