package imlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWE_2001_파리퇴치 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			int Ans = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = 0;
					if (i + M - 1 >= 0 && i + M - 1 < N && j + M - 1 >= 0 && j + M - 1 < N) {
						for (int r = i; r < i + M; r++) {
							for (int c = j; c < j + M; c++) {
								cnt += map[r][c];
							}
						}
					}
					Ans = Math.max(Ans, cnt);
				}
			}
			System.out.println("#" + t + " " + Ans);
		}
	}

}
