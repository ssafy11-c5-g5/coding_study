package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {
	static int N, L, Ans = 0;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		countPossibleWay(map);
		System.out.println(Ans);
	}
	private static void countPossibleWay(int[][] map) {
		
		for (int r = 0; r < N; r++) {
			// 한 행의 모든 값이 같은지 확인
			if(checkSame(map[r])) Ans++;
			// 각 열의 경사로 확인
			else if(checkHill(map[r])) Ans++;
		}
		
		for (int c = 0; c < N; c++) {
			int[] colArr = new int[N];
			for (int r = 0; r < N; r++) {
				colArr[r] = map[r][c];
			}
			// 한 열의 모든 값이 같은지 확인
			if(checkSame(colArr)) Ans++;
			// 각 열의 경사로 확인
			else if(checkHill(colArr)) Ans++;
		}
		
	}
	
	private static boolean checkSame(int[] arr) {
		int firstValue = arr[0];
		for (int i = 0; i < N; i++) {
			if(arr[i] != firstValue) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkHill(int[] arr) {
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N-1; i++) {
			// 연속한 두 수의 차가 2 이상이면 불가능
			if(Math.abs(arr[i] - arr[i+1]) > 1) return false;
			// 앞 인덱스의 값이 뒷 인덱스의 값보다 1 크면 i + 1 부터 i + L 까지 값이 같은지 확인
			else if(arr[i] - arr[i+1] == 1) {
				if(visited[i+1]) return false;
				visited[i+1] = true;
				for (int j = 2; j <= L; j++) {
					// 경사로의 길이만큼 탐색하다가 map의 범위를 벗어나면 불가능
					if(i+j >= N || arr[i+j] != arr[i+1]) return false;
					else if(arr[i+1] == arr[i+j]) {
						if(visited[i+j]) return false;
						visited[i+j] = true;
					}
				}
			}
			// 뒷 인덱스의 값이 앞 인덱스의 값보다 1 크면 i + 1 부터 i + 1 - L  까지 값이 같은지 확인
			else if(arr[i+1] - arr[i] == 1) {
				if(visited[i]) return false;
				for (int j = 1; j <= L; j++) {
					// 경사로의 길이만큼 탐색하다가 map의 범위를 벗어나면 불가능
					if(i+1-j < 0 || arr[i+1-j] != arr[i]) return false;
						if(visited[i+1-j]) return false;
						visited[i+1-j] = true;
					}
				}
			}
		return true;
	}
	
}
