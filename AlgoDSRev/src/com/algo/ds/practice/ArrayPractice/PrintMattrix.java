package com.algo.ds.practice.ArrayPractice;

public class PrintMattrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			int[][] mat = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 },
					{ 27, 29, 37, 48 }, { 32, 33, 39, 50 }, };

			MinHeapImpl mi = new MinHeapImpl();
			mi.printMat(mat, 4);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
