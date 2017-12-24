package com.algo.ds.practice.String;

import java.util.ArrayList;

public class TernarySearchTree {

	/**
	 * @param args
	 */
	ArrayList<String> s = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			TernarySearchTree ternaryTree = new TernarySearchTree();
			TernaryNode tr = ternaryTree.insert(null, 0, "cats");
			TernaryNode tr1 = ternaryTree.insert(tr, 0, "bags");
			TernaryNode tr2 = ternaryTree.insert(tr, 0, "basdfgs");
			TernaryNode tr3 = ternaryTree.insert(tr, 0, "basqwewerdfgs");
			TernaryNode tr4 = ternaryTree.insert(tr1, 0, "cup");
			TernaryNode tr5 = ternaryTree.insert(tr2, 0, "aliaba");
			// TernaryNode tr4 = ternaryTree.insert(tr3,0,"wipro");
			//System.out.println(ternaryTree.logestLength(tr5));
			 if(ternaryTree.isPresent(tr3,"cats",0))
			 {
			 System.out.println("Present");
			 }
			 else
			 {
			 System.out.println("Its not");
			 }
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int logestLength(TernaryNode tr) {
		try {
			if (tr == null) {
				return -1;
			}
			return getMax(logestLength(tr.getLeftCHild()), getMax(
					logestLength(tr.getEqual()) + 1, logestLength(tr
							.getRightChild())));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMax(int a, int b) {
		try {
			return a > b ? a : b;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	String word;
	int i = 0;

	private void traverse(TernaryNode tr, String str) {
		try {
			if (tr != null) {
				traverse(tr.getLeftCHild(), str);
				str += String.valueOf(tr.getCh());
				if (tr.isENd()) {
					System.out.print(str + ",");
					// str=new String();
				}
				traverse(tr.getEqual(), str);
				// str = str.substring(0, str.length() - 1);
				traverse(tr.getRightChild(), str);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private boolean isPresent(TernaryNode tr, String str, int pos) {
		try {
			if (tr == null) {
				return false;
			}
			if (pos < str.length() && str.charAt(pos) < tr.getCh()) {
				return isPresent(tr.getLeftCHild(), str, pos);
			}
			if (pos < str.length() && str.charAt(pos) > tr.getCh()) {
				return isPresent(tr.getRightChild(), str, pos);
			} else {
				if (tr.isENd() && pos == str.length() - 1) {
					return true;
				}
				return isPresent(tr.getEqual(), str, pos + 1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private TernaryNode insert(TernaryNode tn, int pos, String word) {
		try {
			if (tn == null) {
				// System.out.println(" > "+word.charAt(pos));
				tn = new TernaryNode(word.charAt(pos), false, null, null, null);
			}
			if (word.charAt(pos) < tn.getCh()) {
				tn.setLeftCHild(insert(tn.getLeftCHild(), pos, word));
			}
			if (word.charAt(pos) > tn.getCh()) {
				tn.setRightChild(insert(tn.getRightChild(), pos, word));
			} else {
				if (pos + 1 < word.length()) {
					tn.setEqual(insert(tn.getEqual(), pos + 1, word));
				} else {
					tn.setENd(true);
				}
			}
			return tn;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	class TernaryNode {
		char ch;
		boolean isENd;
		TernaryNode leftCHild;
		TernaryNode rightChild;
		TernaryNode equal;

		public TernaryNode(char ch, boolean isENd, TernaryNode leftCHild,
				TernaryNode rightChild, TernaryNode equal) {
			super();
			this.ch = ch;
			this.isENd = isENd;
			this.leftCHild = leftCHild;
			this.rightChild = rightChild;
			this.equal = equal;
		}

		public char getCh() {
			return ch;
		}

		public void setCh(char ch) {
			this.ch = ch;
		}

		public boolean isENd() {
			return isENd;
		}

		public void setENd(boolean isENd) {
			this.isENd = isENd;
		}

		public TernaryNode getLeftCHild() {
			return leftCHild;
		}

		public void setLeftCHild(TernaryNode leftCHild) {
			this.leftCHild = leftCHild;
		}

		public TernaryNode getRightChild() {
			return rightChild;
		}

		public void setRightChild(TernaryNode rightChild) {
			this.rightChild = rightChild;
		}

		public TernaryNode getEqual() {
			return equal;
		}

		public void setEqual(TernaryNode equal) {
			this.equal = equal;
		}

	}

}
