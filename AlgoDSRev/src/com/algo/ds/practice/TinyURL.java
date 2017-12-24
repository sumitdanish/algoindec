package com.algo.ds.practice;

import java.util.*;

public class TinyURL {
	char[] table = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
			'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
			'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
			'Z' };

	public String getShortenedUrl(String url) {
		return convert_10base_to_62base(getIdFromDB());
	}

	public String convert_10base_to_62base(long n) {
		StringBuilder sb = new StringBuilder();
		if (n == 0)
			sb.append(0);
		System.out.println(n);
		while (n > 0) {
			sb.insert(0, table[(int) n % 62]);
			n = n / 62;
		}
		System.out.println(sb);
		return sb.toString();
	}

	public int getIdFromDB() {
		Random r = new Random();
		return r.nextInt(1000000);
	}

	public static void main(String[] args) {
		TinyURL u = new TinyURL();
		u.getShortenedUrl("htt://www.google.com");
	}
}
