package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_3124_최소스패닝트리_크루스칼 {
	static class Edge implements Comparable<Edge>{
		int from,to,weigth;

		public Edge(int from, int to, int weigth) {
			this.from = from;
			this.to = to;
			this.weigth = weigth;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weigth, o.weigth);
		}
	}
	
	static int T,V,E;
	static ArrayList<Edge> edgeList;
	
	static int[] set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new ArrayList<>();
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				edgeList.add(new Edge(from,to,weight));
			}
			
			Collections.sort(edgeList);
			
			makeSet();
			
			int cnt = 0;
			long sum_weight = 0;
			for (Edge edge : edgeList) {
				if(!union(edge.from, edge.to)) {
					continue;
				}
				sum_weight += edge.weigth;
				if(++cnt == V) {
					break;
				}
			}
			System.out.println("#"+tc+" "+sum_weight);
		}
	}

	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) {
			return false;
		}
		set[rootA] = set[rootB];
		return true;
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
