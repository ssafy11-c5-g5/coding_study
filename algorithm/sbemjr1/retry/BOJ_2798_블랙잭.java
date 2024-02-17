package sbemjr1.retry;

import java.util.Scanner;

public class BOJ_2798_블랙잭 {
	static int N,target,ans, arr[], sel[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		target = sc.nextInt();
		arr = new int[N];
		sel = new int[3];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		combination(0,0,0);
		System.out.println(ans);
	}

	private static void combination(int idx, int k, int sum) {
		if (k == 3) {
			if (sum <= target) {
				ans = Math.max(ans, sum);
			}
			return;
		}
		if (idx == N) {
			return;
		}
		
		sel[k] = arr[idx];
		combination(idx+1, k+1, sum+arr[idx]);
		combination(idx+1, k, sum);
	}

}
