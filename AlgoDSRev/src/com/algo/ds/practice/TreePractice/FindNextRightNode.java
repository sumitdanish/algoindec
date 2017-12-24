package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindNextRightNode {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		try{
			FindNextRightNode right = new FindNextRightNode();
			NextNodeTree root = null;
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			for(String s : st){
				int data = Integer.parseInt(s);
				root=right.createTree(root, data);
			}
			NextNodeTree n = right.getNextRightNode(root,4);
			System.out.println(n.getData());
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private NextNodeTree getNextRightNode(NextNodeTree root,int key){
		try{
			Queue<NextNodeTree> q = new LinkedList<NextNodeTree>();
			NextNodeTree tn = root;
			int n=0;
			q.add(tn);
			while(true){
				n=q.size();
				if(n==0){
					return null;
				}
				while(n>0){
					tn=q.peek();
					q.poll();
					if(q.size()!=0&&tn.getData()==key){
						return q.peek();
					}
					if(tn.getLeft()!=null){
						q.add(tn.getLeft());
					}
					if(tn.getRight()!=null){
						q.add(tn.getRight());
					}
					n--;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private NextNodeTree createTree(NextNodeTree root,int data){
		try{
			if(root==null){
				root = new NextNodeTree(data);
				return root;
			}
			if(data>root.getData()){
				root.setRight(createTree(root.getRight(),data));
			}
			if(data<root.getData()){
				root.setLeft(createTree(root.getLeft(),data));
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
}


class NextNodeTree
{
	private int data;
	private NextNodeTree left;
	private NextNodeTree right;
	public NextNodeTree(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public void setLeft(NextNodeTree left){
		this.left = left;
	}
	
	public void setRight(NextNodeTree right){
		this.right = right;
	}
	
	public int getData(){
		return data;
	}
	
	public NextNodeTree getLeft(){
		return left;
	}
	
	public NextNodeTree getRight(){
		return right;
	}
}