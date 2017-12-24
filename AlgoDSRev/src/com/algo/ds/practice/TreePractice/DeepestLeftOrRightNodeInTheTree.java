package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class DeepestLeftOrRightNodeInTheTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			LeafTree root = null;
			DeepestLeftOrRightNodeInTheTree dl = new DeepestLeftOrRightNodeInTheTree();
			for(String s : st){
				int data = Integer.parseInt(s);
				root = dl.createTree(root, data);
			}
			dl.deepestLeaf(root);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}


	private void deepestLeaf(LeafTree root){
		try{
			Queue<LeafTree> q1 =new LinkedList<LeafTree>();
			Queue<Integer> q2 = new LinkedList<Integer>();
			LeafTree tn = root;
			int lev=0;
			q2.add(lev);
			q1.add(tn);
			LeafTree tn1 = null;
			boolean maxUpdate=false;
			int maxLev = Integer.MIN_VALUE;
			boolean isLeft = false;;
			while(!q1.isEmpty()&&!q2.isEmpty()){

				if(lev>maxLev){
					maxLev = lev;
					maxUpdate = true;
				}else{
					maxUpdate = false;
				}
				if(tn.getLeft()!=null){
					q1.add(tn.getLeft());
					q2.add(lev+1);
					tn1 = tn.getLeft();
					isLeft = true;
				}
				if(tn.getRight()!=null){
					q1.add(tn.getRight());
					q2.add(lev+1);
					isLeft=false;
				}
				tn = q1.peek();q1.poll();
				lev = q2.peek();q2.poll();
				if(isLeft&&!maxUpdate){
					System.out.print(tn1.getData());
					break;
				}
			}



		}catch(Exception ex){
			ex.printStackTrace();
		}
	}



	private LeafTree createTree(LeafTree root,int data){
		try{
			if(root==null){
				root = new LeafTree(data);
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
class LeafTree
{
	private int data;
	private LeafTree left;
	private LeafTree right;

	public LeafTree(int data){
		this.data = data;
	}

	public void setData(int data){
		this.data = data;
	}

	public void setLeft(LeafTree left){
		this.left = left;
	}

	public void setRight(LeafTree right){
		this.right = right;
	}

	public LeafTree getLeft(){
		return left;
	}

	public LeafTree getRight(){
		return right;
	}

	public int getData(){
		return data;
	}
}
