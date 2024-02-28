package practice;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1647_도시분할계획 {
	static class Node implements Comparable<Node>{
		int a, b, cost;

		public Node(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] parent = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
		
		Node[] edges = new Node[M];
		int result = 0;
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			edges[i] = new Node(a, b, cost);
		}
		
		Arrays.sort(edges);
		int last = 0;
		for (int i = 0; i < M; i++) {
			int a = edges[i].a;
			int b = edges[i].b;
			int cost = edges[i].cost;
			// 사이클이 발생하는지 확인
			if(findParent(parent, a) != findParent(parent, b)) {
				unionParent(parent, a, b);
				result += cost;
				last = cost;
			}
		}
		System.out.println(result-last);
	}
	
	private static int findParent(int[] parent, int x) {
		if(parent[x] != x) {
			parent[x] = findParent(parent, parent[x]);
		}
		return parent[x];
	}
	
	private static void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}

}
