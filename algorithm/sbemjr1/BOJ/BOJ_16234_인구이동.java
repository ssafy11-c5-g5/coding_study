package sbemjr1.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
//위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
//국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
//연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
//연합을 해체하고, 모든 국경선을 닫는다.

public class BOJ_16234_인구이동 {
	static int N,L,R,map[][];
	static boolean v[][];
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		v = new boolean[N][N];
		
		ArrayList[] graph = new ArrayList[N*N];
		
		for (int i = 0; i < N*N; i++) {
			graph[i] = new ArrayList<Point>();
		}
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		v[0][0] = true;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr>=0 && nr < N && nc>=0 && nc < N && !v[nr][nc] && (Math.abs(map[nr][nc] - map[r][c]) >= L) && (Math.abs(map[nr][nc] - map[r][c]) <= R)) {

						v[nr][nc]=true;
						Point from = new Point(r,c,map[r][c]);
						Point to = new Point(nr,nc,map[nr][nc]);
						
						graph[r*N+c].add(to);
						graph[nr*N+nc].add(from);
						
					}
				}
			}
		}
		for (int i = 0; i < N*N; i++) {
			for (int j = 0; j < graph[i].size(); j++) {
				System.out.print(graph[i].get(j).toString()+ " ");
			}
			System.out.println();
		}
	}
	
	static class Point {
		int r;
		int c;
		int value;
		
		public Point(int r, int c, int value) {
			this.r = r;
			this.c = c;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", value=" + value + "]";
		}
		
		
	}
}
