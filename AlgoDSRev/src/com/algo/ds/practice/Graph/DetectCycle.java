package com.algo.ds.practice.Graph;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class DetectCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		try{
			DetectCycle de = new DetectCycle();
			Scanner sc = new Scanner(new File("cycle.txt"));
			int vertex = sc.nextInt();
			int source = sc.nextInt();
			boolean[] visited = new boolean[vertex];
			boolean[] inStack = new boolean[vertex];
			for(int i=0;i<vertex;i++){
				visited[i]=false;
				inStack[i]=false;
			}
			GraphNodePathListCycle gr = new GraphNodePathListCycle(vertex,sc);
			GraphNodePathCycle[] graph = gr.getGraphNodeList();
			//boolean b = de.isCycleInGraph(graph,source, visited);
			boolean b = de.isCycleInGraph1(graph,source,visited,inStack);
			if(b){
				System.out.println("cy");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private boolean isCycleInGraph1(GraphNodePathCycle[] graph,int s,boolean[] visited,boolean[] inStack){
		try{
			if(visited[s]==false){
				visited[s]=true;
				inStack[s]=true;
				GraphNodePathCycle g = graph[s];
				while(g!=null){
					if(!visited[s]&&isCycleInGraph1(graph, g.getData(), visited, inStack)){
						return true;
					}else if(!inStack[g.getData()]){
						return true;
					}
				}
				//visited[s]=false;
				inStack[s]=false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return true;
	}
	
	public boolean isCycleInGraph(GraphNodePathCycle[] graph,int s,boolean[] visited){
		try{
			visited[s]=true;
			Stack<Integer> st = new Stack<Integer>();
			st.push(s);
			while(!st.isEmpty()){
				int v = st.peek();
				//System.out.println(v+","+visited[v]);
				if(v==s&&visited[v]==false){
					return true;
				}
				int v1 =0;
				GraphNodePathCycle gr = graph[v];
				while(gr!=null){
					if(!visited[gr.getData()]){
						v1=gr.getData();
						visited[v1]=true;
					}
				}
				if(v1==-1){
					st.pop();
				}
				else{
					//st.pop();
					st.push(v1);
					visited[v1]=false;;
				}
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	public int getAdjacentVertex(GraphNodePathCycle[] graph,int s,boolean[] visited){
		try{
		
			GraphNodePathCycle g = graph[s];
			while(g.getNext()!=null){
				if(!visited[g.getData()]){
					visited[g.getData()] = true;
					return g.getData();
				}
				g=g.getNext();
			}
			return -1;
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
}
class GraphNodePathListCycle {
	GraphNodePathCycle[] graphNodeList;
	boolean[] visited;

	public GraphNodePathListCycle(int vertex,Scanner sc) {
		graphNodeList = new GraphNodePathCycle[vertex];
		visited = new boolean[vertex];
		for (int i = 0; i < vertex; i++) {
			graphNodeList[i] = new GraphNodePathCycle();
			visited[i] = false;
		}
		
		while(sc.hasNext()){                                      
			String[] s = sc.next().split("-->");
			int source = Integer.parseInt(s[0]);
			int destin = Integer.parseInt(s[1]);
			addEadge(source,destin);
		}
	}

	// /sortesPath.txt

	public GraphNodePathCycle[] getGraphNodeList() {
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

class GraphNodePathCycle {
	int data;

	GraphNodePathCycle next;

	public GraphNodePathCycle() {

	}

	public GraphNodePathCycle(int data) {
		this.data = data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(GraphNodePathCycle next) {
		this.next = next;
	}

	public GraphNodePathCycle getNext() {
		return next;
	}

	public int getData() {
		return data;
	}

	public GraphNodePathCycle createGraphList(GraphNodePathCycle graph, int data) {
		try {
			if (!isDataPresent(graph, data)) {
				GraphNodePathCycle g = new GraphNodePathCycle(data);
				g.setNext(graph);
				graph = g;
			}
			return graph;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean isDataPresent(GraphNodePathCycle graph, int data) {
		try {

			GraphNodePathCycle g = graph;
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