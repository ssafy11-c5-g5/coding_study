package sbemjr1.SWE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D3_진기의최고급붕어빵 {
	static int T,N,M,K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Integer> cus = new PriorityQueue<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cus.add(Integer.parseInt(st.nextToken()));
			}
			
			int remain = 0;
			boolean flag = false;
			
			L:for (int i = 1; i <= 11111; i++) {
				if (i % M == 0) {
					remain += K;
				}
				
				if (cus.isEmpty()) {
					break;
				}
				
				if (cus.peek() == 0) {
					System.out.println("#"+tc+" "+"Impossible");
					flag = true;
					break;
				}
				
				while (!cus.isEmpty() && cus.peek() == i) {
					cus.poll();
					remain--;
					if (remain < 0) {
						System.out.println("#"+tc+" "+"Impossible");
						flag = true;
						break L;
					}
				}
			}
			if (!flag) {
				System.out.println("#"+tc+" "+"Possible");
			}
			
		}
	}
}
