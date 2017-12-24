package com.algo.ds.practice.TreePractice;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseAlternateNode {

	/**
	 * @param args
	 */
	static TreeNodeRev root;
	static char[] a;
	//static int ind=0;
	public static void main(String[] args) {
		try{
			ReverseAlternateNode re = new ReverseAlternateNode();
			root = new TreeNodeRev('a');
			root.setLeft(new TreeNodeRev('b'));
			root.setRight(new TreeNodeRev('c'));
			root.getLeft().setLeft(new TreeNodeRev('d'));
			root.getLeft().setRight(new TreeNodeRev('e'));
			root.getRight().setLeft(new TreeNodeRev('f'));
			root.getRight().setRight(new TreeNodeRev('g'));
			root.getLeft().getLeft().setLeft(new TreeNodeRev('h'));
			root.getLeft().getLeft().setRight(new TreeNodeRev('i'));
			root.getLeft().getRight().setLeft(new TreeNodeRev('j'));
			root.getLeft().getRight().setRight(new TreeNodeRev('k'));
			root.getRight().getLeft().setLeft(new TreeNodeRev('l'));
			root.getRight().getLeft().setRight(new TreeNodeRev('m'));
			root.getRight().getRight().setLeft(new TreeNodeRev('n'));
			root.getRight().getRight().setRight(new TreeNodeRev('o'));
			re.reverseAlterNate(root);
			re.inOrderPrint(root);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	
	private void inOrderTraversal(TreeNodeRev root,int lev,char[] a,int ind){
		try{
			if(root==null){
				return;
			}
			inOrderTraversal(root.getLeft(), lev+1,a,ind);
			if(lev%2!=0){
				a[ind] = root.getData();
				ind++;
			}
			inOrderTraversal(root.getRight(), lev+1,a,ind);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void inOrderTraversal1(TreeNodeRev root,int lev,char[] a,int ind){
		try{
			
			if(root==null){
				return;
			}
			inOrderTraversal1(root.getLeft(),lev+1,a,ind);
			if(lev%2!=0){
				root.setData(a[ind]);
			}
			inOrderTraversal1(root.getRight(),lev+1,a,ind);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void reverseAlterNate(TreeNodeRev root){
		try{
			if(root==null){
				return;
			}
			char[] ch = new char[256];
			int ind=0;
			inOrderTraversal(root,0,ch, ind);
			reverse(ch);
			ind=0;
			inOrderTraversal1(root,0,ch, ind);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private void reverse(char[] ch){
		try{
			char temp;
			int i=0;
			int j=ch.length-1;
			while(i<j&&ch[j]!=' '){
				temp = ch[i];
				ch[i] = ch[j];
				ch[j]=temp;
				i++;j--;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	private void inOrderPrint(TreeNodeRev root){
		try{
			if(root!=null){
				inOrderPrint(root.getLeft());
				System.out.print(root.getData()+",");
				inOrderPrint(root.getRight());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
class TreeNodeRev
{
	private char data;
	private TreeNodeRev left;
	private TreeNodeRev right;
	public TreeNodeRev(char data){
		this.data = data;
	}
	public void setLeft(TreeNodeRev left){
		this.left = left;
	}
	public void setRight(TreeNodeRev right){
		this.right = right;
	}
	public TreeNodeRev getLeft(){
		return left;
	}
	public TreeNodeRev getRight(){
		return right;
	}
	public void setData(char data){
		this.data = data;
	}
	public char getData(){
		return data;
	}
}