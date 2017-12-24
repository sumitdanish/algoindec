package com.algo.ds.practice.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkersonAlgorithamMaxflow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			FordFulkersonAlgorithamMaxflow fa = new FordFulkersonAlgorithamMaxflow();
			int[][] graph = { 
								{0, 16, 13, 0, 0, 0},
                    			{0, 0, 10, 12, 0, 0},
                    			{0, 4, 0, 0, 14, 0},
                    			{0, 0, 9, 0, 0, 20},
                    			{0, 0, 0, 7, 0, 4},
                    			{0, 0, 0, 0, 0, 0}
                  			};
			int vertex = 6;
			int s=0;
			int t=5;
			int maxFlow = fa.maxFlow(graph, vertex, s, t);
			System.out.println(maxFlow);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	private int maxFlow(int[][] graph,int vertex,int s,int t){
		try{
			int max = 0;
			int[][] rGraph = new int[vertex][vertex];
			for(int i=0;i<vertex;i++){
				for(int j=0;j<vertex;j++){
					rGraph[i][j] = graph[i][j];
				}
			}
			int pathFlow = 0;
			
			int[] parent = new int[vertex];
			int u=0;
			boolean[] visited = new boolean[vertex];
			while(BFSAlgo(rGraph, parent, s, t, visited)){
				pathFlow = Integer.MAX_VALUE;
				for(int v=t;v!=s;v=parent[v]){
					u = parent[v];
					pathFlow = getMin(pathFlow,rGraph[u][v]);
				}
				for(int v=t;v!=s;v=parent[v]){
					u = parent[v];
					rGraph[u][v] -=pathFlow;
					rGraph[v][u] +=pathFlow;
				}
				max+=pathFlow;
			}
			return max;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private int getMin(int a,int b){
		try{
			return a<b?a:b;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private boolean BFSAlgo(int[][] rGraph,int[] parent,int s/*Source*/,int t/*Sink*/,boolean[] visited){
		try{
			visited[s]=true;
			parent[s]=-1;
			Queue<Integer>q = new LinkedList<Integer>();
			q.add(s);
			while(!q.isEmpty()){
				int v1 = q.peek();q.poll();
				int v2=0;
				while((v2=isSafe(rGraph, v1, visited.length, visited))!=-1){
					parent[v2]=v1;
					visited[v2]=true;
					q.add(v2);
				}
			}
			if(visited[t]==true){
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private int isSafe(int[][] rGraph,int s,int vertex,boolean[] visited){
		try{
			for(int i=0;i<vertex;i++){
				if(!visited[i]&&rGraph[s][i]>0){
					return i;
				}
			}
			return -1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
