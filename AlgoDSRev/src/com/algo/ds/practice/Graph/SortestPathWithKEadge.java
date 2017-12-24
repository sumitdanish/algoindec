package com.algo.ds.practice.Graph;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SortestPathWithKEadge {

	/**
	 * @param args
	 * kSortesPath.txt
	 *  4 // Number of Eadge
		0 // Source
		3 // Destination
		0-->1-->10
		0-->2-->3
		0-->3-->2
		1-->3-->7
		2-->3-->6
	 */
	
	static int max=Integer.MAX_VALUE;
	static int[] array;
	public static void main(String[] args) {
		try{
			SortestPathWithKEadge so = new SortestPathWithKEadge();
			Scanner sc = new Scanner(new File("kSortesPath.txt"));
			int vertex=sc.nextInt();
			int s = sc.nextInt();
			int d=sc.nextInt();
			int[] path=new int[vertex];
			boolean[] visited = new boolean[vertex];
			int weight=0;
			GraphNodePathListSortest graph = new GraphNodePathListSortest(vertex,sc);
			GraphNodePathSortest[] g = graph.getGraphNodeList();
			int k=2;
			so.sortestPath(g, s, d, 0, path, weight, visited,k);
			for(int a:array)
			{
				System.out.print(a+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public void sortestPath(GraphNodePathSortest[] graph,int s,int d,int ind,int[] path,int weight,boolean[] visited,int k){
		try{
			visited[s]=true;
			
			path[ind]=s;
			ind++;
			if(s==d&&k==0){
				if(max>weight)
				{
					max=weight;
					array = Arrays.copyOfRange(path,0,ind);
				}
			}else{
				GraphNodePathSortest g = graph[s];
				while(g.getNext()!=null){
					EadgeList e = g.getEadge();
					int des = e.getDest();
					if(!visited[des]){
						weight+=e.getWeight();
						sortestPath(graph,des,d, ind, path, weight, visited,k-1);
						weight=0;
					}
					g=g.getNext();
				}
			}
			ind--;
			visited[s]=false;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}

class GraphNodePathListSortest {
	GraphNodePathSortest[] graphNodeList;
	boolean[] visited;

	public GraphNodePathListSortest(int vertex, Scanner sc) {
		graphNodeList = new GraphNodePathSortest[vertex];
		visited = new boolean[vertex];
		for (int i = 0; i < vertex; i++) {
			graphNodeList[i] = new GraphNodePathSortest();
			visited[i] = false;
		}
		while (sc.hasNext()) {
			String[] s = sc.next().split("-->");
			int source = Integer.parseInt(s[0]);
			int dest = Integer.parseInt(s[1]);
			int weight = Integer.parseInt(s[2]);
			EadgeList eadge = new EadgeList(dest, weight);
			addEadge(source, eadge);
			// graphNodeList[source] =
			// graphNodeList[source].createGraphList(graphNodeList[source],dest);
		}
	}

	// /sortesPath.txt

	public GraphNodePathSortest[] getGraphNodeList() {
		try {
			return graphNodeList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void addEadge(int s, EadgeList eadge) {
		try {
			graphNodeList[s] = graphNodeList[s].createGraphList(
					graphNodeList[s], eadge);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class GraphNodePathSortest {
	int data;
	private EadgeList eadge;
	GraphNodePathSortest next;

	public GraphNodePathSortest() {

	}

	public GraphNodePathSortest(EadgeList eadge) {
		this.eadge = eadge;
	}

	public void setEadge(EadgeList eadge) {
		this.eadge = eadge;
	}

	public EadgeList getEadge() {
		return eadge;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(GraphNodePathSortest next) {
		this.next = next;
	}

	public GraphNodePathSortest getNext() {
		return next;
	}

	public int getData() {
		return data;
	}

	public GraphNodePathSortest createGraphList(GraphNodePathSortest graph,
			EadgeList eadge) {
		try {
			if (!isDataPresent(graph, eadge.getDest())) {
				GraphNodePathSortest g = new GraphNodePathSortest(eadge);
				g.setNext(graph);
				graph = g;
			}
			return graph;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean isDataPresent(GraphNodePathSortest graph, int data) {
		try {
			GraphNodePathSortest g = graph;
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

class EadgeList {
	private int dest;
	private int weight;

	public EadgeList(int dest, int weight) {
		this.dest = dest;
		this.weight = weight;
	}

	public int getDest() {
		return dest;
	}

	public int getWeight() {
		return weight;
	}
}