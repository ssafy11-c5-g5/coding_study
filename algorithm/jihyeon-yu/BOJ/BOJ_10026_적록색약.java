package complete;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10026_적록색약_BFS {
	static int N, cnt, Ans;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		visit = new boolean[N][N];
		cnt = 0;
		Ans = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visit[r][c]) {
					normalBFS(r, c);
					if(cnt > 0) {
						Ans++;
					}
				}
			}
		}
		sb.append(Ans).append(" ");
		visit = new boolean[N][N];
		cnt = 0;
		Ans = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visit[r][c]) {
					rgBFS(r, c);
					if(cnt > 0) {
						Ans++;
					}
				}
			}
		}
		sb.append(Ans);
		System.out.println(sb);
	}
	
	static class Point{
		int row, col, color;
		public Point(int row, int col, int color) {
			super();
			this.row = row;
			this.col = col;
			this.color = color;
		}
		
	}
	
	private static void rgBFS(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c, map[r][c]));
		visit[r][c] = true;
		cnt++;
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr.row + dr[d];
				int nc = curr.col + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc]) continue;
				if(curr.color != map[nr][nc]) {
					if(!(curr.color == 'R' && map[nr][nc] == 'G') && !(curr.color == 'G' && map[nr][nc] == 'R')) continue;
				}
				cnt++;
				queue.offer(new Point(nr, nc, map[nr][nc]));
				visit[nr][nc] = true;
			}
		}
		
	}

	private static void normalBFS(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c, map[r][c]));
		visit[r][c] = true;
		cnt++;
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr.row + dr[d];
				int nc = curr.col + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc]) continue;
				if(curr.color == map[nr][nc]) {
					cnt++;
					queue.offer(new Point(nr, nc, map[nr][nc]));
					visit[nr][nc] = true;
				}
			}
		}
	}
	
}
