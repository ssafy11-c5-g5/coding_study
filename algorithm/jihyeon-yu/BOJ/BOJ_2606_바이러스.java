package complete;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2606_바이러스_BFS_DFS {
	static int numComputer, numComputerPair, cntVirus;
	static int[][] map;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		numComputer = sc.nextInt();
		numComputerPair = sc.nextInt();
		
		map = new int[numComputer+2][numComputer+2];
		for (int i = 0; i < numComputerPair; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			map[u][v] = map[v][u] = 1;
		}
		visit = new boolean[numComputer+1];
		cntVirus = 0;
//		bfs(1);
		dfs(1);
		System.out.println(cntVirus);
	}
	
	private static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i);
		visit[i] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for (int j = 0; j < numComputer+1; j++) {
				if(!visit[j] && map[curr][j] != 0) {
					visit[j] = true;
					queue.offer(j);
					cntVirus++;
				}
			}
		}
	}
	
	private static void dfs(int i) {
		visit[i] = true;
		
		for (int j = 0; j < numComputer+1; j++) {
			if(!visit[j] && map[i][j] == 1) {
				cntVirus++;
				dfs(j);
			}
		}
	}
		
}
