package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	static int N,M,ans=Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] v;
 	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		v = new boolean[N+1][M+1];
		
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int c = 1; c <= M; c++) {
				map[r][c] = str.charAt(c-1) - '0';
			}
		}
		
//		bfs();
		v[1][1] = true;
		dfs(1,1,1);
		System.out.println(ans);
	}
	
	private static void dfs(int r, int c,int cnt) {
		if (r == N && c == M) {
			ans = Math.min(ans, cnt);
			return;
		}

		for (int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=1&&nr<=N&&nc>=0&&nc<=M&&!v[nr][nc]&&map[nr][nc] == 1) {
				v[nr][nc] = true;
				dfs(nr,nc,cnt+1);
				v[nr][nc] = false;
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
	}
	
	

	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(1,1));
		v[1][1] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int r = now.r;
			int c = now.c;
			
			for (int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr>=1&&nr<=N&&nc>=0&&nc<=M&&map[nr][nc]>=1&&!v[nr][nc]) {
					v[nr][nc] = true;
					map[nr][nc] = map[r][c] + 1;
					q.add(new Point(nr,nc));
				}
			}
			
		}
		System.out.println(map[N][M]);
	}

}
