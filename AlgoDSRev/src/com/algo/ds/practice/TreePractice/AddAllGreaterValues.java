package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class AddAllGreaterValues {

	
	static int sum=0;
	public static void main(String[] args)
	{
		try{
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			AddAllGreaterValues ad = new AddAllGreaterValues();
			GreaTree root = null;
			for(String s : st){
				int data = Integer.parseInt(s);
				root = ad.createTree(root, data);
			}
			ad.greaterSum(root);
			ad.inOrder(root);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private void inOrder(GreaTree root){
		if(root!=null){
			inOrder(root.getLeft());
			System.out.print(root.getData()+",");
			inOrder(root.getRight());
		}
	}
	
	
	private void greaterSum(GreaTree root){
		try{
			if(root!=null){
				greaterSum(root.getRight());
				sum+=root.getData();
				root.setData(sum);
				greaterSum(root.getLeft());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private GreaTree createTree(GreaTree root,int data){
		try{
			if(root==null){
				root = new GreaTree(data);
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

class GreaTree{
	private int data;
	private GreaTree left;
	private GreaTree right;
	public GreaTree(int data){
		this.data = data;
	}
	public void setLeft(GreaTree left){
		this.left = left;
	}
	
	public void setRight(GreaTree right){
		this.right = right;
	}
	
	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return data;
	}
	public GreaTree getLeft(){
		return left;
	}
	public GreaTree getRight(){
		return right;
	}
	
}