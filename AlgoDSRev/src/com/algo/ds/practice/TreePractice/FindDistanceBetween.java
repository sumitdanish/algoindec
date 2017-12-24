package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class FindDistanceBetween {

	/**
	 * @param args
	 */
	
	static int d1=-1;
	static int d2=-1;
	static int dist=-1;
	public static void main(String[] args) {
		
		try{
			FindDistanceBetween f = new FindDistanceBetween();
			Scanner sc = new Scanner(new File("tree.txt"));
			DistTree root = null;
			String[] s = sc.next().split(",");
			for(String a : s){
				int data = Integer.parseInt(a);
				root=f.createTree(data, root);
			}
			int k1=8;
			int k2=13;
			int di  = f.distance(root, k1, k2);
			System.out.println(di);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int getLevel(DistTree root,int lev,int key){
		try{
			if(root==null){
				return -1;
			}
			if(root.getData()==key){
				return lev;
			}
			int le = getLevel(root.getLeft(),lev+1,key);
			if(le!=-1){
				return le;
			}
			return getLevel(root.getRight(), lev+1, key);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private DistTree findLCA(DistTree root,int k1,int k2,int lev){
		try{
			if(root==null){
				return null;
			}
			if(root.getData()==k1){
				d1=lev;
				return root;
			}
			if(root.getData()==k2){
				d2=lev;
				return root;
			}
			DistTree lca = findLCA(root.getLeft(),k1,k2,lev+1);
			DistTree rca = findLCA(root.getRight(),k1,k2,lev+1);
			if(lca!=null&&rca!=null){
				dist = d1+d2-2*lev;
				return root;
			}
			return lca!=null?lca:rca;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
		
	}
	
	
	private int distance(DistTree root,int k1,int k2){
		try{
			DistTree lca = findLCA(root, k1, k2,1);
			if(d1!=-1&&d2!=-1){
				return dist;
			}
			if(d1!=-1){
				dist = getLevel(lca,1,k2);
				return dist;
			}
			if(d2!=-1){
				dist = getLevel(lca,1, k1);
				return dist;
			}
			return -1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	
	private DistTree createTree(int data,DistTree root){
		try{
			if(root == null){
				root = new DistTree(data);
				return root;
			}
			if(data<root.getData()){
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
class DistTree
{
	private int data;
	private DistTree left;
	private DistTree right;
	public DistTree(int data){
		this.data = data;
	}
	public void setRight(DistTree right){
		this.right  =right;
	}
	public void setLeft(DistTree left){
		this.left = left;
	}
	public void setData(int data){
		this.data = data;
	}
	public DistTree getLeft(){
		return left;
	}
	public DistTree getRight(){
		return right;
	}
	public int getData(){
		return data;
	}
}