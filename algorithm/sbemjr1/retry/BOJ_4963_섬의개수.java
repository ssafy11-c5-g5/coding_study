package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	static int W,H,k,map[][];
	static boolean v[][];
	
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if (W == 0 && H == 0) {
				break;
			}
			
			map = new int[H+2][W+2]; // 경계선 체크 안해도 됨
			v = new boolean[H+2][W+2];
			k = 0;
			
			for (int r = 1; r <= H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 1; c <= W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int r = 1; r <= H; r++) {
				for (int c = 1; c <= W; c++) {
					if (!v[r][c] && map[r][c] == 1) {
//						bfs(r,c);
						v[r][c] = true;
						dfs(r,c);
						k++;
					}
				}
			}
		
			System.out.println(k);
		}
	}
	
	private static void dfs(int r, int c) {
		
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (map[nr][nc] == 1 && !v[nr][nc]) {
				v[nr][nc] = true;
				dfs(nr,nc);
			}
		}
	}

	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
		
	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(r,c));
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int nowR = now.r;
			int nowC = now.c;
			
			for (int d = 0; d < 8; d++) {
				int nextR = nowR + dr[d];
				int nextC = nowC + dc[d];
				
				if(map[nextR][nextC] == 1 && !v[nextR][nextC]) {
					v[nextR][nextC] = true;
					q.add(new Point(nextR,nextC));
				}
			}
		}
	}
	
	

}
