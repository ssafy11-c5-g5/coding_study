package complete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17471_게리맨더링 {
	static int N; // 지역의 개수
	static int[] population; // 각 지역의 인구 수
	static List<List<Integer>> graph; // 각 지역 별 인접 구역 목록
	static boolean[] selected; // 부분집합 선택 여부
	static boolean[] visited; // BFS 시 방문 여부
	static int result; // 최소 인구 차이 결과
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		result = Integer.MAX_VALUE;
		population = new int[N];
		selected = new boolean[N];
		graph = new ArrayList<>();
		
		// 인구 수 입력
		for (int i = 0; i < N; i++) {
			population[i] = sc.nextInt();
		}
		
		// 인접 구역 정보 입력
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
			int cnt = sc.nextInt();
			for (int j = 0; j < cnt; j++) {
				int num = sc.nextInt() - 1;
				graph.get(i).add(num);
			}
		}
		
		divide(0); // 선거구 분할 시작
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	private static void divide(int idx) {
		if(idx == N) {
			List<Integer> aGroup = new ArrayList<>();
			List<Integer> bGroup = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if(selected[i]) aGroup.add(i);
				else bGroup.add(i);
			}
			// 한 선거구에 모든 지역이 포함되어서는 안됨
			if(aGroup.isEmpty() || bGroup.isEmpty()) return;
			
			// 두 선거구가 각각 연결되어 있는지 확인
			if(isConnected(aGroup) && isConnected(bGroup)) getPopulationDiff();
			return;
		}
		
		selected[idx] = true; // aGroup에 포함시키는 경우
		divide(idx+1);
		selected[idx] = false; // aGroup에 포함시키지 않는 경우
		divide(idx+1);
		
	}

	private static boolean isConnected(List<Integer> group) {
		visited = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(group.get(0));
		visited[group.get(0)] = true;
		
		int cnt = 1;
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for(int next : graph.get(curr)) {
				if(!visited[next] && group.contains(next)) {
					queue.offer(next);
					visited[next] = true;
					cnt++;
				}
			}
		}
		return cnt == group.size();
	}
	
	private static void getPopulationDiff() {
		int aPopulation = 0;
		int bPopulation = 0;
		for (int i = 0; i < N; i++) {
			if(selected[i]) aPopulation += population[i];
			else bPopulation += population[i];
		}
		int diff = Math.abs(aPopulation - bPopulation);
		result = Math.min(result, diff);
	}
}
