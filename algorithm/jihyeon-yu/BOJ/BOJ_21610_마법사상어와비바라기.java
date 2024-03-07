package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21610_마법사상어와비바라기 {
	static class Point{
		int d, s;

		public Point(int d, int s) {
			super();
			this.d = d;
			this.s = s;
		}
	}
	static int N, M;
	static int[][] map;
	static boolean[][] rainCloud;
	static List<Point> movingInfo;
	// ←, ↖, ↑, ↗, →, ↘, ↓, ↙ 1번부터 시작
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		movingInfo = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			movingInfo.add(new Point(d, s));
		}
		// 최초 비구름 좌표(N, 1), (N, 2), (N-1, 1), (N-1, 2)
		// 행렬이 1부터 시작 주의 N >= 2
		rainCloud = new boolean[N][N];
		int[][] initCloud = {{N-1, 0}, {N-1, 1}, {N-2, 0}, {N-2, 1}};
		for (int i = 0; i < 4; i++) {
			rainCloud[initCloud[i][0]][initCloud[i][1]] = true;
		}
		
		for (int i = 0; i < M; i++) {
			disapearedCloud = new ArrayList<int[]>();
			newWaterPos = new ArrayList<int[]>();
			moveCloud(i);
			pourWater();
			disapearCloud();
			copyWater();
			generateCloud();
		}
		
		int sum = 0;
		for (int c = 0; c < N; c++) {
			for (int r = 0; r < N; r++) {
				if(map[r][c] > 0) sum += map[r][c];
			}
		}
		System.out.println(sum);
	}
	
	private static void moveCloud(int idx) {
		int currS = movingInfo.get(idx).s;
		int currD = movingInfo.get(idx).d - 1;
		List<int[]> movedCloud = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(rainCloud[r][c]) {
					int currR = r;
					int currC = c;
					for (int j = 0; j < currS; j++) {
						currR += dr[currD];
						currC += dc[currD];
						if(currR < 0) currR = N-1;
						if(currR > N-1) currR = 0;
						if(currC < 0) currC = N-1;
						if(currC > N-1) currC = 0;
					}
					movedCloud.add(new int[] {currR, currC});
					rainCloud[r][c] = false;
				}
			}
		}
		for (int i = 0; i < movedCloud.size(); i++) {
			rainCloud[movedCloud.get(i)[0]][movedCloud.get(i)[1]] = true;
		}
	}
	
	static ArrayList<int[]> newWaterPos;
	private static void pourWater() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(rainCloud[r][c]) {
					map[r][c]++;
					newWaterPos.add(new int[] {r, c});
				}
			}
		}
	}
	
	static ArrayList<int[]> disapearedCloud;
	private static void disapearCloud() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(rainCloud[r][c]) {
					rainCloud[r][c] = false;
					disapearedCloud.add(new int[] {r, c});
				}
			}
		}
		
	}
	
	private static void copyWater() {
		int[] newDr = {1, 1, -1, -1};
		int[] newDc = {1, -1, -1, 1};
		for (int i = 0; i < newWaterPos.size(); i++) {
			int cnt = 0;
			int currR = newWaterPos.get(i)[0];
			int currC = newWaterPos.get(i)[1];
			for (int d = 0; d < 4; d++) {
				int nr = currR + newDr[d];
				int nc = currC + newDc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(map[nr][nc] >= 1) {
					cnt++;
				}
			}
			map[currR][currC] += cnt;
		}
		
	}
	
	private static void generateCloud() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] >= 2) {
					boolean flag = true;
					for(int[] i : disapearedCloud) {
						if(i[0] == r && i[1] == c) {
							flag = false;
							break;
						}
					}
					if(flag) {
						rainCloud[r][c] = true;
						map[r][c] -= 2;
					}
				}
			}
		}
		
	}

}
