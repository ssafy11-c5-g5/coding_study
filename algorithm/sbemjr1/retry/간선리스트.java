package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 간선리스트 {
	static class Edge {
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
		
		
	}
	
	static int V,E;
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
		
		for (int i = 0; i < E; i++) {
			System.out.println(EdgeList.get(i));
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