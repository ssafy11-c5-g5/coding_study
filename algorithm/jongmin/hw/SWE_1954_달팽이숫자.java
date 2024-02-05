package edu.ssafy.recursive.hw;

import java.util.Scanner;

public class SWE_1954_달팽이숫자 {
	
	static int[][] graph;
	static int N;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			graph = new int[N][N];
			makeSnail(0);
			System.out.println("#" + (tc+1));
			printSnail();
		}
	}
	
	
	private static void makeSnail(int dir) {
		int cnt = 1;
		int r = 0;
		int c = 0;
		
		while(cnt <= N*N) {
			while(true) {
				if(r < 0 || r >= N || c < 0 || c >= N || graph[r][c] != 0) {
					r-=dr[dir];
					c-=dc[dir];
					dir = (dir+1) % 4;
					r+=dr[dir];
					c+=dc[dir];
					break;
				}
				graph[r][c] = cnt;
				r+=dr[dir];
				c+=dc[dir];
				cnt++;
			}
		}
	}
	
	private static void printSnail() {
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}
