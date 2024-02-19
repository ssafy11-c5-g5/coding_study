package sbemjr1.BOJ;

import java.util.Scanner;

public class 섬의개수 {
	static int w,h, map[][];
	static boolean[][] v;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	static int Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			Ans = 0;
			if (w == 0 && h == 0) {
				break;
			}
			map = new int[h][w];
			v = new boolean[h][w];
			
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (!v[r][c] && map[r][c] == 1) {
						dfs(r,c);
						Ans+=1;
					}
				}
			}
			System.out.println(Ans);
		}
	}

	private static void dfs(int r, int c) {
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 지도 경계
			if(nr>=0 && nr < h && nc>=0 && nc < w && map[nr][nc] == 1 && !v[nr][nc]) {
				v[nr][nc] = true;
				dfs(nr,nc);
			}
		}
	}

}
