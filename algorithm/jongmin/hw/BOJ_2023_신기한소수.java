package edu.ssafy.hw.hw240201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023_신기한소수 {
	
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] startNums = {2, 3, 5, 7};
		
		for(int startNum: startNums) {
			search(1, startNum);
		}
		System.out.println(sb.toString());
		
		System.out.println("end");
	}
	
	private static void search(int depth, int cur) {
		if (!isPrimeNumber(cur)) {
			return;
		}
		if (depth == N) {
			sb.append(cur + "\n");
			return;
		}
		
		for(int i = 1; i < 10; i++) {
			search(depth+1, cur*10 + i);
		}
	}
	
	private static boolean isPrimeNumber(int num) {
		
		for (int i = 2; i < Math.abs(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
