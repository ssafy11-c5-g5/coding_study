package sbemjr1.retry;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 인접리스트_프림_PQ {
	// 그래프의 각 정점을 표현하는 클래스
	static class Node{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
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
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("homework.txt"));
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점 수
		int E = sc.nextInt(); // 간선 수
		
		Node[] adjList = new Node[V]; // 각 정점의 인접 리스트의 헤드 저장
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		
		// 최소 간선 배열, 노드 방문 배열
		int[] minEdge = new int[V];
		boolean[] visit = new boolean[V];
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[0] = 0; // 임의의 시작점 처리
		int result = 0; // 간선 비용 누적
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>(); // 우선 순위 큐
		pq.offer(new Vertex(0, minEdge[0])); // 시작 정점을 우선 순위 큐에 삽입
		
		int cnt = 0;
		while(!pq.isEmpty()) {
			// step 1: 비트리 정점 중 최소 간선 비용의 정점 찾기
			Vertex minVertex = pq.poll();
			if(visit[minVertex.no]) continue;
			result += minVertex.weight;
			visit[minVertex.no] = true;
			if(++cnt == V) break;
			
			// step 2: 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점들과 간선 비용을 고려하여 최적으로 업데이트
			for (Node temp = adjList[minVertex.no]; temp != null; temp = temp.next) {
				if(!visit[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
					pq.offer(new Vertex(temp.vertex, temp.weight));
				}
			}
			
		}
		System.out.println(cnt == V ? result : -1);

	}

}
