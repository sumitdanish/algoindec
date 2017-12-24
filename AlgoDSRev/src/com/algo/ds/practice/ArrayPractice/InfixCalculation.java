package com.algo.ds.practice.ArrayPractice;

import java.util.Stack;

public class InfixCalculation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String st = "100 * 2 + 12";
			int re = new InfixCalculation().getCal(st.toCharArray());
			System.out.println(re);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private int getCal(char[] exp){
		try{
			Stack<Integer> st = new Stack<Integer>();
			Stack<Character>  st1 = new Stack<Character>();
			for(int i=0;i< exp.length;i++){
				if(exp[i] == ' '){
					continue;
				}
				if(exp[i] >= '0' && exp[i] <= '9'){
					StringBuilder sb = new StringBuilder();
					while(i < exp.length && exp[i] >='0' && exp[i]<= '9'){
						sb = sb.append(exp[i]);
						i++;
					}
					if(sb!=null){
						st.push(Integer.parseInt(sb.toString()));
					}
				}else if(exp[i] == '('){
					st1.push(exp[i]);
				}else{
					if(exp[i] == ')'){
						while(!st1.isEmpty() && st1.peek()!='('){
							st.push(result(st1.pop(),st.pop(),st.pop()));
						}
						st1.pop();
					}else if(isOperand(exp[i])){
						/*If the input operand have more preference compare than operand which is already in the 
						 * stack then we will pick top operand from the stack we will do operation according into
						 *  operand
						 * */
						while(!st1.isEmpty() && isPrefernce(exp[i],st1.peek())){
							st.push(result(st1.pop(),st.pop(),st.pop()));
						}
						st1.push(exp[i]);
					}
				}
			}
			while(!st1.isEmpty()){
				st.push(result(st1.pop(),st.pop(),st.pop()));
			}
			return st.pop();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private boolean isPrefernce(char op1,char op2){
		try{
			if(op2 == ')' || op2 == '('){
				return false;
			}
			if((op1 == '*' || op1 == '/') && (op1 == '+' || op1 == '-')){
				return false;
			}
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private int result(char operand,int op1,int op2){
		try{
			
			if(operand == '+'){
				return (op1+op2);
			}
			if(operand == '-'){
				return (op1-op2);
			}
			if(operand == '*'){
				return (op1 * op2);
			}
			if(operand == '/'){
				return (op1/op2);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	private boolean isOperand(char ope){
		try{
			if(ope == '+' || ope == '-' || ope == '*' || ope == '/'){
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
}
