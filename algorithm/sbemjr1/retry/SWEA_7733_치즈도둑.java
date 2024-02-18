package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7733_치즈도둑 {
	static int T,N,map[][],cnt,ans;
	static boolean v[][];

	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ans=Integer.MIN_VALUE;
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i <= 100; i++) {
				v = new boolean[N][N];
				cnt = 0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if(!v[r][c] && map[r][c] > i) {
							bfs(r,c,i);
							cnt++;
						}
					}
				}
				ans = Math.max(cnt, ans);
			}
			System.out.println("#"+tc+" "+ans);
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

	private static void bfs(int r, int c, int day) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(r,c));
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int nowR = now.r;
			int nowC = now.c;
			
			for (int d = 0; d < 4; d++) {
				int nextR = nowR + dr[d];
				int nextC = nowC + dc[d];
				
				if(nextR>=0&&nextC>=0&&nextR<N&&nextC<N&&!v[nextR][nextC]&&map[nextR][nextC] > day) {
					v[nextR][nextC] = true;
					q.add(new Point(nextR,nextC));
				}
			}
		}
	}

}
