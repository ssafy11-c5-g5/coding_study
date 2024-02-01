package homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2001_파리퇴치 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int sum;
			int Ans = 0;
			int[][] fly = new int[N][N];
			int[][] snap = new int[M][M];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					fly[r][c] = sc.nextInt();
				}
			}
			
			int[] dr = new int[M];
			int[] dc = new int[M];
			
			for (int i = 0; i < M; i++) {
				dr[i] = i;
				dc[i] = i;
			}
			
			
			
			
			for (int r = 0; r < N-1; r++) {
				for (int c = 0; c < N-1; c++) {
					sum = 0;
					for (int nr = 0; nr < M; nr++) {
						for (int nc = 0; nc < M; nc++) {
							if (r+dr[nr] >= 0 && r+dr[nr] < N  && c+dc[nc] >= 0 && c+dc[nc] < N ) {
								snap[dr[nr]][dc[nc]] =  fly[r+dr[nr]][c+dc[nc]];
								sum += fly[r+dr[nr]][c+dc[nc]];
							}
						}
						
						
					}
//					System.out.println(r + " " + c + " " + sum);
					Ans = Math.max(Ans, sum);
				}
			}
			System.out.println("#" + t + " " + Ans);
		}
	}

}
