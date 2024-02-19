package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {
	static int N,M,R,map[][],ans[][],min, d;
//	static int[] dr = {1,0,-1,0};
//	static int[] dc = {0,1,0,-1};
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
//		ans = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Math.min(N, M);
		
		for (int i = 0; i < R; i++) {
			rotate();
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(map[r][c]+" ");
			}

			System.out.println();
		}
	}

	private static void rotate() {
		for (int i = 0; i < min/2; i++) {
			int r = i;
			int c = i;
			
			d = 0;
			
			int tmp = map[r][c];
			
			while (d < 4) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (nr>=i&&nr<N-i&&nc>=i&&nc<M-i) {
					map[r][c] = map[nr][nc];
					r = nr;
					c = nc;
				} else {
					d++;
				}
			}
			
			map[i+1][i] = tmp;
			
//			d = 0;
//			
//			while (d < 4) {
//				int nr = r + dr[d];
//				int nc = c + dc[d];
//				
//				if (nr>=i&&nr<N-i&&nc>=i&&nc<M-i) {
//					map[nr][nc] = ans[nr][nc];
//					r = nr;
//					c = nc;
//				} else {
//					d++;
//				}
//			}
		}
//		if (min%2 != 0) {
//			ans[min/2][min/2] = map[min/2][min/2];
//		}
	}

}
