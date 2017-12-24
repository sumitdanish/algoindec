package com.algo.ds.practice.ArrayPractice;

public class KnightTourProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			KnightTourProblem kn = new KnightTourProblem();
			kn.knightTourProblem();
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private void knightTourProblem(){
		try{
			int n=8;
			int[][] sol = new int[n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					sol[i][j] = -1;
				}
			}
//			int[] xMoveCoordinate = { 2, 1, -1, -2, -2, -1, 1, 2 };
//		    int[] yMoveCoordinate = { 1, 2, 2, 1, -1, -2, -2, -1 };
			int[] xMoveCoordinate={2,-2,2,-2,1,-1,1,-1};
			int[] yMoveCoordinate={1,-1,-1,1,2,-2,-2,2};
			sol[0][0]=0;
			if(!isSolutionExist(sol,0,0,1,n,xMoveCoordinate,yMoveCoordinate)){
				System.out.println("Sorry!... no move is exist");
				
			}
			else{
				printMovedCells(sol, n);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private boolean isSafeCell(int[][] sol,int moveX,int moveY,int n){
		try{
			if(moveX>=0&&moveX<n&&moveY>=0&&moveY<n&&sol[moveX][moveY]==-1){
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private boolean isSolutionExist(int[][] sol,int moveX,int moveY,int totalMove,int n,int[] xMoveCoordinate,int[] yMoveCoordinate){
		try{
			int next_xMove=0;
			int next_yMove=0;
			if(totalMove==n*n){
				return true;
			}
			int i=0;
			for(i=0;i<n;i++){
				next_xMove=moveX+xMoveCoordinate[i];
				next_yMove=moveY+yMoveCoordinate[i];
				if(isSafeCell(sol, next_xMove, next_yMove, n)){
					sol[next_xMove][next_yMove] = totalMove;
					if(isSolutionExist(sol, next_xMove, next_yMove, totalMove+1, n,xMoveCoordinate,yMoveCoordinate)){
						return true;
					}else{
						sol[next_xMove][next_yMove]=-1;
					}
				}
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	private void printMovedCells(int[][] sol,int n){
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
