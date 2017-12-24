package com.algo.ds.practice.ArrayPractice;

public class NQueenProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	private boolean isSafe(int[][] place,int row,int col,int n){
		try{
			for(int i=0;i<col;i++){
				if(place[row][i]==1){
					return false;
				}
			}
			for(int i=row,j=col;i>=0&&j>=0;i--,j--){
				if(place[i][j]==1){
					return false;
				}
			}
			for(int i=row,j=col;i<n&&j>=0;i++,j--){
				if(place[i][j]==1){
					return false;
				}
			}
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private boolean isSolution(int[][] place,int col,int n){
		try{
			if(col==n-1){
				return true;
			}
			for(int i=0;i<n;i++){
				if(isSafe(place,i, col, n)){
					place[i][col]=1;
					if(isSolution(place, col+1, n)){
						return true;
					}
					place[i][col] = 0;
				}
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
}
