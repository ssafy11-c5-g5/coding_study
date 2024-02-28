package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1600_말이되고픈원숭이 {
	static int K, W, H;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0, -2, -2, 2, 2, -1, -1, 1, 1};
	static int[] dc = {0, 0, 1, -1, -1, 1, -1, 1, -2, 2, -2, 2};
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		int sRow, sCol, dRow, dCol;
		sRow = 0; sCol = 0;
		dRow = H-1; dCol = W-1;
		System.out.println(bfs(sRow, sCol, dRow, dCol));
	}
	
	static class Point{
		int row, col, dist, jump;
		public Point(int r, int c, int d, int j) {
			row = r;
			col = c;
			dist = d;
			jump = j;
		}
	}
	
	private static int bfs(int sRow, int sCol, int dRow, int dCol) {
		boolean[][][] visit = new boolean[H][W][K+1];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(sRow, sCol, 0, 0));
		visit[sRow][sCol][0] = true;
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			if(curr.row == dRow && curr.col == dCol) return curr.dist;
			for (int d = 0; d < 12; d++) {
				// 그냥 가는 경우
				
				// 점프해서 가는 경우
			}
		}
		return -1;
	}
	
}
