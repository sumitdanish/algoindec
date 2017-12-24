package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class PrintAllRootToLeaf {

	/**
	 * @param args
	 */
	static int totalSum=0;
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			PrintAllRootToLeaf pl = new PrintAllRootToLeaf();
			TreeLeaf root=null;
			for(String s : st){
				int data = Integer.parseInt(s);
				root = pl.createTree(root, data);
			}
			pl.getSumRootToLeaf(root,0);
			System.out.println(totalSum);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void getSumRootToLeaf(TreeLeaf root,int sum){
		try{
			if(root==null){
				return;
			}
			sum=sum*10+root.getData();
			if(root.getLeft()==null&&root.getRight()==null){
				System.out.println("SUM > "+sum);
				totalSum+=sum;
				sum=0;
			}
			getSumRootToLeaf(root.getLeft(), sum);
			getSumRootToLeaf(root.getRight(), sum);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	
	private TreeLeaf createTree(TreeLeaf root,int data){
		try{
			if(root==null){
				root = new TreeLeaf(data);
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
class TreeLeaf
{
	private int data;
	private TreeLeaf left;
	private TreeLeaf right;
	public TreeLeaf(int data){
		this.data = data;
	}
	public void setLeft(TreeLeaf left){
		this.left = left;
	}
	
	public void setRight(TreeLeaf right){
		this.right = right;
	}
	
	public TreeLeaf getLeft(){
		return left;
	}
	
	public TreeLeaf getRight(){
		return right;
	}
	
	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return data;
	}
}