package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class IntervalTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("interval.txt"));
			IntervalTree inter = new IntervalTree();
			IntervalTreeOp root =null;
			while(sc.hasNext()){
				String[] s = sc.next().split("_");
				int start = Integer.parseInt(s[0]);
				int end = Integer.parseInt(s[1]);
				Interval interval = new Interval(start,end);
				root=inter.createInterval(interval, root);
			}
			//inter.inOrderPrint(root);
			Interval in = new Interval(6, 7);
			Interval in1=inter.getOverlaped(root, in);
			if((in1)!=null){
				System.out.println(in1.getStart()+" > "+in1.getEnd());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	public void inOrderPrint(IntervalTreeOp interval){
		if(interval!=null){
			inOrderPrint(interval.getLeft());
			System.out.println("("+interval.getInterval().getStart()+","+interval.getInterval().getEnd()+")"+"-->"+interval.getMaxVal());
			inOrderPrint(interval.getRight());;
		}
	}
	public boolean isOverlaped(Interval in1,Interval in2){
		try{
			if(in1.getStart()<=in2.getEnd()&&in1.getEnd()>=in2.getStart()){
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	public Interval getOverlaped(IntervalTreeOp root,Interval in){
		try{
			if(root==null){
				return null;
			}
			if(isOverlaped(root.getInterval(), in)){
				return root.getInterval();
			}
			if(root.getLeft()!=null&&root.getLeft().getMaxVal()>=in.getStart()){
				return getOverlaped(root.getLeft(), in);
			}
			return getOverlaped(root.getRight(), in);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	private IntervalTreeOp createInterval(Interval interval,IntervalTreeOp root){
		try{
			if(root==null){
				root = new IntervalTreeOp(interval);
				return root;
			}
			Interval i = root.getInterval();
			if(i.getStart()>interval.getStart()){
				root.setLeft(createInterval(interval, root.getLeft()));
			}else{
				root.setRight(createInterval(interval, root.getRight()));
			}
			if(interval.getEnd()>root.getMaxVal()){
				root.setMaxVal(interval.getEnd());
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
class IntervalTreeOp
{
	private Interval interval;
	private int maxVal;
	private IntervalTreeOp left;
	private IntervalTreeOp right;
	
	public IntervalTreeOp(Interval interval){
		this.interval = interval;
	}
	public void setInterval(Interval interval){
		this.interval = interval;
	}
	public void setLeft(IntervalTreeOp left){
		this.left = left;
	}
	public void setRight(IntervalTreeOp right){
		this.right = right;
	}
	public Interval getInterval(){
		return interval;
	}
	public IntervalTreeOp getLeft(){
		return left;
	}
	public IntervalTreeOp getRight(){
		return right;
	}
	public void setMaxVal(int maxVal){
		this.maxVal = maxVal;
	}
	public int getMaxVal(){
		return maxVal;
	}
}
class Interval
{
	private int start;
	private int end;
	
	public Interval(int start,int end){
		this.start = start;
		this.end = end;
	}
	public void setStart(int start){
		this.start = start;
	}
	public void setEnd(int end){
		this.end = end;
	}
	
	public int getStart(){
		return start;
	}
	public int getEnd(){
		return end;
	}
	
}