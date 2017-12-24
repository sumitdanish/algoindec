package com.algo.ds.practice.Graph;

public class MthColoringProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[][] graph = {
								 {0, 1, 1, 1},
				        		 {1, 0, 1, 0},
				        		 {1, 1, 0, 1},
				        		 {1, 0, 1, 0},
			    			};
			int number_of_color = 3;
			int vertex = 4;
			MthColoringProblem mthColor = new MthColoringProblem();
			mthColor.mthColorable(graph, number_of_color, vertex);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void mthColorable(int[][] graph,int number_of_color,int  vertex){
		try{
			int[] color = new int[vertex];
			for(int i=0;i<vertex;i++){
				color[i] = 0;
			}
			if(isColorable(graph,0, vertex, color,number_of_color)){
				System.out.println("Solution exist");
				printSolution(color,vertex);
			}else{
				System.out.println("Try again.......");
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private void printSolution(int[] color,int vertex){
		try{
			for(int i=0;i<vertex;i++){
				if(color[i]!=0){
					System.out.print(color[i]);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private boolean isSafe(int[][] graph,int v,int c,int[] color,int vertex){
		try{
			
			for(int co = 0;co<vertex;co++){
				if(graph[v][co]==1&&c == color[co]){
					return false;
				}
			}
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private boolean isColorable(int[][] graph,int v,int vertex,int[] color,int number_of_color){
		try{
			if(v==vertex-1){
				return true;
			}
			for(int ve = 1;ve<=number_of_color;ve++){
				if(isSafe(graph,v,ve, color, vertex)){
					color[v] = ve;
					if(isColorable(graph, v+1, color.length, color,number_of_color)){
						return true;
					}
					color[v] = 0;
				}
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
}
