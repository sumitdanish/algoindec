package test;

import java.util.Random;

public class RandomNumber {
 
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int min = 5;
			int max = 9;
			new RandomNumber().getRan(min, max);
			// int ranNum = new RandomNumber().getRandomNumber(min, max);
			// System.out.println(ranNum);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getRan(int min, int max) {
		try {
			Random ran = new Random();
			int n = 9;
			while (n > 0) {
				int ra = ran.nextInt(n--);
				System.out.print(ra + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getRandomNumber(int min, int max) {
		try {
			// Random r = new Random();
			// int range = max-min+1;
			double num = min + (Math.random() * (max - min + 1));
			return (int) num;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
