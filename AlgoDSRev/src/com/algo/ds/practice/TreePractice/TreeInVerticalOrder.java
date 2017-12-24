package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class TreeInVerticalOrder {

	/**
	 * @param args
	 *    1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9 
	 */
	static int minHd=Integer.MAX_VALUE;
	static int maxHd = Integer.MIN_VALUE;
	public static void main(String[] args) {
		try{
			Tree1 root=null;
			TreeInVerticalOrder tree = new TreeInVerticalOrder();
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] a = sc.next().split(",");
			for (String s : a) {
				root = tree.createTree(root, Integer.parseInt(s));
			}
			
			tree.maxMinHoriDis(root,0);
			tree.print(root);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	private void print(Tree1 root){
		try{
			for(int i=minHd;i<=maxHd;i++){
				printTree(root,i,0);
				System.out.println();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private void printTree(Tree1 root,int lev,int hd){
		try{
			if(root==null){
				return;
			}
			if(lev==hd){
				System.out.print(root.getData()+",");
			}
			printTree(root.getLeft(),lev,hd-1);
			printTree(root.getRight(),lev,hd+1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private void maxMinHoriDis(Tree1 root,int hd){ // maximum and minimum distance from vertical distancel;
		try{
			if(root==null){
				return;
			}
			if(minHd>=hd){
				minHd=hd;
			}
			if(maxHd<=hd){
				maxHd = hd;
			}
			maxMinHoriDis(root.getLeft(),hd-1);
			maxMinHoriDis(root.getRight(),hd+1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private Tree1 createTree(Tree1 root,int data){
		try{
			if(root==null){
				root= new Tree1(data);
				return root;
			}
			if(root.getData()>data){
				root.setLeft(createTree(root.getLeft(),data));
			}else{
				root.setRight(createTree(root.getRight(),data));
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void inOrder(Tree1 root){
		try{
			if(root!=null){
				inOrder(root.getLeft());
				System.out.print(root.getData()+",");
				inOrder(root.getRight());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
class Tree1
{
	private int data;
	private Tree1 left;
	private Tree1 right;
	public Tree1(int data){
		this.data = data;
	}
	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return data;
	}
	public void setLeft(Tree1 left){
		this.left = left;
	}
	public void setRight(Tree1 right){
		this.right = right;
	}
	public Tree1 getRight(){
		return right;
	}
	public Tree1 getLeft(){
		return left;
	}
}