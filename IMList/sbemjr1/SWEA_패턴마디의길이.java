package com.ssafy.algorithm.swea;

import java.util.Scanner;

public class SWEA_패턴마디의길이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			String result = str.charAt(0) + "";
			
			for (int i = 1; i < str.length(); i++) {
				if(str.charAt(i) == str.charAt(0)) {
					if(result.equals(str.substring(i, i+i))) {
						System.out.println("#"+tc+ " " +result.length());
						break;
					}
				}
				result += str.charAt(i);
			}
		}
	}

}
