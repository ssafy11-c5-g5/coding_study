package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기 {
	static class Point {
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	
	static int N,ans,cnt;
	static int[][] map;
	static boolean[][] v;
	static boolean flag;
	
	static int[] dr = {1, 0, -1, 0}; // 상 좌 하 우
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int numberling = 2;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == 1) {
					markNumber(r,c,numberling++); // 구역에 따른 넘버링
				}
			}
		}
		
		v = new boolean[N][N];
		ans = Integer.MAX_VALUE;
		
		for (int i = 2; i < numberling; i++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] == i) {
						v = new boolean[N][N];
						cnt = 0;
						bfs(r,c,i);
					}
				}
			}
		}
		System.out.println(ans);
//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < N; c++) {
//				System.out.print(map[r][c]+" ");
//			}
//			System.out.println();
//		}
	}

	private static void bfs(int r, int c, int num) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(r,c));
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int nowR = p.r;
			int nowC = p.c;
			
			if(map[nowR][nowC] > num) {
				int result = Math.abs(r - nowR) + Math.abs(c - nowC) - 1;
				ans = Math.min(ans, result);
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nextR = nowR + dr[d];
				int nextC = nowC + dc[d];
				
				if(nextR<0 || nextR>=N || nextC<0 || nextC>=N) {
					continue;
				}
				if(v[nextR][nextC]) {
					continue;
				}
				if(map[nextR][nextC] == num) {
					continue;
				}
				v[nextR][nextC] = true;
//				cnt++;
				q.offer(new Point(nextR,nextC));
			}
		}
	}

	private static void markNumber(int r, int c, int num) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(r,c));
		map[r][c] = num;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int nowR = p.r;
			int nowC = p.c;
			
			for (int d = 0; d < 4; d++) {
				int nextR = nowR + dr[d];
				int nextC = nowC + dc[d];
				
				if(nextR<0 || nextR>=N || nextC<0 || nextC>=N) {
					continue;
				}
				if(map[nextR][nextC] != 1) {
					continue;
				}
				map[nextR][nextC] = num;
				q.offer(new Point(nextR,nextC));
			}
		}
	}

}
