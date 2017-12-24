package com.algo.ds.practice.GeometryAlgo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class ConvexHull {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			ConvexHull convexHull = new ConvexHull();
			Scanner sc = new Scanner(new File("convex.txt"));
			ArrayList<PointConvex> pointList = new ArrayList<PointConvex>();
			int number_of_point = sc.nextInt();
			while(sc.hasNext()){
				String[] s = sc.next().split(",");
				int x = Integer.parseInt(s[0]);
				int y = Integer.parseInt(s[1]);
				PointConvex pc = new PointConvex(x,y);
				pointList.add(pc);
			}
			Collections.sort(pointList,new PointConevexSort());
			convexHull.convexHullProblem(pointList,number_of_point);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void convexHullProblem(ArrayList<PointConvex> list,int n){
		try{
			Stack<PointConvex> st = new Stack<PointConvex>();
			int minY = 0;
			int minX = 0;
			int i=0;
			int y=0;
			minY = list.get(0).getY();
			for(i=1;i<list.size();i++){
				y=list.get(i).getY();
				if((y<minY)||(y==minY&&list.get(minX).getX()>list.get(i).getX())){
					minY = y;
					minX = i;
				}
			}
			PointConvex p =list.get(minX);
			list.set(1,list.get(0));
			list.set(0,p);
			st.push(list.get(0));
			st.push(list.get(1));
			st.push(list.get(2));
			for(int j=3;j<n;j++){
				while(oreintation(nextToTopOfStack(st),st.peek(),list.get(j))!=2){
					st.pop();
				}
				st.push(list.get(j));
			}
			while(!st.isEmpty()){
				PointConvex p2 = st.pop();
				System.out.println("("+p2.getX()+","+p2.getY()+")");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private PointConvex nextToTopOfStack(Stack<PointConvex> st){
		try{
			PointConvex p = st.peek();st.pop();
			PointConvex nextToTop = st.peek();
			st.push(p);
			return nextToTop;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	private int oreintation(PointConvex p1,PointConvex p2,PointConvex p3){
		try{
			int val = ((p2.getY()-p1.getY())*(p3.getX()-p2.getX()))-((p3.getY()-p2.getY())*(p2.getX()-p1.getX()));
			if(val==0){
				return 0;
			}
			return val>0?1:2;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	
}


class PointConvex
{
	private int x;
	private int y;
	public PointConvex(int x,int y){
		this.x=x;
		this.y = y;
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

class PointConevexSort implements Comparator<PointConvex>{

	@Override
	public int compare(PointConvex o1, PointConvex o2) {
		// TODO Auto-generated method stub
		return o1.getX()-o2.getX();
	}
	
}