package com.ssafy.algorithm.swea;

import java.util.Scanner;

public class 가랏RC카 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int curSpd = 0;
			int dis = 0;
			
			for (int i = 0; i < N; i++) {
				int a = sc.nextInt();
				if (a == 0) {
					dis += curSpd;
					continue;
				}
				int b = sc.nextInt();
				
				if (a == 1) {
					curSpd += b;
				} else if(a == 2) {
					if (curSpd - b < 0) {
						curSpd = 0;
					} else {
						curSpd -= b;	
					}
				}
				
				dis += curSpd;
			}
			
			System.out.println("#"+tc+" "+dis);
		}

	}

}
