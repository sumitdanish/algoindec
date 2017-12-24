package com.algo.ds.practice.TreePractice;

import java.io.File;
import java.util.Scanner;

public class PrintLCA1 {

	/**
	 * @param args
	 */
	
	static boolean v1;
	static boolean v2;
	public static void main(String[] args) {
		try{
			PrintLCA1 p1 = new PrintLCA1();
			Scanner sc = new Scanner(new File("tree.txt"));
			LCATree root = null;
			String[] s = sc.next().split(",");
			for(String a:s){
				int data = Integer.parseInt(a);
				root = p1.createLcaTree(root, data);
			}
			int key1=15;
			int key2 = 14;
			LCATree lca = p1.printLCA(root, key1, key2);
			System.out.println(lca.getData());
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private boolean findKey(LCATree root,int key){
		try{
			
			if(root==null){
				return false;
			}
			if(root.getData()==key||findKey(root.getLeft(),key)||findKey(root.getRight(),key)){
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private LCATree printLCA(LCATree root,int key1,int key2){
		try{
			LCATree lca = getLCA(root, key1, key2);
			if(v1&&v2){
				return lca;
			}else if(v1&&findKey(lca, key2)){
				return getLCA(lca, key1, key2);
			}else if(v2&&findKey(lca, key1)){
				return getLCA(lca,key1, key2);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private LCATree getLCA(LCATree root,int key1,int key2){
		try{
			if(root==null){
				return null;
			}
			if(root.getData()==key1){
				v1=true;
				return root;
			}
			if(root.getData()==key2){
				v2=true;
				return root;
			}
			LCATree lca = getLCA(root.getLeft(), key1, key2);
			LCATree rca = getLCA(root.getRight(), key1, key2);
			if(lca!=null&&rca!=null){
				return root; 
			}
			return lca!=null?lca:rca;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	private LCATree createLcaTree(LCATree root,int data){
		try{
			if(root==null){
				root=  new LCATree(data);
				return root;
			}
			if(data>root.getData()){
				root.setRight(createLcaTree(root.getRight(), data));
			}else{
				root.setLeft(createLcaTree(root.getLeft(), data));
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
}
class LCATree
{
	private int data;
	private LCATree left;
	private LCATree right;
	public LCATree(int data){
		this.data = data;
	}
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	public void setLeft(LCATree left){
		this.left = left;
	}
	
	public void setRight(LCATree right){
		this.right = right;
	}
	
	public LCATree getLeft(){
		return left;
	}
	public LCATree getRight(){
		return right;
	}
}