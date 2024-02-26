package sbemjr1.SWE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5644_무선충전 {
	static int T,M,A,moveA[],moveB[],rA,cA,rB,cB;
	static int[] dr = {0,-1,0,1,0}; // x 상 우 하 좌
	static int[] dc = {0,0,1,0,-1};
	static int[][][] map;
	static boolean[][] v;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken()); // 진행 시간
			A = Integer.parseInt(st.nextToken()); // 배터리 개수
			
			map = new int[10][10][A];
			
			// 이동 배열
			moveA = new int[M];
			moveB = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				int range = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				map[r-1][c-1][i] = P;
				for (int d = 1; d <= 4; d++) {
					for (int j = 1; j <= range; j++) {
						int nr = (r-1)+(j*dr[d]);
						int nc = (c-1)+(j*dc[d]);
						if (nr >= 0 && nr < 10 && nc >= 0 && nc < 10) {
							map[nr][nc][i] = P;
						}
						
					}
				}
			
			}
			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.print(map[i][j][0]+" ");
				}
				System.out.println();
			}
			
			rA = 0;
			cA = 0;
			rB = 9;
			cB = 9;
			int sumA = 0;
			int sumB = 0;
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < A; j++) {
					// 무선 충전 구역이라면 bfs 탐색으로 같은 영역에 있는지 확인
					if(map[rA][cA][j] != 0) {
						v = new boolean[10][10];
						flag = false;
						bfs(j);
						if(flag) { // 같은 영역에 있다면
							// 배터리가 겹친 경우
							for (int k = 0; k < A; k++) {
								if(map[rA][cA][j] != map[rA][cA][k] && map[rA][cA][k] != 0) {
									
								}
							}
							// 배터리가 하나인 경우
							sumA += map[rA][cA][j] / 2;
							sumB += map[rB][cB][j] / 2;
						}
					}
				}
				
				rA = rA + dr[moveA[i]];
				cA = cA + dr[moveA[i]];
				
				rB = rB + dr[moveB[i]];
				cB = cB + dr[moveB[i]];
			}
		}
	}

	private static void bfs(int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {rA,cA});
		v[rA][cA] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowR = now[0];
			int nowC = now[1];
			
			if (nowR == rB && nowC == cB) {
				flag = true; // 겹친다
			}
			
			for (int d = 1; d <= 4; d++) {
				int nextR = nowR + dr[d];
				int nextC = nowC + dc[d];
				
				if(nextR >= 0 && nextR < 10 && nextC >= 0 && nextC < 10 && map[nextR][nextC][j] == map[rA][cA][j] && !v[nextR][nextC]) {
					v[nextR][nextC] = true;
					q.add(new int[] {nextR,nextC});
				}
			}
		}
		
	}

}
