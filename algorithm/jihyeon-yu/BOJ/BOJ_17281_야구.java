package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {
	static int N, Ans = Integer.MIN_VALUE;
	static boolean[] visit = new boolean[10]; // 선수 선택 배열
	static int[] order = new int[10];
	static int[][] inning;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 이닝 수
		inning = new int[N][10];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1번 선수는 4번 타자로 미리 결정
		order[4] = 1;
		visit[4] = true; // 1번 선수 선택
		
		permutation(2);
		System.out.println(Ans);
		
	}
	
	private static void permutation(int k) {
		if(k == 10) {
			// 순서가 정해지면 경기 시작
			Ans = Math.max(Ans, startBaseball());
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			if(!visit[i]) {
				visit[i] = true;
				order[i] = k;
				permutation(k+1);
				visit[i] = false;
			}
		}
		
	}

	private static int startBaseball() {
		int start = 1;
		int score = 0;
		
		for (int i = 0; i < N; i++) {
			// 경기장 내 주자들의 위치를 저장하기 위한 배열
			int[] location = {0, 0, 0, 0, 0}; // 아웃, 1루, 2루, 3루, 홈
			// 아웃이 3번 되기 전까지 한 이닝 진행
			while(location[0] < 3) {
				run(location, inning[i][order[start]]);
				if(start == 9) start = 1;
				else start++;
			}
			// 한 어닝이 끝나면 점수를 score에 저장
			score += location[4];
		}
		return score;
	}

	private static void run(int[] location, int n) {
		for (int i = 0; i < n; i++) {
			// 홈으로 들어온 주자들의 수는 location[4]에 축적
			location[4] += location[3];
			location[3] = location[2];
			location[2] = location[1];
			location[1] = 0;
		}
		// 이전 주자들을 모두 이동시킨 후 방금 공격한 주자의 위치를 저장
		location[n]++;
	}

}
