package com.algo.ds.practice.Graph;

public class DijakstraSortestPath {

	/**
	 * @param args
	 */

	static boolean[] visited;
	static int[] dist;

	public static void main(String[] args) {

		try {
			int[][] adJacencyMatt = { // 0 1 2 3 4 4 6 7 8
									   { 0, 4, 0, 0, 0, 0, 0, 8, 0 },	// each cell value represent
																		// the weight between the
																		// vertex
									   { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
									   { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
									   { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
									   { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
									   { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
									   { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
									   { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
									   { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
									  };
			int vertex = 9;
			DijakstraSortestPath d = new DijakstraSortestPath(vertex);
			d.sortestPath(adJacencyMatt, vertex);
			for (int i = 0; i < vertex; i++) {
				System.out.println(i + " > " + dist[i]);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public DijakstraSortestPath(int vertex) {
		dist = new int[vertex];
		visited = new boolean[vertex];
		for (int i = 0; i < vertex; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

	}

	private int getAdjacent(int vertex) {
		try {

			int maxDis = Integer.MAX_VALUE;
			int min_index = 0;
			for (int i = 0; i < vertex; i++) {
				if (!visited[i] && dist[i] <= maxDis) {
					maxDis = dist[i];
					min_index = i;
				}
			}
			return min_index;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void sortestPath(int[][] adjaMat, int vertex) {
		try {
			dist[0] = 0;
			for (int i = 0; i < vertex - 1; i++) {
				int u = getAdjacent(vertex);
				visited[u] = true;
				for (int j = 0; j < vertex; j++) {
					if (!visited[j] && adjaMat[u][j] != 0
							&& dist[u] != Integer.MAX_VALUE
							&& dist[j] >= dist[u] + adjaMat[u][j]) {
						dist[j] = dist[u] + adjaMat[u][j];
						// System.out.println(j+" >  > "+dist[j]);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
