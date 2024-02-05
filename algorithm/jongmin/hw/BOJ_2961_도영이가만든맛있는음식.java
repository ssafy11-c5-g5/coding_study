package edu.ssafy.hw.hw240201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {

	static int[] sours;
	static int[] bitters;
	static int N;
	static int minVal = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		sours = new int[N];
		bitters = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			sours[i] = Integer.parseInt(st.nextToken());
			bitters[i] = Integer.parseInt(st.nextToken());
		}
		comb(1, 0, 0);
		System.out.println(minVal);
	}
	
	private static void comb(int sourSum, int bitterSum, int r) {
		if (bitterSum != 0) {
			minVal = Math.min(Math.abs(sourSum-bitterSum), minVal);
		}
		
		if(r >= N) {
			return;
		}
		
		comb(sourSum*sours[r], bitterSum+bitters[r], r+1);
		comb(sourSum, bitterSum, r+1);
	}
}
