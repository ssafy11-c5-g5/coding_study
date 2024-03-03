package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 프로세스연결하기 {
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
	
	static int T,N,max_P,min_L;
	static int[][] map;
	static ArrayList<Point> process;
	
	static int[] dr = {1, 0, -1, 0}; // 상 좌 하 우
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			process = new ArrayList<>();
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(r != 0 && c!= 0 && map[r][c] == 1) { // 파워와 이미 연결된 회로는 제외
						process.add(new Point(r,c));
					}
				}
			}
			max_P = Integer.MIN_VALUE;
			min_L = Integer.MAX_VALUE;
			go(0,0,0);
			
			System.out.println("#"+tc+" "+min_L);
		}
	}

	private static void go(int idx, int core_cnt,int leng) {
		if(core_cnt + (process.size() - idx) < max_P) {
			return;
		}
		
		if(idx == process.size()) {
			if (core_cnt > max_P) {
				max_P = core_cnt;
				min_L = leng;
			}
			if (core_cnt == max_P) {
				if(min_L > leng) {
					min_L = leng;
				}
			}
			return;
		}
		int r = process.get(idx).r;
		int c = process.get(idx).c;
		
		for (int d = 0; d < 4; d++) {
			if(isPossible(r,c,d)) {
				int l = markMap(r,c,d,2); // 채우기
				go(idx+1,core_cnt+1,leng+l);
				markMap(r,c,d,0); // 지우기
			}
		}
		go(idx+1,core_cnt,leng);
	}

	private static boolean isPossible(int r, int c, int d) {
		while(true) {
			r += dr[d];
			c += dc[d];
			
			
			if(r<0 || r>=N || c<0 || c>=N) {
				return true;
			}
			if(map[r][c] > 0) {
				return false;
			}
		}
	}

	private static int markMap(int r, int c, int d, int s) {
		int cnt = 0;
		
		while(true) {
			r += dr[d];
			c += dc[d];
			
			if(r<0 || r>=N || c<0 || c>=N) {
				break;
			}
			map[r][c] = s; // 2: 전선 0: 빈칸
			cnt++;
		}
		return cnt;
	}

}
