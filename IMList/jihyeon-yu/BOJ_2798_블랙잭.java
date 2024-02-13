package imlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {
	static int N, M, Ans;
	static int[] card, sel;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		v = new boolean[N];
		sel = new int[3];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) card[i] = Integer.parseInt(st.nextToken());
		Ans = 0;
		Arrays.sort(card);
		
		recursive(0, 0);
		System.out.println(Ans);

	}

	private static void recursive(int k, int sum) {
		
		if(k == 3) {
			if(sum <= M)Ans = Math.max(Ans, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = card[i];
				recursive(k+1, sum+card[i]);
				v[i] = false;
			}
		}
	}
}
