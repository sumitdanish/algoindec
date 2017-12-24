package com.algo.ds.practice.GeometryAlgo;

import java.io.File;
import java.util.Scanner;

public class CheckPointIsInsideOrOutside {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		try{
			Scanner sc = new Scanner(new File("poly.txt"));
			CheckPointIsInsideOrOutside check = new CheckPointIsInsideOrOutside();
			int n = sc.nextInt();
			String[] s = new String[2];
			//String st = sc.next();
			s = sc.next().split(",");
			//System.out.println(st);
			Point1 point = new Point1(Integer.parseInt(s[0].trim()),Integer.parseInt(s[1].trim()));
			Point1[] points = new Point1[n];
			int i=0;
			while(sc.hasNext()){
				String[] s1 = sc.next().split(",");
				Point1 p = new Point1(Integer.parseInt(s1[0]),Integer.parseInt(s1[1]));
				points[i] = p;
				i++;
			}
			check.checkPoint(n, points, point);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public void checkPoint(int n,Point1[] points,Point1 point){
		try{
			if(isPointInsideThePolygon(n, points, point)){
				System.out.println("Points Lie inside the polygon !");
			}else{
				System.out.println(" !Points Lie inside the polygon !");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
	}
	
	private boolean isLineOnSegment(Point1 p,Point1 q,Point1 r){
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
	
	
	private int orientation(Point1 p,Point1 q,Point1 r){
		try{
			int val = ((r.getX()-q.getX())*(q.getY()-p.getY()))-((r.getY()-q.getY())*(q.getX()-p.getX()));
			if(val==0){
				return 0;
			}
			return val>0?1:2;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private boolean isIntersect(Point1 p1,Point1 q1,Point1 p2,Point1 q2){
		try{
			int o1;int o2;int o3;int o4;
			o1 = orientation(p1,q1,p2);
			o2 = orientation(p1,q1,q2);
			o3 = orientation(p2,q2,p1);
			o4 = orientation(p2,q2,q1);
			
			if(o1!=o2&&o3!=o4){
				System.out.println("O1 > "+o1+" > "+o2+" > "+o3+" > "+o4);
				return true;
			}
			if(o1==0&&isLineOnSegment(p1,p2,q1)==true){
				return true;
			}
			if(o2==0&&isLineOnSegment(p1,q2,q1)==true){
				return true;
			}
			if(o3==0&&isLineOnSegment(p2, p1, q2)==true){
				return true;
			}
			if(o4==0&&isLineOnSegment(p2, q1,q2)==true){
				return true;
			}
			return false;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	
	public boolean isPointInsideThePolygon(int n,Point1[] points,Point1 point){
		try{
			if(n<3){
				return false;
			}
			// We are assuming this point is outside the polygon so that we can connect this point 
			//to the given point which we are going to test for existence inside the polygon
			Point1 p1 = new Point1(1000,point.getY());
			
			int i=0;
			int next=0;
			int count=0;
			do{
				next=(i+1)%n;
				if(isIntersect(points[i],points[next],point,p1)==true){
					if(orientation(points[i],point,points[next])==0){
						return isLineOnSegment(points[i],point,points[next]);
					}
					count++;
				}
				
				i=next;
			}while(i!=0);
			System.out.println(count);
			if(count%2>0){
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	private int getMin(int a,int b){
		try{
			return a>=b?b:a;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private int getMax(int a,int b){
		try{
			return a>=a?a:b;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
}

class Point1
{
	int x;
	int y;
	public Point1(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}