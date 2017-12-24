package com.algo.ds.practice.TreePractice;

import amazon.AllRounds.*;

public class FoldableBinaryTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			FoldableBinaryTrees fb = new FoldableBinaryTrees();
			BinaryTree bt = new BinaryTree();
			amazon.AllRounds.TreeNode tree = null;
			tree = bt.createBT(tree);
			boolean bo = fb.isFoldable1(tree);
			if(bo){
				System.out.println("kjs");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	
	
	public boolean isFoldable1(amazon.AllRounds.TreeNode a){
		try{
			if(a == null){
				return true;
			}
			boolean res = false;
			mirror(a.getLeft());
			res = isSameStructure(a.getLeft(),a.getRight());
			mirror(a.getRight());
			return res;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	
	private boolean isFoldable(amazon.AllRounds.TreeNode a,amazon.AllRounds.TreeNode b){
		try{
			if(a == null && b== null){
				return true;
			}
			if(a == null || b== null){
				return false;
			}
			return (isFoldable(a.getLeft(),b.getRight()) && isFoldable(a.getRight(),b.getLeft()));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	
	public void mirror(amazon.AllRounds.TreeNode tree){
		try{
			if(tree == null){
				return;
			}
			mirror(tree.getLeft());
			mirror(tree.getRight());
			amazon.AllRounds.TreeNode temp = tree.getLeft();
			tree.setLeft(tree.getRight());
			tree.setRight(temp);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public boolean isSameStructure(amazon.AllRounds.TreeNode a,amazon.AllRounds.TreeNode b){
		try{
			if(a == null && b == null){
				return false;
			}
			if(a != null && b!= null){
				return (isSameStructure(a.getLeft(), b.getLeft()) && isSameStructure(a.getRight(),b.getRight()));
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
}
