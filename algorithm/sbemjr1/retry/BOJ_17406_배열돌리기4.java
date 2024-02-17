package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4 {
	static int N,M,K,map[][],comp[][], min, d;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[] v;
	
	static class Point {
		int r;
		int c;
		int s;
		
		public Point(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", s=" + s + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		comp = new int[N][M];
		
		Point[] arr = new Point[K];
		Point[] sel = new Point[K];
		v = new boolean[K];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				comp[r][c] = map[r][c];
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Point(Integer.parseInt(st.nextToken()) - 1,Integer.parseInt(st.nextToken()) - 1,Integer.parseInt(st.nextToken()));
		}

		min = Integer.MAX_VALUE;
		permutaion(0,arr,sel);
		System.out.println(min);
	}

	private static void permutaion(int idx, Point[] arr, Point[] sel) {
		if (idx == K) {
			rotate(sel);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					comp[r][c] = map[r][c];
				}
			}
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[idx] = arr[i];
				permutaion(idx+1,arr,sel);
				v[i] = false;
			}
		}
	}

	private static void rotate(Point[] sel) {
		for (int k = 0; k < K; k++) {
			for (int i = 0; i < sel[k].s; i++) {
				
				int r = i + sel[k].r - sel[k].s;
				int c = i + sel[k].c - sel[k].s;
				
				d = 0;
				
				int tmp = comp[r][c];
				
				while (d < 4) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if (nr >= i + sel[k].r - sel[k].s && nr <= sel[k].r + sel[k].s - i && nc >= i + sel[k].c - sel[k].s && nc <= sel[k].c + sel[k].s - i) {
						comp[r][c] = comp[nr][nc];
						r = nr;
						c = nc;
					} else {
						d++;
					}
				}
				
				comp[i + sel[k].r - sel[k].s][i + sel[k].c - sel[k].s+1] = tmp;
			}
		}
		for (int r = 0; r < N; r++) {
			int sum = 0;
			for (int c = 0; c < M; c++) {
				sum += comp[r][c];
			}
			min = Math.min(sum, min);
		}
		
	}

}
