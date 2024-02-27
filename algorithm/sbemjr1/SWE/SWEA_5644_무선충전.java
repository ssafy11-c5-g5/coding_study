package sbemjr1.SWE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5644_무선충전 {
	static int T,M,A,moveA[],moveB[],rA,cA,rB,cB,max,result,ans;
	static int[] dr = {0,-1,0,1,0}; // x 상 우 하 좌
	static int[] dc = {0,0,1,0,-1};
	static int[][][] map;
	static int[] sel;

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
				
				int c = Integer.parseInt(st.nextToken())-1;
				int r = Integer.parseInt(st.nextToken())-1;
				
				int range = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j <= range; j++) {
					for (int k = c-j; k <= c+j; k++) {
						if ((r-range+j) >= 0 && (r-range+j) < 10 && k >= 0 && k < 10) {
							map[r-range+j][k][i] = P;
						}
					}
				}
				for (int j = 1; j <= range; j++) {
					for (int k = c-range+j; k <= c+range-j; k++) {
						if ((r+j)>=0&&(r+j)<10&&k>=0&&k<10) {
							map[r+j][k][i] = P;
						}
					}
				}
			
			}
			
			rA = 0;
			cA = 0;
			rB = 9;
			cB = 9;
			sel = new int[A];
			
			result = 0;
			ans = 0;
			for (int i = 0; i < A; i++) {
				if(map[rA][cA][i] != 0 || map[rB][cB][i] != 0) {
					if (A >= 2) {
						max = Integer.MIN_VALUE;
						recursive(0);
						ans += max;
					} else {
						ans += map[rA][cA][i] + map[rB][cB][i];
					}
					break;
				}
			}
			
			for (int i = 0; i < M; i++) {
				rA = rA + dr[moveA[i]];
				cA = cA + dc[moveA[i]];
				
				rB = rB + dr[moveB[i]];
				cB = cB + dc[moveB[i]];
				
				for (int j = 0; j < A; j++) {
					if(map[rA][cA][j] != 0 || map[rB][cB][j] != 0) {
						if (A >= 2) {
							max = Integer.MIN_VALUE;
							recursive(0);
							ans += max;
							break;
						} else {
							ans += map[rA][cA][j] + map[rB][cB][j];
						}
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void recursive(int k) {
		if (k == 2) {
			result = map[rA][cA][sel[0]] + map[rB][cB][sel[1]];
			if (sel[0] == sel[1]) {
				result = result / 2;
			}
			max = Math.max(max, result);
			return;
		}
		
		for (int i = 0; i < A; i++) {
			sel[k] = i;
			recursive(k+1);
		}
	}

}
