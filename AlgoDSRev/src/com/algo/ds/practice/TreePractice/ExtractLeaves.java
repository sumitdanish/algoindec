package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class ExtractLeaves {

	/**
	 * @param args
	 */
	static ExTree headRef=null;
	public static void main(String[] args) {
		
		
		try{
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			ExtractLeaves e = new ExtractLeaves();
			ExTree root = null;
			for(String s : st){
				int data = Integer.parseInt(s);
				root=  e.createTree(root, data);
			}
			ExTree r = e.getExtractedLeaves(root);
			//e.print(r);
			e.printDll(headRef);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	
	private ExTree getExtractedLeaves(ExTree root){
		try{
			if(root==null){
				return root;
			}
			if(root.getLeft()==null&&root.getRight()==null){
				root.setLeft(headRef);
				if(headRef!=null){
					headRef.setRight(root);
				}
				headRef = root;
				return null;
			}
			root.setLeft(getExtractedLeaves(root.getLeft()));
			root.setRight(getExtractedLeaves(root.getRight()));
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private void printDll(ExTree root){
		try{
			ExTree r = root;
			while(r!=null){
				System.out.print(r.getData()+",");
				r = r.getLeft();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private void print(ExTree root){
		if(root!=null){
			print(root.getLeft());
			System.out.print(root.getData()+",");
			print(root.getRight());
		}
	}
	
	private ExTree createTree(ExTree root,int data){
	try{
		if(root==null){
			root = new ExTree(data);
			return root;
		}
		if(data>root.getData()){
			root.setRight(createTree(root.getRight(), data));
		}
		if(root.getData()>data){
			root.setLeft(createTree(root.getLeft(), data));
		}
		return root;
	}catch(Exception ex){
		ex.printStackTrace();
	}
		return null;
	}
}

class ExTree
{
	private int data;
	private ExTree left;
	private ExTree right;
	
	public ExTree(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data  =data;
	}
	public void setLeft(ExTree left){
		this.left = left;
	}
	public void setRight(ExTree right){
		this.right = right;
	}
	public int getData(){
		return data;
	}
	
	public ExTree getLeft(){
		return left;
	}
	
	public ExTree getRight(){
		return right;
	}
	
}