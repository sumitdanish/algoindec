package com.algo.ds.practice.Graph;

import java.io.File;
import java.util.Scanner;

public class PrimsAlgo {

	/**
	 * @param args
	 *            /* Let us create the following graph 2 3 (0)--(1)--(2) | / \ |
	 *            6| 8/ \5 |7 | / \ | (3)-------(4) 9
	 */

	int[] dist;
	boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Scanner sc = new Scanner(new File("prims.txt"));
			int vertex = Integer.parseInt(sc.next());
			PrimsAlgo p = new PrimsAlgo(vertex);
			int[][] adj = new int[vertex][vertex];
			while (sc.hasNext()) {
				String[] s = sc.next().split("-->");
				int source = Integer.parseInt(s[0]);
				int desti = Integer.parseInt(s[1]);
				int w = Integer.parseInt(s[2]);
				adj[source][desti] = w;
			}
			p.primsAlgo(adj, vertex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public PrimsAlgo(int vertex) {
		try {
			dist = new int[vertex];
			visited = new boolean[vertex];
			for (int i = 0; i < vertex; i++) {
				dist[i] = Integer.MAX_VALUE;
				visited[i] = false;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int getAdja(int vertex) {
		try {
			int minIndex = 0;
			int max = Integer.MAX_VALUE;
			for (int i = 0; i < vertex; i++) {
				if (!visited[i] && dist[i] < max) {
					max = dist[i];
					minIndex = i;
				}
			}
			return minIndex;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void print(int[] pr, int vertex, int[][] adj) {
		try {
			System.out.println("Source<-->" + "Destination<-->" + "weight\n");
			for (int i = 1; i < vertex; i++) {
				System.out.println(pr[i] + "<-->" + i + "<-->" + adj[pr[i]][i]);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void primsAlgo(int[][] adjMatt, int vertex) {
		try {
			int[] pr = new int[vertex];
			dist[0] = 0;
			pr[0] = -1;
			for (int i = 0; i < vertex - 1; i++) {
				int u = getAdja(vertex);
				visited[u] = true;
				for (int j = 0; j < vertex; j++) {
					if (u != -1 && visited[j] == false
							&& dist[j] >= adjMatt[u][j]) {
						dist[j] = adjMatt[u][j];
						pr[j] = u;
					}
				}
			}
			print(pr, vertex, adjMatt);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
