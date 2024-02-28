package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1861_정사각형방 {
	static int T, N, maxRoom, point;
	static int[][] map;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N+2][N+2];
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			maxRoom = Integer.MIN_VALUE;
			point = Integer.MAX_VALUE;
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					dfs(r, c, 1);
				}
			}
			System.out.println("#" + t + " " + point + " " + maxRoom);
		}
	}
	private static void dfs(int r, int c, int cnt) {
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(map[nr][nc] - map[r][c] == 1) {
				dfs(nr, nc, cnt+1);
			}
		}
		if(cnt > maxRoom) {
			maxRoom = cnt;
			point = map[r][c] - cnt + 1;
		} else if(maxRoom == cnt) {
			point = Math.min(point, map[r][c] - cnt + 1);
		}
	}

}
