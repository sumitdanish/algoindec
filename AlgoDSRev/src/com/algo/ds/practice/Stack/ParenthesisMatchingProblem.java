package com.algo.ds.practice.Stack;

import java.util.Stack;

/*
 * 
 * 
 * “{“,”}”,”(“,”)”,”[“,”]”
 *  are correct in exp. For example, the program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])”
 * 
 * 
 * */


public class ParenthesisMatchingProblem {

	
	public static void main(String[] args){
		try{
			String st = "[()]{}{[(())]()}";
			ParenthesisMatchingProblem par = new ParenthesisMatchingProblem();
			boolean b = par.parenthesis(st.toCharArray());
			if(b){
				System.out.println("matching");
			}else{
				System.out.println("!matching");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private boolean isMatchingParenthesis(char ch1,char ch2){
		try{
			if((ch1=='{'&&ch2=='}')){
				return true;
			}else if((ch1=='['&&ch2==']')){
				return true;
			}else if(ch1=='('&&ch2==')'){
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private boolean parenthesis(char[] ch){
		try{
			Stack<Character> st = new Stack<Character>();
			for(int i=0;i<ch.length;i++){
				if(ch[i]=='{'||ch[i]=='['||ch[i]=='('){
					st.push(ch[i]);
				}
				if(ch[i]=='}'||ch[i]==']'||ch[i]==')'){
					if(st.isEmpty()){
						return false;
					}else if(isMatchingParenthesis(st.pop(), ch[i])==false){
						return false;
					}
				}
			}
			if(st.isEmpty()){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return true;
	}
}
