package com.algo.ds.practice.TreePractice;

import java.util.LinkedList;
import java.util.Queue;

import amazon.AllRounds.TreeCreation;

public class MirrorImgaeOfTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			MirrorImgaeOfTree mi = new MirrorImgaeOfTree();
			String fileName = "tree.txt";
			amazon.AllRounds.TreeNode tree = null;
			TreeCreation treeCre = new TreeCreation();
			tree = treeCre.create(fileName);
			treeCre.inOrder(tree);
			System.out.println();
			mi.mirrorImgaeLevel(tree);
			treeCre.inOrder(tree);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	public void mirrorImage(amazon.AllRounds.TreeNode tn){
		try{
			if(tn == null){
				return;
			}
			mirrorImage(tn.getLeft());
			mirrorImage(tn.getRight());
			amazon.AllRounds.TreeNode temp = tn.getRight();
			tn.setRight(tn.getLeft());
			tn.setLeft(temp);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private void mirrorImgaeLevel(amazon.AllRounds.TreeNode tree){
		try{
			Queue<amazon.AllRounds.TreeNode> q = new LinkedList<amazon.AllRounds.TreeNode>();
			amazon.AllRounds.TreeNode tn = tree;
			q.add(tn);
			while(true){
				int n = q.size();
				if(n == 0){
					break;
				}
				while(n > 0){
					tn = q.peek();q.poll();
					amazon.AllRounds.TreeNode temp = null;
					if(tn.getLeft() != null){
						temp = tn.getLeft();
						if(tn.getRight() != null){
							tn.setLeft(tn.getRight());
						}
						q.add(tn.getLeft());
					}
					if(tn.getRight() != null){
						if(temp != null){
							tn.setRight(temp);
						}else if(tn.getLeft() != null){
							tn.setRight(tn.getLeft());
						}
						q.add(tn.getRight());
					}
					n--;
				}
			}
			
			
		}catch(Exception  ex){
			ex.printStackTrace();
		}
	}
}
