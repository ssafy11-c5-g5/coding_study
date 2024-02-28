package complete;

import java.util.Scanner;

public class SWE_3289_서로소집합_find_union {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] parent = new int[n+1];
			for (int i = 0; i < n+1; i++) {
				parent[i] = i;
			}
			for (int i = 0; i < m; i++) {
				int operation = sc.nextInt(); // 0 union 1 find
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(operation == 0) {
					union(parent, a, b);
				} else {
					sb.append(find(parent, a) == find(parent, b) ? 1 : 0);
				}
			}
			System.out.println("#" + t + " " + sb);
			sb.setLength(0);
		}

	}

	private static void union(int[] parent, int a, int b) {
		a = find(parent, a);
		b = find(parent, b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
		
	}

	private static int find(int[] parent, int x) {
		if(parent[x] != x) {
			parent[x] = find(parent, parent[x]);
		}
		return parent[x];
	}

}
