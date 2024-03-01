package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
	static int T,N,M;
	static int[] set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			set = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				set[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(command == 0) {
					//union
					union(a,b);
				} else {
					//find
					if(find(a)!=find(b)) {
						sb.append(0);
					} else {
						sb.append(1);
					}
				}
			}
			System.out.println("#"+tc+" "+sb.toString());
		}
	}
	
	static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA != parentB) {
			set[parentA] = set[parentB];
		}
	}
	
	static int find(int n) {
		if(set[n] == n) {
			return n;
		}
		return set[n] = find(set[n]);
	}

}
