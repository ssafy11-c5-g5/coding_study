package imlist;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7236_저수지의물의총깊이구하기 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[] dr = {-1, 1, 0, 0, 1, -1, -1, 1};
		int[] dc = {0, 0, 1, -1, 1, -1, 1, -1};
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					if(st.nextToken().equals("G")) arr[r][c] = 0;
					else arr[r][c] = 1;
				}
			}
			int answer = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int depth = 0;
					if(arr[r][c] == 1) {
						for (int d = 0; d < 8; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
								if(arr[nr][nc] == 1) depth++;
							}
						}
					}
					answer = Math.max(answer, depth);
				}
			}
			if(answer == 0) answer = 1;
			System.out.println("#" + t + " " +answer);
		}
	}

}
