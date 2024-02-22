package sbemjr1.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동_bfs {
	static int N,L,R,map[][],sum,minR,minC,maxR,maxC;
	static boolean v[][];
	static ArrayList<Point> result;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		v = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		int ans = 0;
		while(true) {
			cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!v[r][c]) {
						result = new ArrayList<>();
						sum = 0;
						minR = Integer.MAX_VALUE;
						minC = Integer.MAX_VALUE;
						maxR = Integer.MIN_VALUE;
						maxC = Integer.MIN_VALUE;
						bfs(r,c,map[r][c]);
						// 인구 분배 
						for (int i = 0; i < result.size(); i++) {
							for (int nr = minR; nr <= maxR; nr++) {
								for (int nc = minC; nc <= maxC; nc++) {
									if(nr == result.get(i).r && nc == result.get(i).c) {
										map[nr][nc] = sum / result.size();
									}
								}
							}
						}
						cnt++;
					}
				}
			}
			
			if (cnt == N*N) {
				break;
			}
			ans++;
			v = new boolean[N][N];
		}
		System.out.println(ans);
	}

	private static void bfs(int r, int c, int value) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(r,c,value));
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int nowR = p.r;
			int nowC = p.c;
			
			sum += p.value;
			
			minR = Math.min(nowR, minR);
			minC = Math.min(nowC, minC);
			maxR = Math.max(nowR, maxR);
			maxC = Math.max(nowC, maxC);
			result.add(new Point(nowR,nowC,map[nowR][nowC]));
			
			for (int d = 0; d < 4; d++) {
				int nextR = nowR + dr[d];
				int nextC = nowC + dc[d];
				
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) {
					continue;
				}
				if (Math.abs(map[nextR][nextC] - map[nowR][nowC]) < L || Math.abs(map[nextR][nextC] - map[nowR][nowC]) > R) {
					continue;
				}
				if (v[nextR][nextC]) {
					continue;
				}
				v[nextR][nextC] = true;
				q.add(new Point(nextR,nextC,map[nextR][nextC]));
			}
		}
	}

	static class Point {
		int r;
		int c;
		int value;
		
		public Point(int r, int c, int value) {
			this.r = r;
			this.c = c;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", value=" + value + "]";
		}
		
	}
}
