package com.algo.ds.practice.ArrayPractice;

public class RatMazeProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			RatMazeProblem rmz = new RatMazeProblem();
			int[][] maze  =  { 
								{1, 0, 0, 0},
			        			{1, 1, 0, 1},
			        			{0, 1, 0, 0},
			        			{1, 1, 1, 1}
			    			};
			rmz.isSolutionExist(maze);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void isSolutionExist(int[][] maze){
		try{
			int n = 4;
			int[][] sol = new int[n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					sol[i][j] = 0;
				}
			}
			
			if(isSolution(maze, sol,0,0, n))
			{
				System.out.println("Solution Exist\n");
				printSol(sol, n);
			}else{
				System.out.println("Please try again!..");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	private boolean isSafe(int[][] maze,int x,int y,int n){
		try{
			if(x>=0&&x<n&&y>=0&&y<n&&maze[x][y]==1){
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private boolean isSolution(int[][] maze,int[][] sol,int x,int y,int n){
		try{
			
			if(x==n-1&&y==n-1){
				sol[x][y] = 1;
				return true;
			}
			if(isSafe(maze, x, y, n)){
				sol[x][y]=1;
				if(isSolution(maze,sol, x+1, y, n)){
					return true;
				}
				if(isSolution(maze,sol, x, y+1, n)){
					return true;
				}
				sol[x][y]=0;
			}
			return false;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private void printSol(int[][] sol,int n){
		try{
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					System.out.print(sol[i][j]+",");
				}
				System.out.println();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
