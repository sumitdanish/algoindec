package com.algo.ds.practice.GeometryAlgo;

import java.io.File;
import java.util.Scanner;

public class IntersectionOfTwoLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			IntersectionOfTwoLine in = new IntersectionOfTwoLine();
			Scanner sc = new Scanner(new File("point.txt"));
			String st=new String();
			String[] s = new String[2];
			st = sc.next();
			System.out.println(st);
			s = st.split(",");
			Point p1 = new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
			st = sc.next();
			System.out.println(st);
			s = st.split(",");
			Point q1 = new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
			st = sc.next();
			System.out.println(st);
			s = st.split(",");
			Point p2 = new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
			st = sc.next();
			System.out.println(st);
			s = st.split(",");
			Point q2 = new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
			if(in.isIntersection(p1, q1, p2, q2)){
				System.out.println("These two line are intersecting!!!!");
			}else{
				System.out.println("These two line are not intersecting!!!");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private boolean isPointOnSegementOnTheLine(Point p,Point q,Point r){
		try{
			if((q.getX()<getMax(p.getX(),r.getX())&&q.getX()>getMin(p.getX(),r.getX()))
				&&(q.getY()<getMax(p.getY(),r.getY())&&q.getY()>getMin(p.getY(),r.getY()))){
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private int lineOrientation(Point p,Point q,Point r){
		try{
			int val = ((q.getY()-p.getY())*(r.getX()-q.getX()))-((r.getY()-q.getY())*(q.getX()-p.getX()));
			
			if(val==0){
				return 0;
			}
			return val>0?1:2;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private boolean isIntersection(Point p1,Point q1,Point p2,Point q2){
		try{
			
			int o1 = lineOrientation(p1, q1, p2);
			System.out.println("o1 > "+o1);
			int o2 = lineOrientation(p1, q1, q2);
			System.out.println("o2 > "+o2);
			int o3 = lineOrientation(p2, q2, p1);
			System.out.println("o3 > "+o3);
			int o4 = lineOrientation(p2, q2, q1);
			System.out.println("o4 > "+o4);
			
			if(o1!=o2&&o3!=o4){
				return true;
			}
			if(o1==0&&isPointOnSegementOnTheLine(p1, p2, q1)==true){
				return true;
			}
			if(o2==0&&isPointOnSegementOnTheLine(p1, q2, q1)==true){
				return true;
			}
			if(o3==0&&isPointOnSegementOnTheLine(p2, p1, q2)==true){
				return true;
			}
			if(o4==0&&isPointOnSegementOnTheLine(p2, q1, q2)==true){
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	
	private int getMin(int x,int y){
		try{
			return x<=y?x:y;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private int getMax(int x,int y){
		try{
			return x>=y?x:y;
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		return -1;
	}
	
}
class Point
{
	private int x;
	private int y;
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
}