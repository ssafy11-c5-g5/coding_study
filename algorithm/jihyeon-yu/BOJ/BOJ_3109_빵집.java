package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
// 출발점 하나 당 설치 파이프 1개 -> 파이프를 설치하면 처음으로 return
public class BOJ_3109_빵집 {
	static int R, C, Ans;
	static int[][] map;
	static int[] dr = {-1, 0, 1}; // 우상, 우, 우하
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			String str = sc.next();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c) == '.' ? 0 : 1; // '.': 빈칸, 'X': 건물
			}
		}
		int Ans = 0;
		for (int r = 0; r < R; r++) {
			boolean result = dfs(r, 0);
			// 설치가 끝난 경우에만 count
			if(result) Ans++;
		}
		System.out.println(Ans);
	}
	
	private static boolean dfs(int r, int c) {
		// 첫째 열에서 마지막 열에 도달한 경우: 파이프 설치를 성공한 경우 true
		if(c == C - 1) return true;
		
		for (int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + 1;
			if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) {
				map[nr][nc] = 1;
				boolean result = dfs(nr, nc);
				if(result) return true;
				//이미 지난 곳은 원복시키지 않음(backtracking)
			}
		}
		// 반복문이 끝나도 파이프 설치를 실패한 경우 false
		return false; 
	}

	
}
