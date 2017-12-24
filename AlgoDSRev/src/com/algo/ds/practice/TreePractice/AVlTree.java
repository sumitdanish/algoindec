package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class AVlTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			AVlTree avlTree = new AVlTree();
			Scanner sc = new Scanner(new File("avl.txt"));
			String[] st = sc.next().split(",");
			TreeAVL root = null;
			for(String s:st){
				int data = Integer.parseInt(s);
				root = avlTree.insertIntoTree(root, data);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public TreeAVL insertIntoTree(TreeAVL root,int data){
		try{
			if(root==null){
				root = new TreeAVL(data);
				return root;
			}
			if(data>root.getData()){
				root.setRight(insertIntoTree(root.getRight(), data));
			}
			if(data<root.getData()){
				root.setRight(insertIntoTree(root.getLeft(), data));
			}
			root.setHeight(getMax(maxHeight(root.getLeft()),maxHeight(root.getRight()))+1);
			
			int bf = getBalenceFactor(root);
			
			if(root.getLeft()!=null&&bf>1&&data<root.getLeft().getData()){
				return leftRotaion(root);
			}
			if(root.getLeft()!=null&&bf>1&&data>root.getLeft().getData()){
				root.setLeft(leftRotaion(root));
				return rightRotation(root);
			}
			if(root.getRight()!=null&&bf<-1&&data<root.getRight().getData()){
				root.setRight(rightRotation(root));
				return leftRotaion(root);
			}
			if(root.getRight()!=null&&bf<-1&&data>root.getRight().getData()){
				return rightRotation(root);
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	public TreeAVL leftRotaion(TreeAVL root){
		try{
			TreeAVL tn = root.getRight();
			TreeAVL tn1 = tn.getLeft();
			tn.setLeft(root);
			root.setRight(tn1);
			
			tn1.setHeight(getMax(maxHeight(tn1.getLeft()),maxHeight(tn1.getRight()))+1);
			tn.setHeight(getMax(maxHeight(tn.getLeft()),maxHeight(tn.getRight()))+1);
			
			return tn;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public TreeAVL rightRotation(TreeAVL root){
		try{
			
			TreeAVL tn = root.getLeft();
			TreeAVL tn1 = tn.getRight();
			tn.setLeft(root);
			root.setLeft(tn1);
			
			tn1.setHeight(getMax(maxHeight(tn1.getLeft()),maxHeight(tn1.getRight()))+1);
			tn.setHeight(getMax(maxHeight(tn.getLeft()),maxHeight(tn.getRight()))+1);
			return tn;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public int getMax(int a,int b){
		try{
			return a>b?a:b;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	public int maxHeight(TreeAVL root){
		try{
			if(root==null){
				return 0;
			}
			return root.getHeight();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	public int getBalenceFactor(TreeAVL root){
		try{
			if(root==null){
				return 0;
			}
			return (maxHeight(root.getLeft())-maxHeight(root.getRight()));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return Integer.MAX_VALUE;
	}
	
}



class TreeAVL
{
	private int data;
	private int height;
	private TreeAVL left;
	private TreeAVL right;
	public TreeAVL(){
		
	}
	public TreeAVL(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	
	public int getHeight(){
		return height;
	}
	public int getData(){
		return data;
	}
	
	public void setLeft(TreeAVL left){
		this.left = left;
	}
	
	public void setRight(TreeAVL right){
		this.right = right;
	}
	
	public TreeAVL getLeft(){
		return left;
	}
	
	public TreeAVL getRight(){
		return right;
	}
	
	
	
}