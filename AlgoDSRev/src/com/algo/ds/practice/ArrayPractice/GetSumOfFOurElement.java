package com.algo.ds.practice.ArrayPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GetSumOfFOurElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[] arr = { 10, 20, 30, 40, 1, 2 };
			int key = 91;
			new GetSumOfFOurElement().calculateSum(arr, key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void calculateSum(int[] a, int key) {
		try {
			ArrayList<ABC> arr = new ArrayList<ABC>();
			for (int i = 0; i < a.length - 1; i++) {
				for (int j = i + 1; j < a.length; j++) {
					int sum = a[i] + a[j];
					ABC ab = new ABC(a[i], a[j], sum);
					arr.add(ab);
				}
			}
			Collections.sort(arr, new ABCSort());
			int i = 0;
			int j = arr.size() - 1;
			while (i < arr.size() && j >= 0) {

				if (((arr.get(i).getSum() + arr.get(j).getSum()) == key)
						&& (isCommon(arr.get(i), arr.get(j)))) {
					System.out.println("First > " + arr.get(i).getFirst()
							+ "--Second > " + arr.get(i).getSecond()
							+ "First > " + arr.get(j).getFirst()
							+ "--Second > " + arr.get(j).getSecond());
					i++;
					j--;
				} else if ((arr.get(i).getSum() + arr.get(j).getSum()) < key) {
					i++;
				} else {
					j--;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean isCommon(ABC abc, ABC abc1) {
		try {
			if (abc.getFirst() == abc1.getFirst()
					|| abc.getSecond() == abc1.getSecond()
					|| abc.getSecond() == abc.getFirst()
					|| abc.getFirst() == abc1.getSecond()) {
				return false;
			}
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	class ABCSort implements Comparator<ABC> {

		@Override
		public int compare(ABC arg0, ABC arg1) {
			// TODO Auto-generated method stub
			return arg0.getSum() - arg1.getSum();
		}

	}

	class ABC {
		int first = 0;
		int second = 0;
		int sum = 0;

		public ABC(int first, int second, int sum) {
			super();
			this.first = first;
			this.second = second;
			this.sum = sum;
		}

		public int getFirst() {
			return first;
		}

		public void setFirst(int first) {
			this.first = first;
		}

		public int getSecond() {
			return second;
		}

		public void setSecond(int second) {
			this.second = second;
		}

		public int getSum() {
			return sum;
		}

		public void setSum(int sum) {
			this.sum = sum;
		}

	}

}
