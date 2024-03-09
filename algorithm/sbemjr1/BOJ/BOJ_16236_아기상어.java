package sbemjr1.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	static class Shark {
		int r,c,weight;

		public Shark(int r, int c, int weight) {
			this.r = r;
			this.c = c;
			this.weight = weight;
		}
	}
	
	static class Fish {
		int r,c,length;

		public Fish(int r, int c, int length) {
			super();
			this.r = r;
			this.c = c;
			this.length = length;
		}
	}
	
	static class Target implements Comparable<Target>{
		int r,c,distance;

		public Target(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "Target [r=" + r + ", c=" + c + ", distance=" + distance + "]";
		}

		@Override
		public int compareTo(Target o) {
			if(Integer.compare(this.distance, o.distance) == 0) {
				return Integer.compare(this.r, o.r);
			}
			if(Integer.compare(this.distance, o.distance) == 0 && Integer.compare(this.r, o.r) == 0) {
				return Integer.compare(this.c, o.c);
			}
			
			return Integer.compare(this.distance, o.distance);
		}
	}
	
	static int N, map[][], ans, dist, l;
	static Shark babyShark;
	
	static boolean[][] v;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				// 상어 위치 찾기(초기 상어 크기 2)
				if(map[r][c] == 9) {
					babyShark = new Shark(r,c,2);
					map[r][c] = 0;
				}
			}
		}
		
		//조건에 맞는 물고기 우선순위 큐에 넣기
		//조건
		//갈 수 있는지? 갈 수 있는 경우 - 본인 몸집보다 작거나 같은 경우 - 이동 가능
		//먹을 수 있는지? 본인 몸집보다 작은 경우 - 먹기 가능
		//비교 조건
		//1.가까운 것 2.위에 있는 것 3.왼쪽에 있는 것
		PriorityQueue<Target> pq = new PriorityQueue<>();
		
		//몸집 키우기 (자기 몸무게 만큼 먹으면 1성장)
		int cnt = 0;
		while(true) {
			pq.clear();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] > 0 && babyShark.weight > map[r][c]) { // 먹을 수 있거나 물고기가 있을 때
						v = new boolean[N][N];
						dist = 0;
						if(bfs(r,c)) { // 최단 거리 확인 및 갈 수 있는지 확인(물고기 -> 상어)
							pq.offer(new Target(r,c,dist));
						}
					}
				}
			}
//			System.out.println(pq);
//			System.out.println(pq.peek());
			if(pq.isEmpty()) { // 갈 수 있는 곳이 없는 경우
				break;
			}
			Target result = pq.poll();
			cnt++;//먹은 물고기 마리수
			ans += result.distance; //결과물
			//상어 위치 갱신
			babyShark.r = result.r;
			babyShark.c = result.c;
//			babyShark.weight = result.distance;
			//자기 몸무게만큼 먹었으면 1 성장
			if(cnt == babyShark.weight) {
				babyShark.weight++;
				cnt = 0;
			}
//			System.out.println(babyShark.weight);
			map[result.r][result.c] = 0;
//			print();
//			sc.nextLine();
		}
		
		System.out.println(ans);
	}

	private static boolean bfs(int r, int c) {
		Queue<Fish> q = new ArrayDeque<>();
		q.offer(new Fish(r,c,0));
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			Fish f = q.poll();
			int nowR = f.r;
			int nowC = f.c;
			int nowL = f.length;
//			System.out.println(nowR+" "+nowC);
//			System.out.println(babyShark.r);
//			System.out.println(babyShark.c);
			
			if(nowR == babyShark.r && nowC == babyShark.c) {
				dist = nowL;
//				System.out.println(nowL);
				return true;
			}
			
			for (int d = 0; d < 4; d++) {
				int nextR = nowR + dr[d];
				int nextC = nowC + dc[d];
				int nextL = nowL + 1;
				
				if(nextR<0 || nextR>=N || nextC<0 || nextC>=N) {
					continue;
				}
				if(map[nextR][nextC] > babyShark.weight) { // 이동할 수 있는지 상어보다 작거나 작아야 함
					continue;
				}
				if(v[nextR][nextC]) {
					continue;
				}
				v[nextR][nextC] = true;
				q.offer(new Fish(nextR,nextC,nextL));
			}
		}
		return false;
	}
}
