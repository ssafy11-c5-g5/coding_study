package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_준환이의양팔저울 {
	static int T,N,arr[],sel[],sum_left, sum_right, ans;
	static boolean v[], isDirection[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			v = new boolean[N];
			sel = new int[N];
			isDirection = new boolean[N];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
//			sum_right = 0;
//			sum_left = 0;
			ans = 0;
			permutation(0);
			
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void permutation(int k) {
		if(k == N) {
			powerSet(0,0,0,0);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = arr[i];
				permutation(k+1);
				v[i] = false;
			}
		}
	}

	private static void powerSet(int idx, int k, int sum_l, int sum_r) {
		if(k == N) {
			if(sum_l >= sum_r) {
				ans++;
			}
			return;
		}
		if(sum_l >= sum_r) {
			isDirection[k] = true;
			powerSet(idx+1,k+1,sum_l + sel[idx], sum_r);
			
			isDirection[k] = false;
			powerSet(idx+1,k+1,sum_l, sum_r + sel[idx]);
		}
		
	}

}
