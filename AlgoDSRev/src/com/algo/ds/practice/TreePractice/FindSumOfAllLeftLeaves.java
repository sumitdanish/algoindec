package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class FindSumOfAllLeftLeaves {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		try{
			FindSumOfAllLeftLeaves sum = new FindSumOfAllLeftLeaves();
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			LeftSumTree tree = null;
			for(String a: st){
				int data = Integer.parseInt(a);
				tree = sum.createTree(tree, data);
			}
			int lSum = sum.leftSum(tree);
			System.out.println(lSum);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	
	
	private int leftSum(LeftSumTree tree){
		try{
			
			if(tree==null){
				return 0;
			}
			int res=0;
			if(isLeftLeaf(tree.getLeft())){
				res+=tree.getLeft().getData();
			}else{
				res+=leftSum(tree.getRight());
			}
			res+=leftSum(tree.getLeft());
			return res;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private boolean isLeftLeaf(LeftSumTree tree){
		try{
			if(tree==null){
				return false;
			}
			if(tree.getLeft()==null&&tree.getRight()==null){
				return true;
			}
			return false;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private LeftSumTree createTree(LeftSumTree tree,int data){
		try{
			
			if(tree == null){
				tree = new LeftSumTree(data);
				return tree;
			}
			if(data>tree.getData()){
				tree.setRight(createTree(tree.getRight(),data));
			}else{
				tree.setLeft(createTree(tree.getLeft(),data));
			}
			return tree;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
}

class LeftSumTree
{
	private int data;
	private LeftSumTree left;
	private LeftSumTree right;
	public LeftSumTree(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public void setLeft(LeftSumTree left){
		this.left = left;
	}
	
	public void setRight(LeftSumTree right){
		this.right = right;
	}
	
	public int getData(){
		return data;
	}
	
	public LeftSumTree getLeft(){
		return left;
	}
	
	public LeftSumTree getRight(){
		return right;
	}
}