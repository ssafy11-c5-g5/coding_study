package edu.ssafy.recursive.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] numbers = new int[N+1];
		int idx = 1;
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			numbers[idx] = Integer.parseInt(st.nextToken());
			idx++;
		}
		
		//System.out.println(Arrays.toString(makeIntervalSumArr(N, numbers)));
		
		int[] intervalSumArr = makeIntervalSumArr(N, numbers);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			sb.append(calInterValSum(I, J, intervalSumArr) + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static int[] makeIntervalSumArr(int N, int[] numbers) {
		int[] intervalSumArr = new int[N+1];
		intervalSumArr[0] = numbers[0];
		for (int i = 1; i < N+1; i++) {
			intervalSumArr[i] = intervalSumArr[i-1] + numbers[i]; 
		}
		
		
		return intervalSumArr;
	}
	
	private static int calInterValSum(int I, int J, int[] numbers) {
		return numbers[J] - numbers[I-1];
	}
}
