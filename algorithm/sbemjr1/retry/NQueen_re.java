package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NQueen_re {
	static int T,N,board[][],sel[], ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			sel = new int[N];
			ans = 0;
			permutation(0);
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void permutation(int k) {
		if(k == N) {
//			for (int i = 0; i < N; i++) {
//				System.out.print(Arrays.toString(board[i]));
//			}
//			System.out.println();
			ans++;
			return;
		}
		
		for (int c = 0; c < N; c++) {
			if(!check(k,c)) {
				board[k][c] = 1;
				permutation(k+1);
				board[k][c] = 0;
			}
		}
	}

	private static boolean check(int r, int c) {
		//상
		for (int i = r; i >= 0; i--) {
			if(board[i][c] == 1) {
				return true;
			}
		}
		//좌상
		for (int i = r, j = c; i >= 0 && j>=0; i--,j--) {
			if(board[i][j] == 1) {
				return true;
			}
		}
		//우상
		for (int i = r, j = c; i >= 0 && j<N; i--,j++) {
			if(board[i][j] == 1) {
				return true;
			}
		}
		return false;
	}
}
