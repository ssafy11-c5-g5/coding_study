package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import sbemjr1.retry.SWEA_창용마을.Node;

public class SWEA_창용마을_DFS {
	static class Node {
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	static int T,V,E,ans;
	static Node[] adjList;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adjList = new Node[V+1]; // 0은 더미
			v = new boolean[V+1];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjList[from] = new Node(to,adjList[from]);
				adjList[to] = new Node(from,adjList[to]);
			}
			
			ans=0;
			for (int i = 1; i <= V; i++) {
				if(!v[i]) {
					dfs(i);
					ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void dfs(int cur) {
		
		for(Node tmp = adjList[cur]; tmp != null; tmp = tmp.next) {
			if(!v[tmp.vertex]) {
				v[tmp.vertex] = true;
				dfs(tmp.vertex);
			}
		}
	}

}
