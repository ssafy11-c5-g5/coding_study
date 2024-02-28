package sbemjr1.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
	static int N,M, sr, sc, direction, map[][], ans;
	static int dr[] = {-1,0,1,0}; // 북 서 남 동 (반시계 방향)
	static int dc[] = {0,-1,0,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());

		direction = direction == 0 ? 0 : direction == 1 ? 3 : direction == 2 ? 2 : direction == 3 ? 1 : 1234;

		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 1;
		map[sr][sc] = 2;
		
		while(true) {
			if (check()) {
				direction++;
				if (direction == 4) {
					direction = 0;
				}
				if (map[sr + dr[direction]][sc + dc[direction]] == 0) { // 진행 방향에 청소 가능 인지
					sr = sr + dr[direction];
					sc = sc + dc[direction];
					
					map[sr][sc] = 2;
					ans++;
				}
			} else { // 청소할 곳이 없음
				if (map[sr - dr[direction]][sc - dc[direction]] != 1) {
					sr = sr - dr[direction];
					sc = sc - dc[direction];
				} else if (map[sr - dr[direction]][sc - dc[direction]] == 1) {
					System.out.println(ans);
					break;
				}
			}
		}
	}

	private static boolean check() { // 청소할 곳이 있는지 없는지
		for (int d = 0; d < 4; d++) {
			int nr = sr + dr[d];
			int nc = sc + dc[d];
			
			if(map[nr][nc] == 0) {
				return true;
			}
		}
		return false;
	}

}
