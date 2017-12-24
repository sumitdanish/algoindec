package com.algo.ds.practice.GeometryAlgo;

public class OverlapingRact {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
				PointOver p1 = new PointOver(0, 10);
				PointOver q1 = new PointOver(10, 0);
    			PointOver p2 = new PointOver(5, 5); 
    			PointOver q2 = new PointOver(15, 0);
    			OverlapingRact over = new OverlapingRact();
    			if(over.isOverlap(p1, q1, p2, q2)){
    				System.out.println("Its Overlapping...");
    			}else{
    				System.out.println("Its Not Overlapping");
    			}

		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public boolean isOverlap(PointOver p1,PointOver q1,PointOver p2,PointOver q2){
		try{
			if(p2.getX()>q1.getX()||p1.getX()>q2.getX()){
				return false;
			}
			if(q2.getY()>p1.getY()||q1.getY()>p2.getY()){
				return false;
			}
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
}


class PointOver
{
	private int x;
	private int y;
	public PointOver(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	public int getY(){
		return y;
	}
	
	public int getX(){
		return x;
	}
}
