package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class KthLargestElementInBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("tree.txt"));
			KthTree tree = null;
			KthLargestElementInBST kth = new KthLargestElementInBST();
			int k = 3;
			String[] st = sc.next().split(",");
			for(String s : st){
				int data = Integer.parseInt(s);
				tree = kth.getTree(tree, data);
			}
			new KthLargestElementInBST().inOrder(tree,0, k);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	
	public void inOrder(KthTree tree,int k,int kth){
		try{
			if(tree == null || k > kth){
				return;
			}
			inOrder(tree.getLeft(), k, kth);
			k++;
			if(tree != null && k == kth-1){
				System.out.println(tree.getData());
				return;
			}
			inOrder(tree.getRight(), k, kth);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	public KthTree getTree(KthTree tree,int data){
		try{
			KthTree node = new KthTree(data);
			if(tree == null){
				tree = node;
				return tree;
			}
			if(data > tree.getData()){
				tree.setRight(getTree(tree.getRight(), data));
			}else if(data < tree.getData()){
				tree.setLeft(getTree(tree.getRight(), data));
			}
			return tree;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
}
class KthTree
{
	private int data;
	private KthTree left;
	private KthTree right;
	public  KthTree(int data){
		this.data = data;
	}
	
	public void setLeft(KthTree left){
		this.left = left;
	}
	public void setRight(KthTree right){
		this.right = right;
	}
	public void setData(int data){
		this.data = data;
	}
	public KthTree getLeft(){
		return left;
	}
	public KthTree getRight(){
		return right;
	}
	public int getData(){
		return data;
	}
	
}