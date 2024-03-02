package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_11286_절댓값힙 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				(o1,o2) -> Math.abs(o1) - Math.abs(o2) != 0 ? Math.abs(o1) - Math.abs(o2) : o1 - o2
				);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int command = Integer.parseInt(st.nextToken());
			
			if(command != 0) {
				pq.offer(command);
			} else {
				if(pq.isEmpty()) {
					sb.append(0+"\n");
				}else {
					sb.append(pq.poll()+"\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
