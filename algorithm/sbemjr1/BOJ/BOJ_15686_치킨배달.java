package sbemjr1.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
	static int N,M,map[][],ansMap[][][],distance,min;
	
	static class Point {
		int r;
		int c;
		int d;
		
		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
//		ansMap = new int[N][N][2];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		Stack<Point> stack = new Stack<>();
				
		for (int r = 0; r < N; r++) {
			
			for (int c = 0; c < N; c++) {
				min = Integer.MAX_VALUE;
				if (map[r][c] == 1) {
					for (int nr = 0; nr < N; nr++) {
						
						for (int nc = 0; nc < N; nc++) {
							if (map[nr][nc] > 1) {
								distance = Math.abs(nr - r) + Math.abs(nc - c);
								if (distance <= min) {
									stack.add(new Point(nr,nc,distance));
									min = distance;
								}
							}
						}
						
					}
					
				}
				
				for (int nr = 0; nr < N; nr++) {
					for (int nc = 0; nc < N; nc++) {
						if(!stack.isEmpty() && stack.peek().r == nr && stack.peek().c == nc) {
							map[nr][nc] += stack.peek().d;
							stack.pop();
						}
					}
				}
			}
			
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}
