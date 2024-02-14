package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992_쿼드트리 {
	static int N;
	static int[][] map;
	StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		quadTree(0, 0, N);
	}
	
	private static void quadTree(int r, int c, int n) {
		boolean flag = true;
		int curr = map[r][c];
		L: for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(curr != map[r+i][c+j]) {
					flag = false;
					break L;
				}
			}
		}
		if(flag) System.out.print(curr);
		else {
			System.out.print("(");
			n /= 2;
			quadTree(r, c, n); // (0, 0) 부터 n/2 만큼 확인
			quadTree(r, c+n, n); // (0, n/2) 부터 n/2 만큼 확인
			quadTree(r+n, c, n); // (n/2, 0) 부터 n/2 만큼 확인
			quadTree(r+n, c+n, n); // (n/2, n/2) 부터 n/2 만큼 확인
			System.out.print(")");
		}
	}
}
