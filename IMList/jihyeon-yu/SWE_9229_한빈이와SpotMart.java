package imlist;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와SpotMart {
	static int T, N, M, Ans;
	static int[] weight, sel;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			weight = new int[N];
			v = new boolean[N];
			sel = new int[2];
			Ans = -1;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(weight);
			recursive(0, 0, 0);
			System.out.println("#" + t + " " + Ans);
		}
		
	}
	private static void recursive(int idx, int k, int sum) {
		if(k == 2) {
			if(sum <= M) Ans = Math.max(Ans, sum);
			return;
		}
		if(idx == N) return;
		
		sel[k] = weight[idx];
		recursive(idx+1, k+1, sum + weight[idx]);
		recursive(idx+1, k, sum);
		
	}

}
