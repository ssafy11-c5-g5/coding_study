package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 궁수 공격 거리: D이하인 적 중에서 가장 가까운 적, 여럿일 경우 가장 왼쪽에 있는 적 공격
// 두 격자판의 위치 (r1, c1), (r2, c2) -> |r1-r2| - |c1-c2|
public class BOJ_17135_캐슬디펜스 {
	static int N, M, D, Ans;
	static int[][] map;
	static int[] dc = {-1, 0, 1}; // 좌상 상 우상
	static boolean locationVisit[];
	static boolean attactVisit[][];
	static int[] sel;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		map = new int[N+1][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		locationVisit = new boolean[M];
		attactVisit = new boolean[N+1][M];
		sel = new int[3];
		Ans = 0;
		
		combination(0,0);
		System.out.println(Ans);
	}
	
	// 궁수의 위치 지정
	private static void combination(int idx, int k) {
		if(k == sel.length) {
			while(true) {
				if(countEnemy(map) == 0) break;
				bfs(sel);
			}
			return;
		}
		for (int i = idx; i < M; i++) {
			if(locationVisit[i] == false) {
				locationVisit[i] = true;
				sel[k] = i;
				combination(i+1, k+1);
				locationVisit[i] = false;
			}
		}
	}
	
	static class Point{
		int row, col;
		Point(int r, int c){
			row = r;
			col = c;
		}
	}
	
	// 각 궁수가 공격할 수 있는 최단거리 적 구하기
	private static void bfs(int[] sel) {
		for (int i = 0; i < 3; i++) {
			boolean[][] visit = new boolean[N+1][M];
			Queue<Point> queue = new LinkedList<>();
			visit[N][sel[i]] = true;
			queue.offer(new Point(N, sel[i]));
			
			while(!queue.isEmpty()) {
				Point curr = queue.poll();
				for(int d = 0; d < 3; d++) {
					int nr = curr.row - 1;
					int nc = curr.col + dc[d];
					// 공격 최대 거리 D
					if((Math.abs(curr.row - nr) - Math.abs(curr.col) - nc) > D) continue;
					if(nr < 0 || nr >= N+1 || nc < 0 || nc >= M) continue;
					visit[nr][nc] = true;
					if(map[nr][nc] == 1) {
						if(!attactVisit[nr][nc]) {
							attactVisit[nr][nc] = true;
							Ans++;
							return;
						}
					}
					queue.offer(new Point(nr, nc));
				}
			}
		}
		// 공격 받은 적 제거
		for (int r = 0; r < N+1; r++) {
			for (int c = 0; c < M; c++) {
				if(attactVisit[r][c]) {
					map[r][c] = 0;
				}
			}
		}
		// 남은 적 한 칸 밑으로
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M-1; c++) {
				if(map[r][c] == 1) {
					map[r][c] = 0;
					map[r+1][c+1] = 1;
				}
			}
		}
		
	}
	
	private static int countEnemy(int[][] map) {
		int cnt = 0;
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				if(map[r][c] == 1) cnt++;
			}
		}
		return cnt;
	}
}
