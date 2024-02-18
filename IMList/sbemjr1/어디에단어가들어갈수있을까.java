package com.ssafy.algorithm.swea;

import java.util.Scanner;

public class 어디에단어가들어갈수있을까 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int ans = 0;
			
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = 0;
					if ((j == 0 || map[i][j - 1] == 0) && map[i][j] == 1) {
						for (int k = j; k < N; k++) {
							if (map[i][k] == 1) {
								cnt++;
							} else {
								break;
							}
						}
						if (cnt == K) {
							ans++;
//							System.out.println(i+" " +j);
						}
						cnt = 0;
					}
					if ((i == 0 || map[i-1][j] == 0) && map[i][j] == 1) {
						for (int k = i; k < N; k++) {
							if (map[k][j] == 1) {
								cnt++;
							} else {
								break;
							}
						}
						if (cnt == K) {
							ans++;
//							System.out.println(i+" " +j);
						}
						cnt = 0;
					}
				}
			}
			
			System.out.println(ans);
		}
	}

}
