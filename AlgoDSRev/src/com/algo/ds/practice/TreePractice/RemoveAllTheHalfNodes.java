package com.algo.ds.practice.TreePractice;

public class RemoveAllTheHalfNodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			RemoveAllTheHalfNodes re = new RemoveAllTheHalfNodes();
			RemoveHTree tree = new RemoveHTree(2);
			tree.setLeft(new RemoveHTree(7));
			tree.setRight(new RemoveHTree(5));
			tree.getLeft().setRight(new RemoveHTree(6));
			tree.getLeft().getRight().setRight(new RemoveHTree(11));
			tree.getLeft().getRight().setLeft(new RemoveHTree(1));
			tree.getRight().setRight(new RemoveHTree(9));
			tree.getRight().getRight().setLeft(new RemoveHTree(4));
			re.printInior(tree);
			System.out.println();
			RemoveHTree rem = re.getHalfNode(tree);
			re.printInior(rem);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public void printInior(RemoveHTree tree){
		try{
			if(tree != null){
				printInior(tree.getRight());
				System.out.print(tree.getData()+",");
				printInior(tree.getLeft());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	public RemoveHTree getHalfNode(RemoveHTree tree){
		try{
			if(tree == null){
				return null;
			}
			tree.setRight(getHalfNode(tree.getRight()));
			tree.setLeft(getHalfNode(tree.getLeft()));
			if(tree.getLeft() != null && tree.getRight() != null){
				return tree;
			}
			if(tree.getLeft() == null && tree.getRight() != null){
				RemoveHTree newTree = tree.getRight();
				return newTree;
			}
			if(tree.getRight() == null && tree.getLeft() != null){
				RemoveHTree newTree = tree.getLeft();
				return newTree;
			}
			if(tree.getLeft() == null && tree.getRight() == null){
				return tree;
			}
			return tree;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
}
class RemoveHTree
{
	private int data;
	private RemoveHTree left;
	private RemoveHTree right;
	public RemoveHTree(int data){
		this.data = data;
	}
	public void setRight(RemoveHTree right){
		this.right = right;
	}
	public void setLeft(RemoveHTree left){
		this.left = left;
	}
	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return data;
	}
	public RemoveHTree getLeft(){
		return left;
	}
	public RemoveHTree getRight(){
		return right;
	}
}