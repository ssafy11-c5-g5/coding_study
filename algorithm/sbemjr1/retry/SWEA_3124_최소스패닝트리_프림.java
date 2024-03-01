package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_3124_최소스패닝트리_프림 {
	static class Node {
		int to, weight;
		Node next;
		
		public Node(int to, int weight, Node next) {
			super();
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return "Node [to=" + to + ", weight=" + weight + ", next=" + next + "]";
		}
	}
	
	// Prim 알고리즘에 사용되는 정점을 표현하는 클래스
		static class Vertex implements Comparable<Vertex>{
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
	
	static int T,V,E;
	static Node[] adjList;
	
	static boolean[] v;
	static int[] minDistance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adjList = new Node[V+1];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				adjList[from] = new Node(to,weight,adjList[from]);
				adjList[to] = new Node(from,weight,adjList[to]);
			}
			
			v = new boolean[V+1];
			minDistance = new int[V+1];
			
			Arrays.fill(minDistance, Integer.MAX_VALUE);
			
			minDistance[1] = 0;
			long result = 0;
			
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(1, minDistance[1]));
			
			int cnt = 1;
			while(!pq.isEmpty()) {
				Vertex minVertex = pq.poll();
				if(v[minVertex.no]) continue;
				result += minVertex.weight;
				v[minVertex.no] = true;
				if(++cnt == V+1) break;
				
				for(Node tmp = adjList[minVertex.no]; tmp != null; tmp = tmp.next) {
					if(!v[tmp.to] && minDistance[tmp.to] > tmp.weight) {
						minDistance[tmp.to] = tmp.weight;
						pq.offer(new Vertex(tmp.to, tmp.weight));
					}
				}
			}
			System.out.println("#"+tc+" "+result);
			
//			for (int i = 1; i <= V; i++) {
//				int min = Integer.MAX_VALUE;
//				int minVertex = -1;
//				
//				for (int j = 1; j <= V; j++) {
//					if(!v[j] && minDistance[j] < min) {
//						min = minDistance[j];
//						minVertex = j;
//					}
//				}
//				
//				if(minVertex == -1) {
//					break;
//				}
//				result += min;
//				v[minVertex] = true;
//				
//				for(Node tmp = adjList[minVertex]; tmp != null; tmp = tmp.next) {
//					if(minDistance[tmp.to] > tmp.weight) {
//						minDistance[tmp.to] = tmp.weight;
//					}
//				}
//			}
			
			System.out.println("#"+tc+" "+result);
		}
	}

}


