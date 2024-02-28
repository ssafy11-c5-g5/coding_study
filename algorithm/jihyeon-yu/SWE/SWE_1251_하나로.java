package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


// 세금: E * L^2 (L: 해저 터널의 길이)
public class SWE_1251_하나로 {
	
	static class Node implements Comparable<Node>{
		int a, b;
		double distance;

		public Node(int a, int b, double distance) {
			super();
			this.a = a;
			this.b = b;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.distance, o.distance);
		}

		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + ", distance=" + distance + "]";
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 섬의 개수
			
			int[] parent = new int[N+1];
			for (int i = 0; i < N+1; i++) {
				parent[i] = i;
			}
			// 섬들의 좌표값 저장
			int[] xCoordinates = new int[N];
			int[] yCoordinates = new int[N];
			for (int i = 0; i < N; i++) {
				xCoordinates[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				yCoordinates[i] = sc.nextInt();
			}
			// 환경 부담 세율 실수
			double E = sc.nextDouble();
			// 간선의 개수
			int M = N * (N-1);
			Node[] edgeList = new Node[M];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				int x1 = xCoordinates[i];
				int y1 = yCoordinates[i];
				for (int j = 0; j < N; j++) {
					if(i == j) continue;
					int x2 = xCoordinates[j];
					int y2 = yCoordinates[j];
					double distance = getDistance(x1, y1, x2, y2);
					edgeList[idx++] = new Node(i, j, distance);
				}
			}
			
			Arrays.sort(edgeList);
			
			double result = 0;
			for(Node e : edgeList) {
				int a = e.a;
				int b = e.b;
				double distance = e.distance;
				if(findParent(parent, a) != findParent(parent, b)) {
					unionParent(parent, a, b);
					// 세금: 각각의 거리에 대하여 E * L^2 (L: 해저 터널의 길이)
					result += E * Math.pow(distance, 2);;
				}
			}
			System.out.println("#" + t + " " + Math.round(result));
		}
	}
	
	private static void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}

	private static int findParent(int[] parent, int x) {
		if(parent[x] != x) {
			parent[x] = findParent(parent, parent[x]);
		}
		return parent[x];
	}

	private static double getDistance(int x1, int y1, int x2, int y2) {
		double xDistSquare = Math.pow(x1-x2, 2);
		double yDistSquare = Math.pow(y1-y2, 2);
		double distance = Math.sqrt(xDistSquare + yDistSquare);
		return distance;
	}
}
