package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14503_로봇청소기 {
	static int N, M, startR, startC, direction;
	static int[][] map;
	static int[] dr = {0, 0, 1, -1}; //동서남북
	static int[] dc = {1, -1, 0, 0};
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		startR = sc.nextInt();
		startC = sc.nextInt();
		direction = sc.nextInt(); // 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		int cnt = 0;
		boolean[][] visit = new boolean[N][M];
		while(true) {
			if(map[startR][startC] == 0) {
				map[startR][startC] = 3;
				cnt++;
			}
			boolean isTrashExisted = false;
			// 사방 탐색
			for (int d = 0; d < 4; d++) {
				int nr = startR + dr[d];
				int nc = startC + dc[d];
				if(checkAreaOut(nr, nc) || map[nr][nc] == 1) continue;
				if(map[nr][nc] == 0) {
					isTrashExisted = true;
					break;
				}
			}
			// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
			if(isTrashExisted) {
				for (int i = 0; i < 4; i++) {
					// 방향 변경
					if(direction == 0) {
						// 북쪽을 바라보고 있으면 서쪽으로 방향 변경 및 이동
						direction = 3;
						if(!checkAreaOut(startR, startC-1) && map[startR][startC-1] == 0) {
							startC += -1;
							break;
						}
					} else if(direction == 1) {
						// 동쪽을 바라보고 있으면 북쪽으로 방향 변경 및 이동
						direction = 0;
						if(!checkAreaOut(startR-1, startC) && map[startR-1][startC] == 0) {
							startR += -1;
							break;
						}
					} else if(direction == 2) {
						// 남쪽을 바라보고 있으면 동쪽으로 방향 변경 및 이동
						direction = 1;
						if(!checkAreaOut(startR, startC+1) && map[startR][startC+1] == 0) {
							startC += 1;
							break;
						}
					} else {
						// 서쪽을 바라보고 있으면 남쪽으로 방향 변경 및 이동
						direction = 2;
						if(!checkAreaOut(startR+1, startC) && map[startR+1][startC] == 0) {
							startR += 1;
							break;
						}
					}
				}
			} else {
				if(direction == 0) {
					// 북쪽을 바라보고 있으면 남쪽으로 이동
					startR += 1;
				} else if(direction == 1) {
					// 동쪽을 바라보고 있으면 서쪽으로 이동
					startC += -1;
				} else if(direction == 2) {
					// 남쪽을 바라보고 있으면 북쪽으로 이동
					startR += -1;
				} else {
					// 서쪽을 바라보고 있으면 동쪽으로 이동
					startC += 1;
				}
				if(checkAreaOut(startR, startC)|| map[startR][startC] == 1) break;
			}
		}
		System.out.println(cnt);
	}
	
	private static boolean checkAreaOut(int r, int c) {
		return (r < 0 || r >= N || c < 0 || c >= M);
	}

}
