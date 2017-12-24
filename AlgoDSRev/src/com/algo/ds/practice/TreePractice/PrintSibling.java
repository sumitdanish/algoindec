package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class PrintSibling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			PrintSibling p = new PrintSibling();
			SiblingTree root = null;
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] s  =sc.next().split(",");
			for(String a : s){
				int data = Integer.parseInt(a);
				root=  p.createTree(root, data);
			}
			p.printSibling(root);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void printSibling(SiblingTree root){
		try{
			if(root==null){
				return;
			}
			if(root.getLeft()!=null&&root.getRight()!=null){
				printSibling(root.getLeft());
				printSibling(root.getRight());
			}else if(root.getRight()!=null){
				System.out.print(root.getRight().getData()+",");
				printSibling(root.getRight());
			}else if(root.getLeft()!=null){
				System.out.print(root.getLeft().getData()+",");
				printSibling(root.getLeft());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private SiblingTree createTree(SiblingTree root,int data){
		try{
			if(root==null){
				root = new SiblingTree(data);
				return root;
			}
			if(data>root.getData()){
				root.setLeft(createTree(root.getLeft(), data));
			}else if(root.getData()>data){
				root.setRight(createTree(root.getRight(),data));
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
}

class SiblingTree
{
	private int data;
	private SiblingTree left;
	private SiblingTree right;
	
	public SiblingTree(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	public void setLeft(SiblingTree left){
		this.left = left;
	}
	
	public void setRight(SiblingTree right){
		this.right = right;
	}
	
	public SiblingTree getLeft(){
		return left;
	}
	
	public SiblingTree getRight(){
		return right;
	}
}

