package sbemjr1.retry;

import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {
	static int T,N,L,arr[][],ans;
	static boolean v[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt(); // 제한 칼로리
			arr = new int[N][2]; //맛 칼로리
			v = new boolean[N];
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			combination(0,0,0,0);
			System.out.println(ans);
		}
	}

	private static void combination(int idx, int k, int score, int cal) {
		if (k == N) {
			if (cal <= L) {
				ans = Math.max(ans, score);
			}
			return;
		}
		
		if (cal <= L) {
			v[k] = true;
			combination(idx+1, k+1, score+arr[idx][0], cal+arr[idx][1]);	
		}
		v[k] = false;
		combination(idx+1, k+1, score, cal);
	}

}
