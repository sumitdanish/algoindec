package amazon.AllRounds;


import amazon.*;

public class BinaryTree {


	public TreeNode createBT(TreeNode tr){
		try{
			tr = new TreeNode(10);
			tr.setLeft(new TreeNode(-2));
			tr.setRight(new TreeNode(6));
			//tr.getLeft().setLeft(new TreeNode(8));
			tr.getLeft().setRight(new TreeNode(-4));
			//tr.getRight().setRight(new TreeNode(5));
			tr.getRight().setLeft(new TreeNode(7));
			return tr;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public void inOrder(TreeNode tree){
		try{
			if(tree != null){
				inOrder(tree.getLeft());
				System.out.print(tree.getData()+",");
				inOrder(tree.getRight());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
