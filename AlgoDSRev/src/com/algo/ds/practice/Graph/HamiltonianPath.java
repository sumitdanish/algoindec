package com.algo.ds.practice.Graph;

public class HamiltonianPath {

	/**
	 * @param args
	 * /* Let us create the following graph
		      (0)--(1)--(2)
		       |   / \   |
		       |  /   \  |
		       | /     \ |
		      (3)-------(4)    
      */
	
	
	public static void main(String[] args) {
		try{
			HamiltonianPath h = new HamiltonianPath();
			int[][] adjMat = {
								{0, 1, 0, 1, 0},
			                    {1, 0, 1, 1, 1},
			                    {0, 1, 0, 0, 1},
			                    {1, 1, 0, 0, 1},
			                    {0, 1, 1, 1, 0},
                   			};
			int vertex = 5;
			boolean b = h.isHamiltonianCycle(adjMat, vertex);
			if(b){
				System.out.println("Some Path");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	
	private boolean isHamiltonianCycle(int[][] adjMat,int vertex){
		try{
			int[] path = new int[vertex];
			int pos = 0;
			for(int i=0;i<vertex;i++){
				path[i]=-1;
			}
			path[pos]=0;
			if(hamiltonCycle(adjMat, path,1, vertex)==false){
				return false;
			}
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private boolean hamiltonCycle(int[][] adjMat,int[] path,int pos,int vertex){
		try{
			
			if(vertex==pos){
				if(adjMat[path[pos-1]][path[0]]==1){
					return true;
				}else{
					return false;
				}
			}
			for(int v=1;v<vertex;v++){
				if(isSafe(adjMat,v, path, pos)){
					path[pos]=v;
					if(hamiltonCycle(adjMat,path, pos+1, vertex)==true){
						return true;
					}
					path[pos]=-1;
				}
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	private boolean isSafe(int[][] adjMat,int s,int[] path,int pos){
		try{
			
			if(adjMat[path[pos-1]][s]==0){
				return false;
			}
			for(int i=0;i<pos;i++){
				if(path[i]==s){
					return false;
				}
			}
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
}
