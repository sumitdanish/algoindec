package com.algo.ds.practice.Genral;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class RailwayBusStationProblem {

	/**
	 * @param args
	 * 
	 *            int.txt 18.00,20.00 9.00,9.10 9.50,11.20 11.00,11.30
	 *            15.00,19.00 9.40,12.00 Complexity-->O(NlogN)
	 * 
	 *            SOrt according to start time and finding total number of
	 *            overlapping interval
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("int.txt"));
			ArrayList<Interval> arr = new ArrayList<Interval>();
			while (sc.hasNext()) {
				String[] s = sc.next().split(",");
				Double st = Double.parseDouble(s[0]);
				Double en = Double.parseDouble(s[1]);
				Interval i = new Interval(st, en);
				arr.add(i);
			}
			RailwayBusStationProblem r = new RailwayBusStationProblem();
			int j = r.getMinPlatform(arr);
			System.out.println(j);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public RailwayBusStationProblem() {

	}

	private int getMinPlatform(ArrayList<Interval> arrayList) {
		try {
			Collections.sort(arrayList, new SortInterval());
			int j = 0;
			Stack<Interval> st = new Stack<Interval>();
			st.push(arrayList.get(0));
			for (int i = 1; i < arrayList.size(); i++) {
				Interval in = st.pop();
				Interval i2 = arrayList.get(i);
				if (in.getStartInterval() < i2.getEndInterval()
						&& in.getEndInterval() > i2.getStartInterval()) {
					j++;
				}
				st.push(i2);
			}
			return j;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}
}

class Interval {
	private double startInterval;
	private double endInterval;

	public Interval(double startInterval, double endInterval) {
		this.startInterval = startInterval;
		this.endInterval = endInterval;
	}

	public double getStartInterval() {
		return startInterval;
	}

	public void setStartInterval(double startInterval) {
		this.startInterval = startInterval;
	}

	public double getEndInterval() {
		return endInterval;
	}

	public void setEndInterval(double endInterval) {
		this.endInterval = endInterval;
	}
}

class SortInterval implements Comparator<Interval> {

	@Override
	public int compare(Interval o1, Interval o2) {
		return (int) (o1.getStartInterval() - o2.getStartInterval());
	}

}