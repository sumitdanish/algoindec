package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class BinaryTreeToDLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			BinaryTreeToDLL bt = new BinaryTreeToDLL();
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			DLLTree root = null;
			for(String a : st){
				int data = Integer.parseInt(a);
				root = bt.createTree(root, data);
			}
			bt.convertToDLL(root);
		}catch(Exception ex){
			ex.printStackTrace();
			
		}

	}
	private void convertToDLL(DLLTree root){
		try{
			DLLTree dllTree = convertToDLLUtil(root);
			while(dllTree.getLeft()!=null){
				dllTree = dllTree.getLeft();
			}
			while(dllTree!=null){
				System.out.print(dllTree.getData()+",");
				dllTree = dllTree.getRight();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private DLLTree convertToDLLUtil(DLLTree root){
		try{
			if(root==null){
				return null;
			}
			if(root.getLeft()!=null){
				DLLTree left = convertToDLLUtil(root.getLeft());
				for(;left.getRight()!=null;left = left.getRight());
				left.setRight(root);
				root.setLeft(left);
			}
			if(root.getRight()!=null){
				DLLTree right = convertToDLLUtil(root.getRight());
				for(;right.getLeft()!=null;right=right.getLeft());
				right.setLeft(root);
				root.setRight(right);
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private DLLTree createTree(DLLTree root,int data){
		try{
			if(root==null){
				root = new DLLTree(data);
				return root;
			}
			if(data<root.getData()){
				root.setLeft(createTree(root.getLeft(), data));
			}else{
				root.setRight(createTree(root.getRight(),data));
			}
			return root;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
}

class DLLTree
{
	private int data;
	private DLLTree left;
	private DLLTree right;
	
	public DLLTree(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	
	public void setLeft(DLLTree left){
		this.left = left;
	}
	
	public void setRight(DLLTree right){
		this.right = right;
	}
	
	public DLLTree getLeft(){
		return left;
	}
	
	public DLLTree getRight(){
		return right;
	}
}