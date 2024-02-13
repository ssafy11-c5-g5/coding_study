package imlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ_16926_배열돌리기1 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		int numRotation = Math.min(N, M) / 2;
		int[][]  map = new int[N][M];
		
		int[] dr = {0, 1, 0, -1}; // 우하좌상
		int[] dc = {1, 0, -1, 0}; // 우하좌상
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int t = 0; t < numRotation; t++) {
				int r = t, c = t; // (0, 0), (1, 1), ...
				
				int temp = map[r][c];
				
				int idx = 0;
				while(idx < 4) {
					int nr = r + dr[idx];
					int nc = c + dc[idx];
					
					if(nr >= t && nr < N - t && nc >= t && nc < M - t) {
						map[r][c] = map[nr][nc];
						r = nr;
						c = nc;
					} else idx++;
				}
				map[t+1][t] = temp;
			}
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}
}


// 회전시킬 그룹의 개수 Math.min(N, M) / 2
// 구한 그룹의 갯수 만큼 반복하여 회전 (반시계 4번)