package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1194_달이차오른다가자 {
/*
빈 칸: 언제나 이동할 수 있다. ('.')
벽: 절대 이동할 수 없다. ('#')
열쇠: 언제나 이동할 수 있다. 이 곳에 처음 들어가면 열쇠를 집는다. ('a', 'b', 'c', 'd', 'e', 'f')
문: 대응하는 열쇠가 있을 때만 이동할 수 있다. ('A', 'B', 'C', 'D', 'E', 'F')
민식이의 현재 위치: 빈 곳이고, 민식이가 현재 서 있는 곳이다. ('0')
출구: 달이 차오르기 때문에, 민식이가 가야하는 곳이다. 이 곳에 오면 미로를 탈출한다. ('1')
*/
	static int N, M;
	static int Ans = Integer.MAX_VALUE;
	static char[][] map;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("sample.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		int Sr = 0, Sc = 0;
		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c] == '0') {
					Sr = r;
					Sc = c;
				}
			}
		}
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][][] visit = new boolean[N][M][1<<6];
		visit[Sr][Sc][0] = true; // key: 000000
		queue.offer(new Point(Sr, Sc, 0, 0));
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			if(map[curr.r][curr.c] == '1') {
				Ans = curr.cnt;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				int nk = curr.key;
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc][nk] && map[nr][nc] != '#') {
					// nr, nc에 key가 있다면 키 획득
					if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
						// 000 000 fed cba
						//  000 000
						// |000 001
						nk |= (1<<map[nr][nc] - 'a');
					}
					// nr, nc에 문이 있다면 그 문에 맞는 key를 갖고있는지 확인
					if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
						//  000 000
						// &000 001 'A' 탐색
						// 000 001 > 0 키 있음 == 0 키 없음
						// 키 없음: 패스
						if((nk & (1<<(map[nr][nc] - 'A'))) == 0) {
							continue;
						}
						
					}
					visit[nr][nc][nk] = true;
					queue.add(new Point(nr, nc, curr.cnt+1, nk));
				}
			}
		}
		System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);
	}
	
	static class Point{
		int r, c, cnt;
		int key;
		Point(int r, int c, int cnt, int key){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}
	}
}
