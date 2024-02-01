package edu.ssafy.hw.hw240201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12891_DNA비밀번호 {
	
	static int S;
	static int P;
	static char[] dnaString;
	static int ans = 0;
	
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		dnaString = br.readLine().toCharArray();
		
		// A C G T
		int[] minArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		countDNA(S, minArr, new int[4]);
		
		System.out.println(ans);
	}
	
	private static void countDNA(int n, int[] minArr, int[] countArr) {
		for(int i = 0; i < P; i++) {
			countArr = count(countArr, 1, dnaString[i]);
		}
		if (check(minArr, countArr)) {
			ans++;
		}
		
		for(int i = P-1; i < S-1; i++) {
			countArr = count(countArr, -1, dnaString[i-P+1]);
			countArr = count(countArr, 1, dnaString[i+1]);

			if (check(minArr, countArr)) {
				ans++;
			}
		}
	}
	
	private static int[] count(int[] countArr, int num, char ch) {
		switch(ch) {
		case 'A':
			countArr[0]+=num;
			break;
		case 'C':
			countArr[1]+=num;
			break;
		case 'G':
			countArr[2]+=num;
			break;
		case 'T':
			countArr[3]+=num;
			break;
		}
		
		return countArr;
	}
	
	private static boolean check(int[] minArr, int[] countArr) {
		for(int i = 0; i < 4; i++) {
			if(minArr[i] > countArr[i]) {
				return false;
			}
		}
		
		return true;
	}
}
