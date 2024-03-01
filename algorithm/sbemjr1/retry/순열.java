package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열 {
	static int N,M;
	static int[] arr;
	static int[] sel;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sel = new int[M];
		v = new boolean[N+1];
		
		recursive(1, 0);
	}

	private static void recursive(int idx, int k) {
		if(k == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		if(idx==N+1) {
			return;
		}
		
		sel[k] = idx;
		recursive(idx, k+1);
		recursive(idx+1, k);
	}
	
}

