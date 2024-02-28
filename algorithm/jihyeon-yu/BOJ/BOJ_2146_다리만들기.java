package complete;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2146_다리만들기 {
	static int N, Ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 섬 정보 입력
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		// 섬 구분
		visit = new boolean[N][N];
		int islandNum = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visit[r][c] && map[r][c] != 0) {
					separeteIsland(r, c, islandNum);
					islandNum++;
				}
			}
		}
		
		// 섬 끼리의 거리 최솟값 계산
		for (int i = 1; i <= islandNum; i++) {
			getMinDistance(i);
		}
		System.out.println(Ans);
	}
	
	private static void getMinDistance(int islandNum) {
		boolean[][] visit = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<>();
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == islandNum) {
					queue.offer(new int[] {r, c, 0});
					visit[r][c] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(map[nr][nc] != islandNum && map[nr][nc] != 0) {
					if(curr[2] != 0) Ans = Math.min(Ans, curr[2]);
				} else {
					if(map[nr][nc] == 0 && !visit[nr][nc]) {
						visit[nr][nc] = true;
						queue.offer(new int[] {nr, nc, curr[2]+1});
					}
				}
			}
		}
		
	}

	private static void separeteIsland(int r, int c, int island) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		visit[r][c] = true;
		map[r][c] = island;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc]) continue;
				if(map[nr][nc] != 0) {
					queue.offer(new int[] {nr, nc});
					map[nr][nc] = island;
					visit[nr][nc] = true;
				}
			}
		}
	}

}
