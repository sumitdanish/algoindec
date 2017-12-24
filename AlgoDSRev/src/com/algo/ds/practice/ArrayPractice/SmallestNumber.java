package com.algo.ds.practice.ArrayPractice;

public class SmallestNumber {

	/**
	 * @param args
	 *            So, Binary number have one golden rule (2^i)-1 = 2^0 + 2^1 +
	 *            2^2 + ... + 2^(i-1) Weight ith number is 1 + sum of weight of
	 *            0 to i-1 binary elements.
	 * 
	 *            Compare array elements with binary representation of number
	 *            and weight of each element in binary. So, if you have 4-bit
	 *            binary number( same as array with 1,2,4,8 elements ) then you
	 *            can generate upto 2^4-1 = 15 different positive number.
	 * 
	 *            Lets take your array elements as {1,2,4,8,17} if you compare
	 *            it with binary representation then you can generate number 1
	 *            to 15 using first four elements of array. But you can not
	 *            generate 16 because 17-1 != 15 ( 1+ 2+ 4+ 8 ).
	 * 
	 *            If we compare with ' res ' variable then we have res =
	 *            1(initialize result) + a[0] + a[1] + a[2] ... + a[i-1] at any
	 *            point a[i] >= res then you can not generate ' res ' sum value
	 *            since we don't have proper weight.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int[] a = { 1, 1, 1, 1 };
			new SmallestNumber().smallestNum(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void smallestNum(int[] a) {
		try {
			int res = 1;
			for (int i = 0; i < a.length; i++) {
				if (res >= a[i]) {
					res += a[i];
				}
			}
			System.out.println(res);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
