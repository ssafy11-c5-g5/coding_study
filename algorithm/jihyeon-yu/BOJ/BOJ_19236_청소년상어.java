package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 물고기 이동에서 막혔습니다.
public class BOJ_19236_청소년상어 {
	static class Fish{
		int num, direction;

		public Fish(int num, int direction) {
			super();
			this.num = num;
			this.direction = direction;
		}

		@Override
		public String toString() {
			return "Fish [num=" + num + ", direction=" + direction + "]";
		}
		
		
	}
	static int sum = 0;
	static int[] shark = new int[3]; // row, col, direction
	static Fish[][] map = new Fish[4][4];
	// ↑, ↖, ←, ↙, ↓, ↘, →, ↗
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int r = 0; r < 4; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 4; c++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken()) - 1;
				map[r][c] = new Fish(a, b);
			}
		}
		
		// 상어 (0, 0) 출발
		shark[0] = 0;
		shark[1] = 1;
		shark[2] = map[0][0].direction;
		sum += map[0][0].num;
		map[0][0] = null;
		
		moveFish();
		print(map);
	}
	
	private static void moveFish() {
		for (int r = 0; r < 4; r++) {
			L : for (int c = 0; c < 4; c++) {
				for (int i = 1; i <= 16; i++) {
					if(map[r][c] == null) continue;
					if(map[r][c].num == i) {
						int dir = map[r][c].direction;
						int nr = r + dr[dir];
						int nc = c + dc[dir];
						if(nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || map[nr][nc] == null) {
							int idx = 1;
							int cnt = 0;
							while(true) {
								if(cnt >= 7) continue L;
								if(dir+idx >= 8) {
									dir = 0;
									idx = 0;
								}
								nr = r + dr[dir+idx];
								nc = c + dc[dir+idx];
								if(nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && map[nr][nc] != null) break;
								idx++;
								cnt++;
							}
						}
						Fish temp = map[nr][nc];
						map[nr][nc] = map[r][c];
						map[r][c] = temp;
					}
				}
			}
		}
	}

	private static void print(Fish[][] map) {
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}
