package com.algo.ds.practice.TreePractice;

import java.util.Stack;

public class PreorderToBST {

	/**
	 * @param args
	 */
	static int index = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int[] pre = {10, 5, 1, 7, 40, 50};
			PreorderToBST tree = new PreorderToBST();
			//PreBST tr = tree.creTree(pre,0,pre.length-1,index,pre.length-1);
			/*Here we can't take index as argument becz its storing into stack
			 *  and might be it can be increment 
			 * twice with same value so result will come ito diffrent*/
			//PreBST tr = tree.creTree(pre,0,pre.length-1,pre.length-1,0);
			PreBST tr1 = tree.byStack(pre);
			tree.printTree(tr1);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private PreBST creTree(int[] pre,int low,int highe,int size,int x){
		try{
			if(index > size){
				return null;
			}
			PreBST tree = new PreBST(pre[x]);
			index = index+1;
			x++;
			if(low == highe){
				return tree;
			}
			int i = 0;
			for(i = low;i<=highe;i++){
				if(pre[i] > tree.getData()){
					break;
				}
			}
			tree.setLeft(creTree(pre, low,i-1, size,x));
			tree.setRight(creTree(pre,i, highe, size,x));
			return tree;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private PreBST byStack(int[] pre){
		try{
			Stack<PreBST> stack = new Stack<PreBST>();
			PreBST tree = new PreBST(pre[0]);
			stack.push(tree);
			for(int i = 1; i < pre.length ; i++){
				PreBST temp = null;
				while(!stack.isEmpty() && pre[i] > stack.peek().getData()){
					temp = stack.pop();
				}
				if(temp != null){
					PreBST pr = new PreBST(pre[i]);
					temp.setRight(pr);
					stack.push(pr);
				}else{
					stack.peek().setLeft(new PreBST(pre[i]));
					stack.push(stack.peek().getLeft());
				}
			}
			return tree;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private void printTree(PreBST tree){
		if(tree != null){
			printTree(tree.getLeft());
			System.out.print(tree.getData()+",");
			printTree(tree.getRight());
		}
	}
	
	
}


class PreBST
{
	private int data;
	private PreBST left;
	private PreBST right;
	public PreBST(){
		
	}
	public PreBST(int data){
		this.data = data;
	}
	
	public void setLeft(PreBST left){
		this.left = left;
	}
	public void setRight(PreBST right){
		this.right = right;
	}
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	public PreBST getLeft(){
		return left;
	}
	public PreBST getRight(){
		return right;
	}
}