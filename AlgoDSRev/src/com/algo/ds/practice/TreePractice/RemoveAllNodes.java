package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class RemoveAllNodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			RemoveAllNodes re = new RemoveAllNodes();
			RemoveTree root = null;
			for(String s : st){
				int data = Integer.parseInt(s);
				root = re.createTree(root, data);
			}
			RemoveTree remo = re.removeLeaf(root,0,30);
			re.printNode(remo);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void printNode(RemoveTree root){
		if(root!=null){
			printNode(root.getLeft());
			System.out.print(root.getData()+",");
			printNode(root.getRight());
		}
	}
	
	
	
	private RemoveTree removeLeaf(RemoveTree root,int sum,int k){
		try{
			if(root==null){
				return null;
			}
			int lSum = sum+root.getData();
			int rSum = lSum;
			root.setLeft(removeLeaf(root.getLeft(),lSum,k));
			root.setRight(removeLeaf(root.getRight(),rSum,k));
			if(sum<k){
				root=null;
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	private RemoveTree createTree(RemoveTree root,int data){
		try{
			if(root==null){
				root=  new RemoveTree(data);
				return root;
			}
			if(data>root.getData()){
				root.setRight(createTree(root.getRight(), data));
			}
			if(data<root.getData()){
				root.setLeft(createTree(root.getLeft(), data));
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
}
class RemoveTree
{
	private int data;
	private RemoveTree left;
	private RemoveTree right;
	public RemoveTree(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	public void setLeft(RemoveTree left){
		this.left = left;
	}
	public void setRight(RemoveTree right){
		this.right = right;
	}
	
	public int getData(){
		return data;
	}
	public RemoveTree getLeft(){
		return left;
	}
	public RemoveTree getRight(){
		return right;
	}
}