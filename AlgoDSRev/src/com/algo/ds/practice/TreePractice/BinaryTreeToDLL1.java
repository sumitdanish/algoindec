package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class BinaryTreeToDLL1 {

	/**
	 * @param args
	 */
	static DLLTree1 pre = null;
	public static void main(String[] args) {
		try{
			BinaryTreeToDLL1 bt = new BinaryTreeToDLL1();
			Scanner sc=  new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			DLLTree1 root = null;
			for(String a : st){
				int data = Integer.parseInt(a);
				root = bt.tree(root, data);
			}
			DLLTree1 dll = bt.getTreeToDLL(root);
			bt.printTree(dll);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void printTree(DLLTree1 root){
		try{
			DLLTree1 tree = root;
			while(tree!=null){
				System.out.print(tree.getData()+",");
				tree=tree.getRight();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private DLLTree1 getTreeToDLL(DLLTree1 root){
		try{
			
			fixLeft(root);
			return getDLL(root);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void fixLeft(DLLTree1 root){
		try{
			if(root!=null){
				fixLeft(root.getLeft());
				root.setLeft(pre);
				pre=root;
				fixLeft(root.getRight());
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private DLLTree1 getDLL(DLLTree1 root){
		try{
			
			if(root==null){
				return null;
			}
			while(root!=null&&root.getRight()!=null){
				root = root.getRight();
			}
			while(root!=null&&root.getLeft()!=null){
				pre = root;
				root = root.getLeft();
				root.setRight(pre);
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private DLLTree1 tree(DLLTree1 root,int data){
		try{
			if(root==null){
				root = new DLLTree1(data);
				return root;
			}
			if(data>root.getData()){
				root.setRight(tree(root.getRight(),data));
			}else{
				root.setLeft(tree(root.getLeft(),data));
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
}

class DLLTree1
{
	private int data;
	private DLLTree1 left;
	private DLLTree1 right;
	public DLLTree1(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public void setLeft(DLLTree1 left){
		this.left = left;
	}
	
	public void setRight(DLLTree1 right){
		this.right = right;
	}
	
	
	public int getData(){
		return  data;
	}
	
	public DLLTree1 getLeft(){
		return left;
	}
	
	public DLLTree1 getRight(){
		return right;
	}
}