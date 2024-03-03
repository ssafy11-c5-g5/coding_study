package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기2 {
	static class Point {
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	
	static class Node {
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
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
	
	static class Vertex implements Comparable<Vertex> {
		int node,weight;

		public Vertex(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int N,M,ans,cnt,numberling;
	static int[][] map;
	static boolean[] v, bfs_v;
	static int[] minDistance;
	
	static int[] dr = {1, 0, -1, 0}; // 상 좌 하 우
	static int[] dc = {0, 1, 0, -1};
	
	static Node[] adjList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		numberling = 2;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map[r][c] == 1) {
					markNumber(r,c,numberling++); // 구역에 따른 넘버링
				}
			}
		}
		
		adjList = new Node[numberling+1];
		
		for (int i = 2; i < numberling; i++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(map[r][c] == i) {
						for (int d = 0; d < 4; d++) {
							findBridge(r, c, d, i);
						}
					}
				}
			}
		}
		
		v = new boolean[numberling];
		minDistance = new int[numberling];
		
		Arrays.fill(minDistance, Integer.MAX_VALUE);
		minDistance[2] = 0; //시작시점
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(2, minDistance[2]));
		
		int result = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			Vertex minVertex = pq.poll();
			if(v[minVertex.node]) {
				continue;
			}
			v[minVertex.node] = true;
			result += minVertex.weight;
			if(++cnt == numberling-2) {
				break;
			}
			
			for(Node tmp = adjList[minVertex.node]; tmp != null; tmp = tmp.next) {
				if(!v[tmp.vertex] && minDistance[tmp.vertex] > tmp.weight) {
					minDistance[tmp.vertex] = tmp.weight;
					pq.offer(new Vertex(tmp.vertex, tmp.weight));
				}
			}
		}

		if(cnt != numberling - 2 || result == 0) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	private static void findBridge(int r, int c, int d, int num) {
		int nr = r;
		int nc = c;
		
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M) {
				break;
			}
			if(map[nr][nc] == num) {
				break;
			}
			if(map[nr][nc] > num) {
				int distance = Math.abs(nr - r) + Math.abs(nc - c) - 1;
				if(distance >= 2) {
					adjList[num] = new Node(map[nr][nc], distance, adjList[num]);
					adjList[map[nr][nc]] = new Node(num, distance, adjList[map[nr][nc]]);
				}
				break;
			}
			if(map[nr][nc] != 0) {
				break;
			}
		}
	}

	private static void markNumber(int r, int c, int num) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(r,c));
		map[r][c] = num;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int nowR = p.r;
			int nowC = p.c;
			
			for (int d = 0; d < 4; d++) {
				int nextR = nowR + dr[d];
				int nextC = nowC + dc[d];
				
				if(nextR<0 || nextR>=N || nextC<0 || nextC>=M) {
					continue;
				}
				if(map[nextR][nextC] != 1) {
					continue;
				}
				map[nextR][nextC] = num;
				q.offer(new Point(nextR,nextC));
			}
		}
	}

}
