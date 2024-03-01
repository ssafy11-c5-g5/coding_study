package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import sbemjr1.retry.SWEA_창용마을_DFS.Node;

public class SWEA_창용마을_서로소집합 {
	static class Node {
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	static int T,V,E;
	static Node[] adjList;
	
	static int[] set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
//			adjList = new Node[V+1]; // 0은 더미
//			
//			for (int i = 0; i < E; i++) {
//				st = new StringTokenizer(br.readLine());
//
//				int from = Integer.parseInt(st.nextToken());
//				int to = Integer.parseInt(st.nextToken());
//				
//				adjList[from] = new Node(to,adjList[from]);
//				adjList[to] = new Node(from,adjList[to]);
//			}
			
			makeSet();
			
			int cnt = 0;
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				union(from,to);
			}
			
			for (int i = 1; i <= V; i++) {
				System.out.println(set[i]);
			}
			
			ArrayList<Integer> ans = new ArrayList<>();
			
			for (int i = 1; i <= V; i++) {
				if(!ans.contains(find(set[i]))) {
					ans.add(set[i]);
				}
			}
			
			System.out.println(ans.size());
		}
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA <= rootB) {
			set[rootB] = set[rootA];
		} else {
			set[rootA] = set[rootB];
		}
	}

	private static int find(int num) {
		if(set[num] == num) {
			return num;
		}
		return set[num] = find(set[num]);
	}

	private static void makeSet() {
		set = new int[V+1];
		for (int i = 1; i <= V; i++) {
			set[i] = i;
		}
	}

}
