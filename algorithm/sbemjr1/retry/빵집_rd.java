package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집_rd {
	static int R,C,ans;
	static char map[][];
	
	static int[] dr = {-1,0,1};
	static int[] dc = {1,1,1};
	
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		for (int i = 0; i < R; i++) {
			flag = false;
			dfs(i,0);
		}
		
//		for (int r = 0; r < R; r++) {
//			for (int c = 0; c < C; c++) {
//				System.out.print(map[r][c]);
//			}
//			System.out.println();
//		}
		System.out.println(ans);
		
	}

	private static boolean dfs(int r, int c) {
		if(c == C-1) {
			ans++;
			return true;
		}
		
		for (int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc] == '.') {
				map[nr][nc] = 'x';
				if(dfs(nr,nc)) return true;
			}
		}
		
		return false;
	}
}
