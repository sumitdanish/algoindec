package com.algo.ds.practice.Graph;

import java.io.File;
import java.util.Scanner;

public class DFSTravelingTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(new File("dfstime.txt"));
			int vertex = sc.nextInt();
			GraphList1 gl = new GraphList1(sc, vertex);
			GraphNode[] gn = gl.getGraphNode();
			gl.dfsTraversal(4);
			DfsTime[] time = gl.getDfsTime();
			System.out.println(time[0].getStartTime() + " > "
					+ time[0].getEndTime());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class GraphList1 {
	private GraphNode[] graphNode;
	private DfsTime[] dfsTime;
	private boolean[] isWhite;
	private boolean[] isGray;
	private boolean[] isBlack;
	private int time = 0;

	public GraphList1(Scanner sc, int vertex) {
		try {
			graphNode = new GraphNode[vertex];
			dfsTime = new DfsTime[vertex];
			isWhite = new boolean[vertex];
			isBlack = new boolean[vertex];
			isGray = new boolean[vertex];
			for (int i = 0; i < vertex; i++) {
				graphNode[i] = new GraphNode();
				dfsTime[i] = new DfsTime();
				isWhite[i] = false;
				isBlack[i] = false;
				isGray[i] = false;
			}

			while (sc.hasNext()) {
				String[] s = sc.next().split("-->");
				int so = Integer.parseInt(s[0]);
				int de = Integer.parseInt(s[1]);
				addEadge(so, de);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void dfsTraversal(int vertex) {
		time = 0;
		DFSTraversal(vertex, getGraphNode());
	}

	public DfsTime[] getDfsTime() {
		return dfsTime;
	}

	public void setDfsTime(DfsTime[] dfsTime) {
		this.dfsTime = dfsTime;
	}

	public void addEadge(int s, int d) {
		try {
			graphNode[s] = graphNode[s].createNode(graphNode[s], d);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public GraphNode[] getGraphNode() {
		try {
			return graphNode;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void setGraphNode(GraphNode[] grpahNode) {
		try {
			this.graphNode = grpahNode;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void DFSTraversal(int s, GraphNode[] gn) {
		try {
			isGray[s] = true;
			isWhite[s] = true;
			time = time + 1;
			getDfsTime()[s].setStartTime(time);
			GraphNode g = gn[s];
			while (g.getNext() != null) {
				if (!isWhite[g.getData()]) {
					DFSTraversal(g.getData(), gn);
				}
				g = g.getNext();
			}
			isBlack[s] = true;
			time = time + 1;
			System.out.println();
			getDfsTime()[s].setEndTime(time);
			System.out.println(getDfsTime()[s].getStartTime()+" > "+getDfsTime()[s].getEndTime());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class DfsTime {
	private int startTIme;
	private int endTime;

	public void setStartTime(int startTime) {
		try {
			this.startTIme = startTime;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setEndTime(int endTime) {
		try {
			this.endTime = endTime;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int getEndTime() {
		try {
			return endTime;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	public int getStartTime() {
		try {
			return startTIme;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}
}

class GraphNode {
	private int data;
	private GraphNode next;

	public GraphNode() {

	}

	public GraphNode(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public GraphNode getNext() {
		return next;
	}

	public void setNext(GraphNode next) {
		this.next = next;
	}

	public GraphNode createNode(GraphNode graph, int des) {
		try {
			if (!isVertex(graph, des)) {
				GraphNode g = new GraphNode(des);
				g.setNext(graph);
				graph = g;
			}
			return graph;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean isVertex(GraphNode list, int data) {
		try {
			GraphNode l = list;
			while (l != null) {
				if (l.getData() == data) {
					return true;
				}
				l = l.getNext();
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
