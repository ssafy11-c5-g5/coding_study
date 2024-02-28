package sbemjr1.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {
	static int N,M,D,originMap[][],copyMap[][], sel[],cnt,ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		originMap = new int[N][M];
		copyMap = new int[N][M];
		
		// 원본 배열 입력
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				originMap[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MIN_VALUE;
		
		// 궁수 위치 조합
		sel = new int[3];
		combination(0,0);
		System.out.println(ans);
	}

	private static void combination(int idx, int k) {
		if (k == sel.length) {
			cnt = 0;
			defense();
			ans = Math.max(ans, cnt);
			return;
		}
		if (idx == M) {
			return;
		}
		
		sel[k] = idx;
		combination(idx+1, k+1);
		combination(idx+1, k);
	}

	private static void defense() {
		// 시뮬레이션을 위한 배열 복사 및 초기화
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				copyMap[r][c] = originMap[r][c];
			}
		}
		
		int limit = D;
		
		// N번 시뮬레이션
		for (int i = 0; i < N; i++) {
			int[][] killEnemy = new int[sel.length][2];
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 2; k++) {
					killEnemy[j][k] = -1; // 밑에서 0과 겹칠까봐
				}
			}
			// 궁수 한명 마다 타겟 설정
			for (int j = 0; j < sel.length; j++) {
				int archerR = N;
				int archerC = sel[j];
				int distance = 0;
				int min = Integer.MAX_VALUE;
				
				for (int r = N-1; r >= 0; r--) {
					for (int c = 0; c < M; c++) {
						if(copyMap[r][c] == 1) {
							distance = Math.abs(archerR - r) + Math.abs(archerC - c);
							if (distance < min && distance <= limit) { // 가장 작고 범위보다 작음
								min = distance;
								killEnemy[j][0] = r;
								killEnemy[j][1] = c;
							} else if (distance == min && c < killEnemy[j][1]) { // 가장 작고 왼쪽
								killEnemy[j][0] = r;
								killEnemy[j][1] = c;
							}
						}
					}
				}
			}
			// 궁수가 죽인 적들 한번에 처리
			for (int j = 0; j < killEnemy.length; j++) {
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						if(r == killEnemy[j][0] && c == killEnemy[j][1] && copyMap[r][c] == 1) {
							copyMap[r][c] = 0;
							cnt++;
						}
					}
				}
			}
			// 한번 공격 후 성으로 도착한 적들 0으로 처리
			for (int j = 0; j < M; j++) {
				copyMap[N-1-i][j] = 0;
			}
			// 적들이 다가오는 대신 사거리 증가
			limit++;
		}
	}
}

//}
