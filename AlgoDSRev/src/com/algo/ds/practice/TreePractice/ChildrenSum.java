package com.algo.ds.practice.TreePractice;

public class ChildrenSum {

	/**
	 * @param args
	 * 60->50->80->40 
	 */
	static int sum1=0;
	static int sum2=0;
	public static void main(String[] args) {
		try{
			ChildrenSum sh = new ChildrenSum();
			ChildTree cd = new ChildTree(6);
			cd.setRight(new ChildTree(3));
			cd.getRight().setRight(new ChildTree(4));
			cd.getRight().getRight().setLeft(new ChildTree(1));
			cd.getRight().setLeft(new ChildTree(2));
			cd.setLeft(new ChildTree(5));
			cd.getLeft().setLeft(new ChildTree(7));
			sh.inOrder(cd);
			System.out.println();
			sh.sumOfChildren(cd);
			System.out.println();
			sh.inOrder(cd);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private void inOrder(ChildTree root){
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
	
	private void sumOfChildren(ChildTree root){
		try{
			if(root==null){
				return;
			}
			sumOfChildren(root.getLeft());
			sumOfChildren(root.getRight());
			int x=0;
			if(sum1<root.getData()){
				x=root.getData();
				root.setData(sum1);
				sum2 = sum1;
				sum1+=x;
			}else{
				x=root.getData();
				root.setData(sum2);
				sum2+=x;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
class ChildTree
{
	private int data;
	private ChildTree left;
	private ChildTree right;
	
	public ChildTree(int data){
		this.data = data;
	}
	
	public void setLeft(ChildTree left){
		this.left = left;
	}
	
	public void setRight(ChildTree right){
		this.right = right;
	}
	public void setData(int data){
		this.data = data;
	}
	public ChildTree getLeft(){
		return left;
	}
	public ChildTree getRight(){
		return right;
	}
	public int getData(){
		return data;
	}
}