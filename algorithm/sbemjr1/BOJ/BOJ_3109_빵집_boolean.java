package sbemjr1.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_3109_빵집_boolean {
	static int N_R,N_C,cnt;
	static Character map[][];
	static int[] dr = {-1,0,1};
	static int[] dc = {1,1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N_R = Integer.parseInt(st.nextToken());
		N_C = Integer.parseInt(st.nextToken());
		map = new Character[N_R][N_C];
		
		for (int i = 0; i < N_R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < N_C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < N_R; i++) {
			if (recursive(i,0)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	private static boolean recursive(int r, int c) {
		map[r][c] = 'x';
		if (c == N_C - 1) {
			return true;
		}
		
		for(int d =0;d<3;d++){
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0&nr<N_R&&nc>=0&&nc<N_C&&map[nr][nc]=='.') {
				map[nr][nc] = 'x';
				if (recursive(nr,nc)) return true;
			}
		}
		return false;
	}

}
