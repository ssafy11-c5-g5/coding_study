package com.ssafy.algorithm.swea;

import java.util.Scanner;

public class 달팽이숫자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int row = 0;
			int col = -1;
			
			int num = 1;
			
			int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
			int d = 0;
			
			while(true) {
				int nRow = row + delta[d][0];
				int nCol = col + delta[d][1];
				
				if (nRow >= 0 && nCol >= 0 && nRow < N && nCol < N && map[nRow][nCol] == 0) {
					map[nRow][nCol] = num++;
					row = nRow;
					col = nCol;
				} else {
					d++;
					if(d == 4) {
						d-=4;
					}
				}
				
				if (num > N*N) {
					break;
				}
			}

			System.out.println("#" + tc);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
