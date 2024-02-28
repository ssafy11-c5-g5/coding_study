package complete;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4_구현 {
	static int N, M, K;
	static int[][] arr, originArr;
	static int[] rotationR, rotationC, rotationS;
	static boolean[] visit;
	static int minSum = Integer.MAX_VALUE;
	static int[] dr = {1, 0, -1, 0}; // 하우상좌
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 초기 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		originArr = new int[N+1][M+1];
		rotationR = new int[K];
		rotationC = new int[K];
		rotationS = new int[K];
		visit = new boolean[K];
		
		// 배열 값 입력 받기
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 원본 배열 복사
		copyArray(arr, originArr);
		
		// 회전 연산 입력 받기
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rotationR[i] = Integer.parseInt(st.nextToken());
			rotationC[i] = Integer.parseInt(st.nextToken());
			rotationS[i] = Integer.parseInt(st.nextToken());
		}
		
		// 순열 생성 후 배열 회전
		generatePermuations(0, new int[K]);
		
		// 결과 출력
		System.out.println(minSum);
	}
	
	private static void generatePermuations(int k, int[] sel) {
		// 순열 생성 완료 시 배열 회전 적용
		if(k == sel.length) {
			applyRotations(sel);
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if(!visit[i]) {
				visit[i] = true;
				sel[k] = i;
				generatePermuations(k+1, sel);
				visit[i] = false;
			}
		}
		
	}

	private static void applyRotations(int[] sel) {
		// 원본 배열로 초기화
		copyArray(originArr, arr);
		
		// 선택된 순서대로 회전 연산 적용
		for(int idx : sel) {
			int r = rotationR[idx];
			int c = rotationC[idx];
			int s = rotationS[idx];
			rotateArray(r-s, c-s, r+s, c+s);
		}
		
		// 최소 합 갱신
		minSum = Math.min(minSum, calculateMinRowSum());
	}

	private static int calculateMinRowSum() {
		int minRowSum = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int rowSum = 0;
			for(int num : arr[i]) {
				rowSum += num;
			}
			minRowSum = Math.min(minRowSum, rowSum);
		}
		return minRowSum;
	}

	private static void rotateArray(int startR, int startC, int endR, int endC) {
		int layerCount = Math.min((endR-startR+1), (endC-startC+1)) / 2;
		for (int layer = 0; layer < layerCount; layer++) {
			// 각 레이어의 시작 위치 저장
			int r = startR + layer;
			int c = startC + layer;
			// 시작 점 임시 저장
			int tempValue = arr[r][c];
			
			for (int d = 0; d < 4; d++) {
				while(true) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					// 범위를 벗어나거나 현재 레이어의 경계에 도달하면 방향 전환
					if(nr < startR + layer || nr > endR - layer || nc < startC + layer || nc > endC - layer) {
						break;
					}
					
					// 이동
					arr[r][c] = arr[nr][nc];
					r = nr;
					c = nc;
				}
			}
			// 첫 번째 원소를 마지막에 이동한 위치에 저장
			arr[startR + layer][startC + layer + 1] = tempValue;
		}
	}

	private static void copyArray(int[][] arr, int[][] originArr) {
		for (int i = 0; i <= N; i++) {
			System.arraycopy(arr[i], 0, originArr[i], 0, M+1);
		}
		
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}