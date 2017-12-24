package com.algo.ds.practice.String;

public class KMPAlgoRevisited {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		try{
			KMPAlgoRevisited kmp = new KMPAlgoRevisited();
			String pattern = "abcabdabc";
			String text = "abcabdabcabdabcabdabdabc";
			kmp.matchPattern(text, pattern);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	private int[] preprocessingTable(String pattern){
		try{
			int i=1;int j=0;int[] b = new int[pattern.length()];
			b[0]=-1;
			for(;i<pattern.length();i++){
				while(j>=0&&pattern.charAt(i)!=pattern.charAt(j)){
					j=b[j];
				}
				j++;
				b[i]=j;
			}
			for (int l = 0; l < b.length; l++) {
				System.out.print(b[l] + ",");
			}
			return b;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void matchPattern(String text,String pattern){
		try{
			int j=0;int i=1;int[] b =preprocessingTable(pattern);
			for(;i<text.length();){
				while(j>=0&&text.charAt(i)!=pattern.charAt(j)){
					j=b[j];
				}
				j++;
				i++;
				if(j==pattern.length()){
					System.out.println("Pattern found at length : "+i);
					//j=b[j];
				}
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}

