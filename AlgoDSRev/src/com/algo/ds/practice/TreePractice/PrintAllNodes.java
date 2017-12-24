package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class PrintAllNodes {

	/**
	 * @param args
	 * Print all nodes that are at distance k from a leaf node
	 */
	public static void main(String[] args) {
		try{
			PrintAllNodes p = new PrintAllNodes();
			Scanner sc = new Scanner(new File("tree.txt"));
			PrintAllNodeTree root = null;
			String[] s = sc.next().split(",");
			boolean[] visited = new boolean[s.length];
			int[] path = new int[s.length];
			int k=2;
			int i=0;
			for(String s1:s){
				int d = Integer.parseInt(s1);
				root=p.createTree(d, root);
				visited[i]= false;
				i++;
			}
			p.print(root, path,0, k, visited);
			//p.inOrder(root);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private void inOrder(PrintAllNodeTree root){
		try{
			if(root!=null){
				inOrder(root.getLeft());
				System.out.print(root.getData()+",");
				inOrder(root.getRight());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void print(PrintAllNodeTree root,int[] path,int ind,int k,boolean[] visited){
		try{
			if(root==null){
				return;
			}
			path[ind] = root.getData();
			ind++;
			if(root.getLeft()==null&&root.getRight()==null&&ind-k-1>=0&&visited[ind-k-1]==false){
				System.out.print(path[ind-k-1]+",");
				visited[ind-k-1]=true;
			}
			print(root.getLeft(),path,ind,k,visited);
			print(root.getRight(),path,ind,k,visited);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private PrintAllNodeTree createTree(int data,PrintAllNodeTree root){
		try{
			if(root==null){
				root = new PrintAllNodeTree(data);
				return root;
			}
			if(root.getData()>data){
				root.setLeft(createTree(data,root.getLeft()));
			}else{
				root.setRight(createTree(data,root.getRight()));
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}



class PrintAllNodeTree{
	private int data;
	private PrintAllNodeTree left;
	private PrintAllNodeTree right;
	public PrintAllNodeTree(){
		
	}
	public PrintAllNodeTree(int data){
		this.data = data;
	}
	public void setData(int data){
		this.data = data;
	}
	public void setRight(PrintAllNodeTree right){
		this.right = right;
	}
	public void setLeft(PrintAllNodeTree left){
		this.left = left;
	}
	public int getData(){
		return data;
	}
	public PrintAllNodeTree getLeft(){
		return left;
	}
	public PrintAllNodeTree getRight(){
		return right;
	}
}