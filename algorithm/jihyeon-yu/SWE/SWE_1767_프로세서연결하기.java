package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWE_1767_프로세서연결하기 {
	static class Processor{
		int row, col;
		
		public Processor(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Processor [row=" + row + ", col=" + col + "]";
		}
	}
	static StringTokenizer st = null;
	static int N, coreNum, wireLength;
	static int[][] map;
	static List<Processor> processorList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			processorList = new ArrayList<Processor>();
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] == 1) {
						if(r == 0 || r == N-1 || c == 0 || c == N-1) {
							continue;
						} else {
							processorList.add(new Processor(r, c));
						}
					}
				}
			}
			coreNum = Integer.MIN_VALUE; // 가능한 코어 수(많을 수록 좋음)
			wireLength = Integer.MAX_VALUE; // 그 때의 전선 길이 합(짧을 수록 좋음)
			dfs(0, 0, 0); // coreIdx, core수, 전선길이합
			System.out.println("#" + t + " " + wireLength);
		}

	}
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	private static void dfs(int idx, int coreCnt, int length) {
		if(idx == processorList.size()) { // 모든 코어를 다 돌았으면
			if(coreNum < coreCnt) { // 현재 코어 수가 최대 값이면 코어 수와 전선 길이 합 업데이트
				coreNum = coreCnt;
				wireLength = length;
			} else if(coreNum == coreCnt) { // 코어 수가 같으면 최소 전선 길이의 합 업데이트
				wireLength = Math.min(wireLength, length);
			}
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int currR = processorList.get(idx).row;
			int currC = processorList.get(idx).col;
			int cnt = 0; // 코어 하나의 전선 길이
			while(true) {
				// 한 방향으로 계속해서 더해 나감
				currR += dr[d];
				currC += dc[d];
				// 끝까지 도달했으면 종료
				if(currR < 0 || currR >= N || currC < 0 || currC >= N) {
					break;
				}
				// 중간에 다른 전선이나 코어를 만났으면 해당 경로는 불가능하므로 cnt를 0으로 초기화 후 종료
				if(map[currR][currC] != 0) {
					cnt = 0;
					break;
				}
				cnt++;
			}
			
			// cnt가 0 이상이면, 즉, 전선 연결이 가능한 코어라면
			if(cnt != 0) {
				int originR = processorList.get(idx).row;
				int originC = processorList.get(idx).col;
				for (int i = 0; i < cnt; i++) {
					originR += dr[d];
					originC += dc[d];
					map[originR][originC] = 1; // 해당 경로 1로 업데이트
				}
				dfs(idx+1, coreCnt+1, length+cnt); // 다음 코어 연결 진행
				// 원복
				originR = processorList.get(idx).row;
				originC = processorList.get(idx).col;
				for (int i = 0; i < cnt; i++) {
					originR += dr[d];
					originC += dc[d];
					map[originR][originC] = 0;
				}
			} else { // cnt가 0이면, 즉, 연결이 불가능한 코어라면 값 업데이트 하지 않고 다음 코어 연결 진행
				dfs(idx+1, coreCnt, length);
			}
			
		}
	}

}
