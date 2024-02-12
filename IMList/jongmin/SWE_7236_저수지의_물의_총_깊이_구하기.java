package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_7236_저수지의_물의_총_깊이_구하기 {
    static String[][] graph;
    static int N;
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {1, 0, -1, -1, -1, 0, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T+1; tc++) {
            N = Integer.parseInt(br.readLine());
            graph = new String[N][N];

            for (int i = 0; i < N; i++) {
                graph[i] = br.readLine().split(" ");
            }

            int maxDepth = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j].equals("W")) {
                        maxDepth = Math.max(maxDepth, calDepth(i, j));
                    }
                }
            }

            System.out.println("#" + tc + " " + maxDepth);
        }
    }

    private static int calDepth(int r, int c) {
        int wCnt = 0;
        int gCnt = 0;

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                continue;
            }
            if (graph[nr][nc].equals("W")) {
                wCnt++;
            } else if (graph[nr][nc].equals("G")) {
                gCnt++;
            }
        }

        if (wCnt == 0 && gCnt != 0) {
            return 1;
        }
        return wCnt;
    }
}
