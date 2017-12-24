package com.algo.ds.practice.TreePractice;

import java.util.Arrays;

public class PostorderFromInOrderPreOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

	
	private int search(int[] in,int key,int n){
		try{
			for(int i=0;i<n;i++){
				if(in[i]==key){
					return i;
				}
			}
			return -1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private void printPost(int[] in,int[] pre,int n){
		try{
			
			int ind = search(in,pre[0], n);
			if(ind!=0||ind!=-1){
				int[] pre1 = Arrays.copyOfRange(pre,1,pre.length);
				printPost(in, pre1,ind);
			}
			if(ind!=n-1){
				int[] pre1 = Arrays.copyOfRange(pre,ind+1,pre.length);
				int[] in1 = Arrays.copyOfRange(in,ind+1,n);
				printPost(in1, pre1, n-ind-1);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
