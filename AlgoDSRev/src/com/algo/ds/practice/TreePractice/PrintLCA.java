package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class PrintLCA {

	/**
	 * @param args
	 *It will work if both the key is present
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("tree.txt"));
			PrintLCA p = new PrintLCA();
			String[] s = sc.next().split(",");
			TreeLCA root = null;
			for(String a:s){
				int data = Integer.parseInt(a);
				root=p.createTree(root, data);
			}
			int n1=8;
			int n2 = 14;
			TreeLCA lca = p.getLCA(root, n1, n2);
			System.out.println(" > "+lca.getData());
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private TreeLCA getLCA(TreeLCA root,int n1,int n2){
		try{
			if(root==null){
				return null;
			}
			if(root.getData()==n1||root.getData()==n2){
				return root;
			}
			TreeLCA llca = getLCA(root.getLeft(), n1, n2);
			TreeLCA rca = getLCA(root.getRight(), n1, n2);
			if(llca!=null&&rca!=null){
				return root;
			}
			return llca!=null?llca:rca;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	private TreeLCA createTree(TreeLCA root,int data){
		try{
			if(root==null){
				root = new TreeLCA(data);
				return root;
			}
			if(root.getData()>data){
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
class TreeLCA
{
	private int data;
	private TreeLCA left;
	private TreeLCA right;
	public TreeLCA(int data){
		this.data = data;
	}
	
	public void setLeft(TreeLCA left){
		this.left = left;
	}
	
	public void setRight(TreeLCA right){
		this.right  =right;
	}
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	public TreeLCA getLeft(){
		return left;
	}
	
	public TreeLCA getRight(){
		return right;
	}
}