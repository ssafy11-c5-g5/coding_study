package homework;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1954_달팽이숫자2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int cnt = 1;
			int[][] snail = new int[N][N];
			int x = -1, y = 0; // 모든 경우에서 한 칸 앞에서 시작하여 n만큼 x방향, n-1만큼 y방향으로 이동
		
			// n단계는 N부터 1까지
			for (int n = N; n > 0; n--) {
				for (int i = 0; i < n; i++) {
					// x방향 이동 처리
					x += (n % 2 == N % 2)? 1 : -1;
					snail[y][x] = cnt;
					cnt++;
				}
				for (int i = 0; i < n-1; i++) {
					// y방향 이동 처리
					y += (n % 2 == N % 2)? 1 : -1;
					snail[y][x] = cnt;
					cnt++;
				}
			}
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
		
	}
}
