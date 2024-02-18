package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146_다리만들기 {
	static int N, zone, cnt, min, map[][];
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N+2][N+2];
		
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		zone = 2;
		min = Integer.MAX_VALUE;
		
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if(map[r][c] == 1) {
					bfs(r,c);
					zone++;
				}
			}
		}
		
		for (int z = 2; z < zone - 1; z++) {
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if(map[r][c] == z) {
						v = new boolean[N+2][N+2];
						find(r,c,z);
					}
				}
			}
		}
		
		System.out.println(min);
	}
	
	private static void find(int r, int c, int z) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(r,c));
		
		L:while(!q.isEmpty()) {
			Point now = q.poll();
			int nowR = now.r;
			int nowC = now.c;
			
			for (int d = 0; d < 4; d++) {
				int nextR = nowR + dr[d];
				int nextC = nowC + dc[d];
				
				if (nextR >= 1 && nextC >=1 && nextR <=N && nextC <= N && !v[nextR][nextC]) {
					if(map[nextR][nextC] > z) {
						cnt = Math.abs(nextR-r) + Math.abs(nextC - c) - 1;
						min = Math.min(cnt, min);
						break L;
					} else if(map[nextR][nextC] == 0) {
						v[nextR][nextC] = true;
						q.add(new Point(nextR,nextC));
					}
				}
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
		map[r][c] = zone;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int nowR = now.r;
			int nowC = now.c;
			
			for (int d = 0; d < 4; d++) {
				int nextR = nowR + dr[d];
				int nextC = nowC + dc[d];
				
				if(map[nextR][nextC] == 1) {
					map[nextR][nextC] = zone;
					q.add(new Point(nextR,nextC));
				}
			}
		}
	}

}
