package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16918_봄버맨 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// 초기 상태 & 1초 지난 후
		String[][] map = new String[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c)+"";
			}
		}
		
		
		if(N % 2 == 0) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					System.out.print("O");
				}
				System.out.println();
			}
		} else {
			
			for (int s = 1; s < N; s+=2) {
				
				for (int r = 0; r < R; r++) {
					for (int c = 0; c < C; c++) {
						if (map[r][c].equals(".")) {
							map[r][c] = "O";
						}
						else map[r][c] = "X";
					}
				}
				
				int[] dr = {-1, 1, 0, 0}; // 기준점 상 하 좌 우
				int[] dc = {0, 0, -1, 1}; // 기준점 상 하 좌 우
				
				for (int r = 0; r < R; r++) {
					for (int c = 0; c < C; c++) {
						if (map[r][c].equals("X")) {
							
							for (int d = 0; d < 4; d++) {
								int nr = r + dr[d];
								int nc = c + dc[d];
								if((nr >= 0 && nr < R && nc >= 0 && nc < C) && !map[nr][nc].equals("X")) {
									map[nr][nc] = ".";
								}
				
							}
							map[r][c] = ".";
						}
					}
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
