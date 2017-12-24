package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SameLevelLeaf {

	/**
	 * tree.txt-->5,3,1,4,10,9,8,11,12,13,14,15,17,18
	 * 		         5
				   /   \
				  3    10
				 / \   / \
				1   4 9  11
				     /     \
				    8	    12
				             \
				              13
				               \
				                14
				                 \
				                  15
				                   \
				                    17
				                     \
				                      18
				                      
	 * @param args
	 */
	static int leftLev=0;
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			SameLevelLeaf same = new SameLevelLeaf();
			SameTree root= null;
			for(String s:st){
				int data = Integer.parseInt(s);
				root=same.create(root, data);
			}
			//same.isSameLevel1(root);
			boolean b = same.isSameLevel1(root);
			if(b){
				System.out.println("Same Level");
			}else{
				System.out.println("!Same level");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void print(SameTree root){
		if(root!=null){
			print(root.getLeft());
			System.out.print(root.getData()+",");
			print(root.getRight());
		}
	}
	
	
	private boolean isSameLevel1(SameTree root){
		try{
			Queue<SameTree>  q = new LinkedList<SameTree>();
			Queue<Integer> q1 = new LinkedList<Integer>();
			SameTree tn=root;
			int lev=0;
			int leftLev=0;
			int rightLev=0;
			q1.add(lev);
			q.add(tn);
			while(!q.isEmpty()&&!q1.isEmpty()){
				tn=q.peek();q.poll();
				lev=q1.peek();q1.poll();
				if(tn.getLeft()!=null){
					q1.add(lev+1);
					q.add(tn.getLeft());
					leftLev=lev;
				}
				if(tn.getRight()!=null){
					q1.add(lev+1);
					q.add(tn.getRight());
					rightLev=lev;
				}
			}
			if(leftLev==rightLev){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	
	public boolean isSameLevel(SameTree root,int lev){
		try{
			if(root==null){
				return true;
			}
			if(root.getLeft()==null&&root.getRight()==null){
				if(leftLev==0){
					leftLev = lev;
					return true;
				}
				return leftLev==lev;
			}
			return (isSameLevel(root.getLeft(), lev+1)&&isSameLevel(root.getRight(), lev+1));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public SameTree create(SameTree root,int data){
		try{
			if(root==null){
				root = new SameTree(data);
				return root;
			}
			if(data>root.getData()){
				root.setRight(create(root.getRight(), data));
			}
			if(data<root.getData()){
				root.setLeft(create(root.getLeft(), data));
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
		
	}
	
}
class SameTree
{
	private int data;
	private SameTree left;
	private SameTree right;
	public SameTree(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	public void setLeft(SameTree left){
		this.left = left;
	}
	public void setRight(SameTree right){
		this.right = right;
	}
	
	public int getData(){
		return data;
	}
	public SameTree getLeft(){
		return left;
	}
	public SameTree getRight(){
		return right;
	}
}