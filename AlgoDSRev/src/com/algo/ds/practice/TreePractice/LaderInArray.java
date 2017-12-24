package com.algo.ds.practice.TreePractice;

public class LaderInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {16, 17, 4, 3, 5, 2};
			new LaderInArray().getLadder(a);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	public void getLader(int[] a){
		try{
			boolean flag = false;
			int element = 0;
			for(int i = 0; i <a.length ; i++){
				int j = i+1;
				for(j = i+1; j < a.length ; j++){
					if(a[i] > a[j]){
						element = a[i];
					}else{
						//flag = false;
						break;
					}
				}
				if(i == a.length-1){
					System.out.println("Element > "+a[i]);
				}
				else if(j == a.length){
					System.out.println("Element > "+element);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private void getLadder(int[] a){
		try{
			int temp = a[a.length-1];
			for(int i = a.length-2 ; i>=0; i--){
				if(a[i] > temp){
					temp = a[i];
					System.out.println(temp);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}
