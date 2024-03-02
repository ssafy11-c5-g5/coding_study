package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_하나로 {
	static class Vertex implements Comparable<Vertex> {
		int no;
		double weight;
		
		public Vertex(int no, double weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Double.compare(this.weight, o.weight);
		}
		
	}
	
	static class Island {
		int r,c;

		public Island(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static class Node {
		int vertex;
		double weight;
		Node next;
		
		public Node(int vertex, double weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", next=" + next + "]";
		}
	}
	
	static int T,N;
	static double E;
	static Island[] map;
	
	static Node[] adjList;
	static boolean[] v;
	static double[] minDistance;

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			map = new Island[N];
			
			for (int i = 0; i < N; i++) {
				map[i] = new Island(0,0);
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[i].r = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[i].c = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			E = Double.parseDouble(st.nextToken());
			
			adjList = new Node[N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					double d = Math.pow(map[i].r - map[j].r,2) + Math.pow(map[i].c - map[j].c,2);
					
					adjList[i] = new Node(j,d,adjList[i]);
					adjList[j] = new Node(i,d,adjList[j]);
				}
			}
			
			v = new boolean[N];
			
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(0,0));
			int cnt = 0;
			double result = 0.0;
			
			while(!pq.isEmpty()) {
				Vertex minVertex = pq.poll();
				if(v[minVertex.no]) {
					continue;
				}
				result += minVertex.weight;
				v[minVertex.no] = true;
				if(++cnt == N) {
					break;
				}
				for(Node tmp = adjList[minVertex.no]; tmp != null; tmp = tmp.next) {
					if(!v[tmp.vertex]) {
						pq.offer(new Vertex(tmp.vertex, tmp.weight));
					}
				}
			}
			
//			minDistance = new double[N];
//			
//			Arrays.fill(minDistance, Double.MAX_VALUE);
//			
//			minDistance[0] = 0; //시작 시점
//			double result = 0.0;
//			
//			for (int i = 0; i < N; i++) {
//				double min = Double.MAX_VALUE;
//				int minVertex = -1;
//				
//				for (int j = 0; j < N; j++) {
//					if(!v[j] && minDistance[j] < min) {
//						min = minDistance[j];
//						minVertex = j;
//					}
//				}
//				
//				if(minVertex == -1) {
//					break;
//				}
//				v[minVertex] = true;
//				result += min;
//				
//				for(Node tmp = adjList[minVertex]; tmp != null; tmp = tmp.next) {
//					if(!v[tmp.vertex] && minDistance[tmp.vertex] > tmp.weight) {
//						minDistance[tmp.vertex] = tmp.weight;
//					}
//				}
//			}
			
			System.out.println("#"+tc+" "+ Math.round(result * E));
		}
	}

}
