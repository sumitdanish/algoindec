package com.algo.ds.practice.Graph;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologocalSorting {

	/**
	 * @param args
	 */
	TopoNode[] topoNode;
	static int[][] adMattrix;
	static int[] indegree;
	static int vertex;
	static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			TopologocalSorting ts = new TopologocalSorting();
			for (int i = 0; i < vertex; i++) {
				for (int j = 0; j < vertex; j++) {
					if (adMattrix[i][j] == 1) {
						indegree[j] += 1;
					}
				}
			}
			ts.topSorting(adMattrix, vertex);
			// for(int i=0;i<vertex;i++)
			// {
			// if(indegree[i]!=0)
			// {
			// System.out.println(i+" > "+indegree[i]);
			// }
			// }
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public TopologocalSorting() {
		try {
			Scanner sc = new Scanner(new File("Topo.txt"));
			vertex = Integer.parseInt(sc.next());
			indegree = new int[vertex];
			int source = 0;
			int des = 0;
			visited = new boolean[vertex];
			adMattrix = new int[vertex][vertex];
			topoNode = new TopoNode[vertex];
			for (int i = 0; i < vertex; i++) {
				for (int j = 0; j < vertex; j++) {
					adMattrix[i][j] = 0;
				}
				visited[i] = false;
			}
			while (sc.hasNext()) {
				String[] ver = sc.next().split("-->");
				source = Integer.parseInt(ver[0]);
				des = Integer.parseInt(ver[1]);
				adMattrix[source][des] = 1;
			}
			for (int i = 0; i < vertex; i++) {
				topoNode[i] = new TopoNode();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void topSorting(int[][] adMattrix, int vertex) {
		try {
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i = 0; i < vertex; i++) {
				if (indegree[i] == 0) {
					queue.add(i);
				}
			}
			int[] jobSequence = new int[vertex];
			int x = 0;
			int counter = 0;
			while (!queue.isEmpty()) {
				int h = queue.peek();
				queue.poll();
				jobSequence[h] = ++counter;// calculating cycle in graph if
											// counter!=vertex then cycle in the
											// graph ot deadlock in the system
				while ((x = getAdjacent(vertex, h)) != -1) {
					if (--indegree[x] == 0) {
						queue.add(x);
						System.out.print(x + ",");
					}
				}
			}
			System.out.println("\n" + counter);
			// for(int i=0;i<vertex;i++)
			// {
			// if(jobSequence[i]!=0)
			// {
			// System.out.print(jobSequence[i]+",");
			// }
			// }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int getAdjacent(int vertex, int so) {
		try {
			for (int i = 0; i < vertex; i++) {
				if (adMattrix[so][i] == 1 && indegree[i] > 0) {
					// System.out.println(i);
					return i;
				}
			}
			return -1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}

class TopoNode {
	private int sou;
	private int des;
	private boolean isVis;

	public int getSou() {
		return sou;
	}

	public void setSou(int sou) {
		this.sou = sou;
	}

	public int getDes() {
		return des;
	}

	public void setDes(int des) {
		this.des = des;
	}

	public boolean isVis() {
		return isVis;
	}

	public void setVis(boolean isVis) {
		this.isVis = isVis;
	}

}