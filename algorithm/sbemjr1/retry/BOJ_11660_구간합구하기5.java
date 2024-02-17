package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660_구간합구하기5 {
	static int N,M,map[][],ansMap[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+2][N+2];
		ansMap = new int[N+2][N+2];
		
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				ansMap[r][c] = ansMap[r-1][c] + ansMap[r][c-1] - ansMap[r-1][c-1] + map[r][c];
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			System.out.println(ansMap[x2][y2] - ansMap[x2][y1-1] - ansMap[x1-1][y2] + ansMap[x1-1][y1-1]);
		}
	}

}
