package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861_정사각형방 {
	static int T, N, start, ans, map[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ans = Integer.MIN_VALUE;
			start = Integer.MAX_VALUE;
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					dfs(r,c,1);
				}
			}
			System.out.println("#"+tc+" "+start+" "+ans);
		}
	}

	private static void dfs(int r, int c, int cnt) {
		
		for (int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0&&nr<N&&nc>=0&&nc<N&&map[nr][nc] - map[r][c] == 1) {
				dfs(nr,nc,cnt+1);
			} else {
				if (ans < cnt) {
					ans = cnt;
					start = map[r][c] - cnt + 1;	
				} else if(ans == cnt) {
					start = start > map[r][c] - cnt + 1 ? map[r][c] - cnt + 1 : start;
				}
			}
		}
	}

}
