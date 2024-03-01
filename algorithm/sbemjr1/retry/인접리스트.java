package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 인접리스트 {
	static class Node {
		int to, weight;
		Node next;
		
		public Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", weight=" + weight + ", next=" + next + "]";
		}
	}
	
	static class Node2 {
		int to, weight;

		public Node2(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node2 [to=" + to + ", weight=" + weight + "]";
		}
		
		
	}
	
	static int V,E;
	static Node[] adjList;
	static ArrayList[] adjList2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new Node[V];
		adjList2 = new ArrayList[V];
		
		for (int i = 0; i < V; i++) {
			adjList2[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to,weight,adjList[from]);
			
			adjList2[from].add(new Node2(to, weight));
		}
		
//		for (Node node : adjList) {
//			System.out.println(node);
//		}
		
		for (int i = 0; i < V; i++) {
			System.out.println(adjList2[i]);
		}
	}

}

/*
V E
from to weigh 의 순서

7 11
0 1 31
0 2 31
0 6 31
0 5 60
1 2 21
2 4 46
2 6 25
3 4 34
4 6 51
5 3 18
5 4 40 
*/