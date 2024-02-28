package complete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2636_치즈_BFS {
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int R, C;
	static int[][] map;
	static boolean[][] Edgevisit;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		int hour = 0; // 소요 시간
		int cnt = 0; // 녹기 한 시간 전 남아있는 치즈 조각
		
		while(true) {
			// map에 1이 없으면 2의 개수를 세고 종료
			boolean isCheeseExisted = false;
			L : for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c] == 1) {
						isCheeseExisted = true;
						break L;
					}
				}
			}
			if(!isCheeseExisted) {
				for (int r = 0; r < R; r++) {
					for (int c = 0; c < C; c++) {
						if(map[r][c] == 2) cnt++;
					}
				}
				break;
			}
			// 테두리 녹이기
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c] == 2) {
						map[r][c] = 3;
					}
				}
			}
						
			// 배경 구분 3
			setBackgroud(0, 0);
			// 테두리 구분 2
			Edgevisit = new boolean[R][C];
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(!Edgevisit[r][c] && map[r][c] == 1) {
						findEdge(r, c);
					}
				}
			}
			hour++;
		}
		System.out.println(hour);
		System.out.println(cnt);
	}
	
	private static void findEdge(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		Edgevisit[r][c] = true;
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || Edgevisit[nr][nc]) continue;
				if(map[nr][nc] == 3) {
					map[curr.r][curr.c] = 2;
				} else if(map[nr][nc] == 1){
					Edgevisit[nr][nc] = true;
					queue.offer(new Point(nr, nc));
				}
			}
		}
		
	}

	private static void setBackgroud(int r, int c) {
		boolean[][] visit = new boolean[R][C];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		visit[r][c] = true;
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || visit[nr][nc]) continue;
				if(map[nr][nc] == 0 || map[nr][nc] == 3) {
					queue.offer(new Point(nr,nc));
					map[nr][nc] = 3;
					visit[nr][nc] = true;
				}
			}
		}
		
	}
	
	private static void print(int[][] map) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
