package sbemjr1.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

//국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
//위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
//국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
//연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
//연합을 해체하고, 모든 국경선을 닫는다.

public class BOJ_16234_인구이동_bfs {
	static int N,L,R,map[][],sum;
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
						bfs(r,c,map[r][c]);
						// 인구 분배
						for (int i = 0; i < result.size(); i++) {
							for (int nr = 0; nr < N; nr++) {
								for (int nc = 0; nc < N; nc++) {
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
