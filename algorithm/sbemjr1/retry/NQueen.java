package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NQueen {
	static int T,N,board[][],ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			board = new int[N][N];
			ans = 0;
			
			recursive(0);
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void recursive(int r) {
		if(r == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(check(r,i)) {
				board[r][i] = 1;
				recursive(r+1);
				board[r][i] = 0;
			}
		}
	}

	private static boolean check(int r, int c) {
		for (int i = r; i >= 0; i--) {
			if(board[i][c] == 1) {
				return false;
			}
		}
		for (int i = r, j = c; i >= 0 && j >= 0; i--,j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		for (int i = r, j = c; i >= 0 && j < N; i--,j++) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

}
