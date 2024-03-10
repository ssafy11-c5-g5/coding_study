package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	static class Fish implements Comparable<Fish>{
		int row, col, dist;

		public Fish(int row, int col, int dist) {
			super();
			this.row = row;
			this.col = col;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.dist != o.dist) {
				return Integer.compare(this.dist, o.dist);
			} else if(this.row != o.row) {
				return Integer.compare(this.row, o.row);
			} else {
				return Integer.compare(this.col, o.col);
			}
		}
	}
	static int N, time;
	static int sharkSize = 2, fishCnt = 0;
	static int[] sharkPos = new int[2];
	static int[][] map;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 9) {
					sharkPos[0] = r;
					sharkPos[1] = c;
					map[r][c] = 0;
				}
			}
		}
		
		time = 0;
		while(true) {
			Fish target = findNearestFish();
			if(target == null) break;
			mveAndEat(target);
		}
		System.out.println(time);
	}
	
	private static void mveAndEat(Fish fish) {
		time += fish.dist;
		fishCnt++;
		if(fishCnt == sharkSize) {
			sharkSize++;
			fishCnt = 0;
		}
		map[fish.row][fish.col] = 0;
		sharkPos[0] = fish.row;
		sharkPos[1] = fish.col;
	}

	private static Fish findNearestFish() {
		Queue<int[]> queue = new ArrayDeque<>();
		Queue<Fish> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		queue.offer(new int[] {sharkPos[0], sharkPos[1]});
		visited[sharkPos[0]][sharkPos[1]] = true;
		int dist = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] pos = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = pos[0] + dr[d];
					int nc = pos[1] + dc[d];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
					if(sharkSize >= map[nr][nc]) {
						visited[nr][nc] = true;
						queue.offer(new int[] {nr, nc});
						if(map[nr][nc] > 0 && map[nr][nc] < sharkSize) {
							pq.offer(new Fish(nr, nc, dist+1));
						}
					}
				}
			}
			dist++;
			if(!pq.isEmpty()) {
				return pq.poll();
			}
		}
		return null;
	}
	
	private static void print(int[][] map) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		
	}
}
