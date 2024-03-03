package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 감시 {
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
	
	static int R,C,ans;
	static int[][] map, tmpMap;
 	static ArrayList<Point> cctv_point;
 	static ArrayList<Integer> dirs;
	
	static int[] dr = {1, 0, -1, 0}; // 상 좌 하 우
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		tmpMap = new int[R][C];
		cctv_point = new ArrayList<>();
		dirs = new ArrayList<>();
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] >= 1 && map[r][c] < 5) {
					cctv_point.add(new Point(r, c));
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		permutation(0);
		System.out.println(ans);
	}

	private static void permutation(int k) {
		if(k == cctv_point.size()) {
			copyMap();
			simulation();
			int cnt = 0;
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(tmpMap[r][c] == 0) {
						cnt++;
					}
				}
			}
			ans = Math.min(ans, cnt);
			return;
		}
		
		for (int d = 0; d < 4; d++) { //방향 생성
			dirs.add(d);
			permutation(k+1);
			dirs.remove(k);
		}
	}

	private static void simulation() {
		for (int i = 0; i < cctv_point.size(); i++) {
			Point cctv = cctv_point.get(i);
			int dir = dirs.get(i);
			
			markMap(cctv.r,cctv.c,dir);
			
			if(tmpMap[cctv.r][cctv.c] == 2) {
				dir = (dirs.get(i) + 2) % 4;
				markMap(cctv.r,cctv.c,dir);
			} else if(tmpMap[cctv.r][cctv.c] == 3) {
				dir = (dirs.get(i) + 1) % 4;
				markMap(cctv.r,cctv.c,dir);
			} else if(tmpMap[cctv.r][cctv.c] == 4) {
				dir = (dirs.get(i) + 3) % 4;
				markMap(cctv.r,cctv.c,dir);
				dir = (dirs.get(i) + 1) % 4;
				markMap(cctv.r,cctv.c,dir);
			}
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(tmpMap[r][c] == 5) {
					for (int d=0; d<4; d++) {
						markMap(r, c, d);
					}
				}
			}
		}
	}

	private static void markMap(int r, int c, int dir) {
		int nr = r;
		int nc = c;
		while(true) {
			nr += dr[dir];
			nc += dc[dir];
			
			if(nr<0 || nr>=R || nc<0 || nc>=C || tmpMap[nr][nc] == 6) {
				break;
			}
			if(tmpMap[nr][nc] == 0) {
				tmpMap[nr][nc] = 9;
			}
		}
	}

	private static void copyMap() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				tmpMap[r][c] = map[r][c];
			}
		}
	}

}
