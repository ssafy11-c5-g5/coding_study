package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_강의실배정 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] classList = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			classList[i][0] = Integer.parseInt(st.nextToken()); // start
			classList[i][1] = Integer.parseInt(st.nextToken()); // end
		}
		
		Arrays.sort(classList, (a, b) -> {
			return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(classList[0][1]);
		
		for (int i = 1; i < N; i++) {
			if(pq.peek() <= classList[i][0]) {
				pq.poll();
			}
			pq.offer(classList[i][1]);
		}
		System.out.println(pq.size());
	}
}
