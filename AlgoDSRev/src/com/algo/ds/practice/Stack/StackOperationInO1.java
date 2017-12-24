package com.algo.ds.practice.Stack;

public class StackOperationInO1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			O1Stack st1 = new O1Stack(-1, 10);
			O1Stack st2 = new O1Stack(-1, 10);
			StackOperationInO1 st = new StackOperationInO1();
			st.push(1, st1, st2);
			st.push(4, st1, st2);
			st.push(14, st1, st2);
			st.push(7, st1, st2);
			int m = st.getMin(st2);
			System.out.println(m);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void push(int val, O1Stack st1, O1Stack st2) {
		try {
			if (st1.isEmpty() || st2.isEmpty()) {
				System.out.println("Stack is full !");
			}
			if (st2.getTop() == -1 && st2.getTop() == -1) {
				st2.push(val);
				st1.push(val);
			} else {
				st1.push(val);
				int val1 = st2.getPop();
				st2.push(val1);
				if (val1 < val) {
					st2.push(val1);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int getMin(O1Stack st2) {
		try {
			int x = st2.getPop();
			return x;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}
}
