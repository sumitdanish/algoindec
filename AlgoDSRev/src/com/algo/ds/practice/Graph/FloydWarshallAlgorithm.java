package com.algo.ds.practice.Graph;

public class FloydWarshallAlgorithm {

	/**
	 * @param args
	 *The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem. 
	 *The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph.
	 */
	public static void main(String[] args) {
		try{
			int n = 4;
			int[][] adjMat = { 	{0,   5, 100, 10},
							    {100, 0,   3,100},
							    {100,100, 0,   1},
							    {100,100,100, 0}
							 };
			FloydWarshallAlgorithm fl = new FloydWarshallAlgorithm();
			fl.floydWarshal(adjMat,n,n);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void floydWarshal(int[][] adjMat,int row,int col){
		try{
			int[][] dist = new int[row][col];
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					dist[i][j] = adjMat[i][j];
				}
			}
			for(int k=0;k<row;k++){
				for(int i=0;i<row;i++){
					for(int j=0;j<row;j++){
						if(dist[i][j]>dist[i][k]+dist[k][j]){
							dist[i][j]=dist[i][k]+dist[k][j];
						}
					}
				}
			}
			print(dist,row);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void print(int[][] dist,int n){
		try{
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					System.out.print(dist[i][j]+",");
				}
				System.out.println();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
