package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 간선리스트_크루스칼 {
	static class Edge implements Comparable<Edge> {
		int from,to,weigth;

		public Edge(int from, int to, int weigth) {
			this.from = from;
			this.to = to;
			this.weigth = weigth;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weigth=" + weigth + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weigth, o.weigth);
		}
		
	}
	
	static int V,E,ans;
	static int set[];
	static ArrayList<Edge> EdgeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		EdgeList = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			EdgeList.add(new Edge(from,to,weight));
		}
		
		// 가중치 기준으로 정렬
		Collections.sort(EdgeList);
		
		// make-set
		makeSet();
		
		int cnt = 0;
		int w_sum = 0;
		// 가중치 낮은 순으로 union, 같은 보스를 가지고 있으면 넘어가기
		for (Edge edge : EdgeList) {
			if(!union(edge.from, edge.to)) {
				continue;
			}
			w_sum += edge.weigth;
			cnt++;
			if(cnt == V) {
				break;
			}
		}
		
		System.out.println(w_sum);
	}

	private static void makeSet() {
		set = new int[V];
		for (int i = 0; i < V; i++) {
			set[i] = i;
		}
	}
	
	private static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA == parentB) {
			return false;
		}
		set[parentA] = set[parentB];
		return true;
	}
			
	private static int find(int num) {
		if(set[num] == num) {
			return num;
		}
		return set[num] = find(set[num]);
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