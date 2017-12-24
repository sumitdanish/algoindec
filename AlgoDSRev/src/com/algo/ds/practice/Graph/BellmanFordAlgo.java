package com.algo.ds.practice.Graph;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BellmanFordAlgo {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("bell.txt"));
			BellGrapgCreation bell = new BellGrapgCreation(sc);
			int vertex = bell.getVertex();
			int eadge = bell.getEad();
			BellGraph[] bel = bell.getBellGraph();
			BellmanFordAlgo b = new BellmanFordAlgo();
			b.bellmanFordAlgo(bel, eadge, vertex, 0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void bellmanFordAlgo(BellGraph[] bellFord, int eadge, int vertex,
			int source) {
		try {
			int[] dist = new int[vertex];
			for (int i = 0; i < vertex; i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			dist[source] = 0;
			for (int i = 0; i < vertex; i++) {
				for (int j = 0; j < eadge; j++) {
					int s = bellFord[j].getSource();
					int d = bellFord[j].getDesti();
					int w = bellFord[j].getWeight();
					if (dist[s] != Integer.MAX_VALUE && dist[d] > dist[s] + w) {
						dist[d] = dist[s] + w;
					}
				}
			}
			for (int i = 0; i < eadge; i++) {
				int s = bellFord[i].getSource();
				int d = bellFord[i].getDesti();
				int w = bellFord[i].getWeight();
				if (dist[s] != Integer.MAX_VALUE && dist[d] > dist[s] + w) {
					System.out.println("There is -ive cycle in the graph");
				}
			}
			printPath(dist, vertex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void printPath(int[] dis, int vertex) {
		try {
			for (int i = 0; i < vertex; i++) {
				System.out.println(i + " > " + dis[i]);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class BellGrapgCreation {
	private BellGraph[] bellGraph;
	private int ead;
	private int vertex;

	public BellGrapgCreation(Scanner sc) {

		try {
			this.vertex = Integer.parseInt(sc.next());
			this.ead = Integer.parseInt(sc.next());
			bellGraph = new BellGraph[ead];
			for (int i = 0; i < ead; i++) {
				bellGraph[i] = new BellGraph();
			}
			int i = 0;
			while (sc.hasNext() && i < ead) {
				String[] s = sc.next().split("-->");
				int source = Integer.parseInt(s[0]);
				int desti = Integer.parseInt(s[1]);
				int weight = Integer.parseInt(s[2]);
				bellGraph[i] = createGraph(i, source, desti, weight);
				i++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public BellGraph createGraph(int eadge, int source, int dest, int weight) {
		try {
			bellGraph[eadge].setSource(source);
			bellGraph[eadge].setDesti(dest);
			bellGraph[eadge].setWeight(weight);
			return bellGraph[eadge];
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public int getEad() {
		return ead;
	}

	public void setEad(int ead) {
		this.ead = ead;
	}

	public BellGraph[] getBellGraph() {
		return bellGraph;
	}

	public void setBellGraph(BellGraph[] bellGraph) {
		this.bellGraph = bellGraph;
	}

}

class BellGraph {
	private int source;
	private int desti;
	private int weight;

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getDesti() {
		return desti;
	}

	public void setDesti(int desti) {
		this.desti = desti;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}