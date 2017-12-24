package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class FullBinryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			Scanner sc= new Scanner(new File("tree.txt"));
			FullBinryTree fb = new FullBinryTree();
			String[] st = sc.next().split(",");
			FullTree root = null;
			for(String s : st){
				int data = Integer.parseInt(s);
				root = fb.createTree(root, data);
			}
			fb.inOrder(root);
			boolean b = fb.isFullTree(root);
			if(b){
				System.out.println("Yes it is");
			}else{
				System.out.println("Try again !");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void inOrder(FullTree root){
		if(root!=null){
			inOrder(root.getLeft());
			System.out.print(root.getData()+",");
			inOrder(root.getRihgt());
		}
	}
	
	
	public boolean isFullTree(FullTree root){
		try{
			if(root==null){
				return true;
			}
			if(root.getLeft()==null&&root.getRihgt()==null){
				return true;
			}
			if(root.getLeft()!=null&&root.getRihgt()!=null){
				return (isFullTree(root.getLeft())&&isFullTree(root.getRihgt()));
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	public FullTree createTree(FullTree root,int data){
		try{
			if(root==null){
				root = new FullTree(data);
				return root;
			}
			if(data<root.getData()){
				root.setLeft(createTree(root.getLeft(), data));
			}else{
				root.setRight(createTree(root.getRihgt(), data));
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
}
class FullTree
{
	private int data;
	private FullTree left;
	private FullTree right;
	public FullTree(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data=data;
	}
	public void setLeft(FullTree left){
		this.left = left;
	}
	public void setRight(FullTree right){
		this.right = right;
	}
	
	public int getData(){
		return data;
	}
	
	public FullTree getLeft(){
		return left;
	}
	public FullTree getRihgt(){
		return right;
	}
}