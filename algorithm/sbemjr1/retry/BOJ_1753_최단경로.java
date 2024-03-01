package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static class Node {
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex implements Comparable<Vertex> {
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V,E,K; // K는 시작 정점
	static Node[] adjList;
	
	static boolean[] v;
	static int[] minDistance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		adjList = new Node[V+1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to,weight,adjList[from]);
		}
		
		v = new boolean[V+1];
		minDistance = new int[V+1];
		
		Arrays.fill(minDistance, Integer.MAX_VALUE);
		
		int cnt = 0;
		minDistance[K] = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(K, minDistance[K]));
		
		while(!pq.isEmpty()) {
			Vertex minVertex = pq.poll();
			if(v[minVertex.no]) continue;
			v[minVertex.no] = true;
			if(++cnt == V) break;
			
			for(Node tmp = adjList[minVertex.no]; tmp != null; tmp = tmp.next) {
				if(!v[tmp.vertex] && minDistance[tmp.vertex] > minVertex.weight + tmp.weight) {
					minDistance[tmp.vertex] = minVertex.weight + tmp.weight;
					pq.offer(new Vertex(tmp.vertex, minVertex.weight + tmp.weight));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			System.out.println(minDistance[i] == Integer.MAX_VALUE ? "INF" : minDistance[i]);
		}
	}

}
