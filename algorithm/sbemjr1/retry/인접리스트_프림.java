package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import MST.인접리스트_프림.Node;

public class 인접리스트_프림 {
	static class Node{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static int V,E,minEdge[];
	static Node[] adjList;
	static boolean[] v;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new Node[V];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, weight,adjList[from]);
			adjList[to] = new Node(from, weight,adjList[to]);
		}
		
		v = new boolean[V];
		minEdge = new int[V];
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[0] = 0;
		int result = 0;
		
		for (int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for (int j = 0; j < V; j++) {
				if(minEdge[j] < min && !v[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			
			if(minVertex == -1) {
				break;
			}
			result += min;
			v[minVertex] = true;
			
			for(Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
				if(!v[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
				}
			}
		}
		System.out.println(result);
		
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