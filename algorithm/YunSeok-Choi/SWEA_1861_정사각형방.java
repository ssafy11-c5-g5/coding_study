import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SWEA_1861_정사각형방 {
    static int n = 0;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static int cnt = 0;
    static int maxCnt = 0;
    static int ansIdx = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            map = new int[n][n];
            maxCnt = 0;
            ansIdx = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cnt = 1;
                    dfs(i, j);                  // 각 위치 마다 dfs를 돌리면서 깊이 확
                    if (cnt == maxCnt) {        // 깊이가 같다면 작은 수가 들어가게 위치
                        if (ansIdx > map[i][j]) {
                            ansIdx = map[i][j];
                        }
                    } else if (cnt > maxCnt) {  // 깊이가 큰 값 저장
                        ansIdx = map[i][j];
                        maxCnt = cnt;
                    }
                }
            }

            System.out.println("#" + test_case + " " + ansIdx + " " + maxCnt);

        }

    }

    private static void dfs(int y, int x) {

        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            if (ny >= 0 && ny < n && nx >= 0 && nx < n) {       // 배열 크기 안에 들어가고 현재 값보다 1이 더 크다면 dfs 진행
                if (map[ny][nx] == map[y][x] + 1) {
                    cnt++;
                    dfs(ny, nx);
                }
            }
        }
    }
}
