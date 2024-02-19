package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_15686_치킨배달 {
	static int N, M;
	static int[][] map;
	static List<Integer> distance;
	static int sel[];
	static boolean visit[];
	static int[] dr = {0, 0, 1, -1, 1, 1, -1, -1};
	static int[] dc = {1, -1, 0, 0, 1, -1, -1, 1};
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		distance = new ArrayList<>();
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == 1) {
					bfs(r, c);
				}
			}
		}
		sel = new int[M];
		visit = new boolean[distance.size()];
		System.out.println(distance);
		combination(0, 0);
	}
	
	private static void combination(int idx, int k) {
		if(k == M) {
			System.out.println(Arrays.toString(sel));
			int sum = 0;
			for (int s : sel) {
				sum += s;
			}
			System.out.println(sum);
			return;
		}
		for (int i = idx; i < distance.size(); i++) {
			if(visit[i] == false) {
				visit[i] = true;
				sel[k] = distance.get(i);
				combination(i+1, k+1);
				visit[i] = false;
			}
		}
	}
	private static void bfs(int r, int c) {
		boolean[][] visit = new boolean[N][N];
		Queue<int[]> queue = new ArrayDeque<>();
		visit[r][c] = true;
		queue.offer(new int[] {r, c, 0});
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int dist = curr[2];
			if(map[curr[0]][curr[1]] == 2) {
				distance.add(dist);
				return;
			}
			for (int d = 0; d < 8; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(visit[nr][nc]) continue;
				visit[nr][nc] = true;
				queue.offer(new int[] {nr, nc, dist+1});
			}
		}
	}

}
