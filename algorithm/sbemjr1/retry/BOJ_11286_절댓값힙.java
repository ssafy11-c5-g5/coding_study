package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11286_절댓값힙 {
	static class Number implements Comparable<Number> {
		int num;

		public Number(int num) {
			this.num = num;
		}

		@Override
		public String toString() {
			return num+"";
		}

		@Override
		public int compareTo(Number o) {
			return Math.abs(this.num) != Math.abs(o.num) ? Math.abs(this.num) - Math.abs(o.num) : this.num - o.num;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Number> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (n != 0) {
				pq.add(new Number(n));
			} else {
				if(!pq.isEmpty()) {
					System.out.println(pq.poll());	
				} else {
					System.out.println(0);
				}
			}
		}
	}

}
