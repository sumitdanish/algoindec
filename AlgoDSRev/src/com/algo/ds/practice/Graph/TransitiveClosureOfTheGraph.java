package com.algo.ds.practice.Graph;

public class TransitiveClosureOfTheGraph {

	/**
	 * @param args
	 * Given a directed graph, find out if a vertex j is reachable from another vertex i for all vertex pairs (i, j) 
	 * in the given graph. Here reachable mean that there is a path from vertex i to j.
	 *  The reach-ability matrix is called transitive closure of a graph.
		The graph is given in the form of adjacency matrix say ‘graph[V][V]’ where graph[i][j] is 1 if there is an edge 
		from vertex i to vertex j or i is equal to j, otherwise graph[i][j] is 0.
	 */
	public static void main(String[] args) {
		try{
			int n = 4;
			int[][] adjMat = { 	{0,   5, 100, 10},
							    {100, 0,   3,100},
							    {100,100, 0,   1},
							    {100,100,100, 0}
							 };
			TransitiveClosureOfTheGraph t = new TransitiveClosureOfTheGraph();
			t.transitiveClosure(adjMat, n);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	private void transitiveClosure(int[][] graph,int vertex){
		try{
			
			boolean [][] dist = new boolean[vertex][vertex];
			for(int i=0;i<vertex;i++){
				for(int j=0;j<vertex;j++){
					if(graph[i][j]<100){
						dist[i][j] = true;
					}
				}
			}
			
			for(int k=0;k<vertex;k++){
				for(int i=0;i<vertex;i++){
					for(int j=0;j<vertex;j++){
						dist[i][j] = dist[i][j]||dist[i][k]&&dist[k][j];
					}
				}
			}
			printSol(dist, vertex);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void printSol(boolean[][] dist,int vertex){
		try{
			for(int i=0;i<vertex;i++){
				for(int j=0;j<vertex;j++){
					System.out.print(dist[i][j]?1+",":0+",");
				}
				System.out.println();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
