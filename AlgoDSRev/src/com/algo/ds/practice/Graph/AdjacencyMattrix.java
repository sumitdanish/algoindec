package com.algo.ds.practice.Graph;

public class AdjacencyMattrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int vertex = 5;
			AjacencyGraph ad = new AjacencyGraph(vertex);
			ad.addEadge(0, 1);
			ad.addEadge(0, 4);

			ad.addEadge(1, 2);
			ad.addEadge(1, 3);
			ad.addEadge(1, 4);

			ad.addEadge(2, 3);

			ad.addEadge(3, 4);

			int[][] path = ad.getAdjacencyMat();
			for (int i = 0; i < vertex; i++) {
				for (int j = 0; j < vertex; j++) {
					System.out.print(path[i][j] + ",");
				}
				System.out.println();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

class AjacencyGraph {
	private int vertex;
	private int[][] adjacencyMat;

	public AjacencyGraph(int vertex) {
		this.vertex = vertex;
		adjacencyMat = new int[vertex][vertex];
	}

	public int[][] getAdjacencyMat() {
		try {
			return adjacencyMat;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void setAdjacencyMat(int[][] adjacencyMat) {
		try {
			this.adjacencyMat = adjacencyMat;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addEadge(int source, int destination) {
		adjacencyMat[source][destination] = 1;
		adjacencyMat[destination][source] = 1;
	}
}