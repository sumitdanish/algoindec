package com.algo.ds.practice.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class GreedyApprochForSortestPath {

	/**
	 * @param args
	 *            int[][] adJacencyMatt = { //0 1 2 3 4 4 6 7 8 {0, 4, 0, 0, 0,
	 *            0, 0, 8, 0},// each cell value represent the weight between
	 *            the vertex {4, 0, 8, 0, 0, 0, 0, 11, 0}, {0, 8, 0, 7, 0, 4, 0,
	 *            0, 2}, {0, 0, 7, 0, 9, 14, 0, 0, 0}, {0, 0, 0, 9, 0, 10, 0, 0,
	 *            0}, {0, 0, 4, 0, 10, 0, 2, 0, 0}, {0, 0, 0, 14, 0, 2, 0, 1,
	 *            6}, {8, 11, 0, 0, 0, 0, 1, 0, 7}, {0, 0, 2, 0, 0, 0, 6, 7, 0}
	 *            };
	 */
	// static int[][] adJacencyMatt;
	static boolean[] visited;
	static int[] dist;
	static int[] path;

	public static void main(String[] args) {

		try {
			int[][] adJacencyMatt = { // 0 1 2 3 4 4 6 7 8
					{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },// each cell value represent
													// the weight between the
													// vertex
					{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
					{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
					{ 0, 0, 7, 0, 9, 14, 0, 0, 0 },
					{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
					{ 0, 0, 4, 0, 10, 0, 2, 0, 0 },
					{ 0, 0, 0, 14, 0, 2, 0, 1, 6 },
					{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
					{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
			GreedyApprochForSortestPath b = new GreedyApprochForSortestPath(9);
			b.sortesPath(9, adJacencyMatt);
			for (int i = 0; i < 9; i++) {
				System.out.println(i + "-->" + path[i]);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public GreedyApprochForSortestPath(int vertex) {
		visited = new boolean[vertex];
		path = new int[vertex];
		dist = new int[vertex];
		for (int i = 0; i < vertex; i++) {
			visited[i] = false;
			dist[i] = -1;
		}
	}

	private void sortesPath(int vertex, int[][] adjaMat) {
		try {
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(0);
			int v1 = 0;
			while (!q.isEmpty()) {
				int v2 = q.peek();
				q.poll();
				while ((v1 = getAdjacentVertex(v2, adjaMat)) != -1) {
					if (dist[v1] == -1) {
						dist[v1] = dist[v1] + 1;
						visited[v1] = true;
						q.add(v1);
						path[v1] = v2;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int getAdjacentVertex(int v, int[][] adjaMat) {
		try {
			for (int i = 0; i < 9; i++) {
				if (!visited[i] && adjaMat[v][i] > 0) {
					return i;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
