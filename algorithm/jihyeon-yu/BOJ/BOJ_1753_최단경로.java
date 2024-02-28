package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static class Node{
		int idx, cost;

		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
	}
	static List<List<Node>> graph;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 출발 지점
		int INF = Integer.MAX_VALUE;
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < V+1; i++) {
			graph.add(new ArrayList<>());
		}
		// 인접 리스트 생성
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, cost));
		}
		
		int[] minDistance = new int[V+1];
		boolean[] visit = new boolean[V+1];
		
		Arrays.fill(minDistance, INF);
		minDistance[K] = 0; // 출발지에서 출발지로의 비용 0으로 초기화
		
		// 다익스트라, 모든 노드를 방문하면 종료하기 때문에, 노드의 개수만큼만 반복
		for (int i = 0; i < V; i++) {
			int nodeVal = Integer.MAX_VALUE;
			int nodeIdx = 0;
			for (int j = 1; j < V+1; j++) {
				if(!visit[j] && minDistance[j] < nodeVal) {
					nodeVal = minDistance[j];
					nodeIdx = j;
				}
			}
			visit[nodeIdx] = true;
			
			for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
				Node adjNode = graph.get(nodeIdx).get(j);
				if(minDistance[adjNode.idx] > minDistance[nodeIdx] + adjNode.cost) {
					minDistance[adjNode.idx] = minDistance[nodeIdx] + adjNode.cost;
				}
			}
		}
		
		for (int i = 1; i < V+1; i++) {
			if(minDistance[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(minDistance[i]).append("\n");
			}
		}
		
		System.out.println(sb);
		sb.setLength(0);
	}

}
