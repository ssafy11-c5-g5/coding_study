package algorithm.hw.hw0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWE_1861_정사각형방 {

    static int[][] graph;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];

            for (int i = 0; i < N; i++) {
                graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int answer = 0;
            int data = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    chk = 0;
                    dfs(i, j, 1);
                    //System.out.println("r: " + i + ", c: " + j + ", cnt: " + chk);

                    if (answer < chk) {
                        answer = chk;
                        data = graph[i][j];
                    } else if (answer == chk) {
                        data = Math.min(data, graph[i][j]);
                    }
                }
            }

            System.out.println("#" + tc + " " + data + " " + answer);
        }
    }

    static int chk;
    private static void dfs(int r, int c, int cnt) {
        chk = Math.max(chk, cnt);
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
//            System.out.println(r + " " + c + " " + nr + " " + nc + " ");
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                continue;
            }
            if (graph[nr][nc] - graph[r][c] == 1) {
//                System.out.println("enter");
                dfs(nr, nc, cnt + 1);
            }
        }
    }
}
