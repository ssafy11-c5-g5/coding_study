package imlist;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16918_봄버맨_다시풀기 {
	static int R, C, N;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		R = Integer.parseInt(st.nextToken()); // row
		C = Integer.parseInt(st.nextToken()); // column
		N = Integer.parseInt(st.nextToken()); // second
		
		// 폭탄 초기 상태 입력
		char[][] map = new char[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		char[][] result = simulataion(map, N);
		
		print(result);
		
	}
	
	// 봄버맨 시뮬레이션 함수
	private static char[][] simulataion(char[][] map, int N) {
		if(N % 2 == 0) {
			return fillBomb(map);
		}
		
		for (int t = 2; t <= N; t+=2) {
			map = fillBomb(map); // 폭탄 설치
			map = detonateBomb(map); // 폭탄 터뜨리기
		}
		
		return map;
	}
	
	// 폭탄 터뜨리기 함수
	private static char[][] detonateBomb(char[][] map) {
		char[][] result = new char[map.length][map[0].length];
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				if(map[r][c] == 'O') {
					result[r][c] = '.';
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(nr >= 0 && nr < R && nc >=0 && nc < C) result[nr][nc] = '.';
					}
				}
				else result[r][c] = map[r][c];
			}
		}
		return result;
	}
	
	// 폭탄 설치 함수
	private static char[][] fillBomb(char[][] map) {
		char[][] result = new char[map.length][map[0].length];
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				if(map[r][c] == '.') result[r][c] = 'O';
				else result[r][c] = map[r][c];
			}
		}
		return result;
	}

	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
