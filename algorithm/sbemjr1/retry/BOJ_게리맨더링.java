package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_게리맨더링 {
	static class Node {
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
		
	}
	
	static int N, people[],ans,resultA,resultB;
	static Node[] adjList;
	
	static boolean[] sel;
	static boolean[] vA;
	static boolean[] vB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		adjList = new Node[N+1];
		people = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int command = Integer.parseInt(st.nextToken());
			for (int j = 0; j < command; j++) {
				int to =  Integer.parseInt(st.nextToken());
				
				adjList[i] = new Node(to,adjList[i]);
			}
		}
		
		sel = new boolean[N+1];
		vA = new boolean[N+1];
		vB = new boolean[N+1];
		
		ans = Integer.MAX_VALUE;
		permutation(1);

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	private static void permutation(int k) {
		if(k == N+1) {
			if(check_true(sel) || check_false(sel)) {
				return;
			}
			resultA = 0;
			resultB = 0;
			cal();
			return;
		}
		
		sel[k] = true;
		permutation(k+1);
		sel[k] = false;
		permutation(k+1);
	}

	private static void cal() {
//		for (int i = 1; i <= N; i++) {
//			System.out.print(sel[i]);
//		}
//		System.out.println();
		for (int i = 1; i <= N; i++) {
			vA[i] = sel[i];
			vB[i] = !sel[i];
		}
		
		for (int i = 1; i <= N; i++) {
			if(!vA[i]) {
				vA[i] = true;
				resultA += people[i];
				dfsA(i);
				break;
			}
		}
		for (int i = 1; i <= N; i++) {
			if(!vB[i]) {
				vB[i] = true;
				resultB += people[i];
				dfsB(i);
				break;
			}
		}
		
		if(check_true(vA) && check_true(vB)) {
			int result = Math.abs(resultA - resultB);
			ans = Math.min(ans, result);
		}
	}

	private static void dfsA(int cur) {
		for(Node tmp = adjList[cur]; tmp != null; tmp = tmp.next) {
			if(!vA[tmp.vertex]) {
				resultA += people[tmp.vertex];
				vA[tmp.vertex] = true;
				dfsA(tmp.vertex);
			}
		}
	}
	
	private static void dfsB(int cur) {
		for(Node tmp = adjList[cur]; tmp != null; tmp = tmp.next) {
			if(!vB[tmp.vertex]) {
				resultB += people[tmp.vertex];
				vB[tmp.vertex] = true;
				dfsB(tmp.vertex);
			}
		}
	}

	private static boolean check_false(boolean[] v) {
		for (int i = 1; i <= N; i++) {
			if(v[i]) {
				return false;
			}
		}
		return true;
	}

	private static boolean check_true(boolean[] v) {
		for (int i = 1; i <= N; i++) {
			if(!v[i]) {
				return false;
			}
		}
		return true;
	}
	
}
