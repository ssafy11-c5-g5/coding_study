package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기 {

    static class Core {
        int y, x;

        public Core(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Core{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }

    static int n, totalEdge, numEdge, ans;
    static int[][] map;
    static List<Core> nonCores;
    static List<Core> cores;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            nonCores = new ArrayList<>();
            cores = new LinkedList<>();

            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1) {
                        nonCores.add(new Core(i, j));
                    }
                }
            }

            checkCore();    // 유효한 코어만 추출

            int res = Integer.MAX_VALUE;
            totalEdge = 0;
            for (int i = 0; i < cores.size(); i++) {
                ans = Integer.MAX_VALUE;
                numEdge = 0;
                dfs(0, 0, 0);
                if (totalEdge < numEdge) {
                    totalEdge = numEdge;
                    res = ans;
                } else if (totalEdge == numEdge) {
                    res = Math.min(ans, res);
                }
                Core core = cores.remove(0);
                cores.add(core);
            }

            if (res == Integer.MAX_VALUE) {
                res = 0;
            }

            System.out.println("#" + tc + " " + res);
        }

    }

    private static void dfs(int idx, int edgeCnt, int cnt) {
        Core core = cores.get(idx);

        for (int i = 0; i < 4; i++) {
            int y = core.y;
            int x = core.x;

            move(i, y + dy[i], x + dx[i], idx, edgeCnt, cnt + 1);
        }

    }


    private static void move(int d, int y, int x, int idx, int edgeCnt, int cnt) {

        if (map[y][x] == 1 || map[y][x] == 2) { // 다른 코어가 있을 경우, 교차될 경우, 현재 값이 ans 보다 크다면 리턴
            return;
        }
        map[y][x] = 2;

        if (x == 0 || y == 0 || x == n - 1 || y == n - 1) {                       // 전원을 공급하면
            edgeCnt++;              // 공급된 간선 수 추가
            if (idx == cores.size() - 1) {  // 마지막 코어까지 전원 공급을 해주었다면 결과 갱신
                if (edgeCnt > numEdge) {
                    numEdge = edgeCnt;
                    ans = cnt;
                } else if (edgeCnt == numEdge){
                    ans = Math.min(ans, cnt);
                }
            } else {                        // 마지막 코어가 아니라면 다음 코어 공급 시작
                if (edgeCnt > numEdge) {
                    numEdge = edgeCnt;
                    ans = cnt;
                } else if (edgeCnt == numEdge) {
                    ans = Math.min(cnt, ans);
                }

                dfs(idx + 1, edgeCnt, cnt);
            }
        } else {        // 전원 공급 경로 진행
            move(d, y + dy[d], x + dx[d], idx, edgeCnt, cnt + 1);
        }
        map[y][x] = 0;
    }

    private static int countCnt() {
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    c++;
                }
            }
        }
        return c;
    }

    static void checkCore() {
        for (Core c : nonCores) {       // 해당 코어가 유효한지 확인
            int cnt = 0;
            L:
            for (int i = 0; i < 4; i++) {
                int y = c.y;
                int x = c.x;
                while (true) {
                    y += dy[i];
                    x += dx[i];

                    if (map[y][x] == 1) {
                        break;
                    } else if (y == 0 || y == n - 1 || x == 0 || x == n - 1) {
                        cnt++;
                        break L;
                    }
                }
            }
            if (cnt > 0) {  // 전원을 공급받지 못하는 코어는 탐색 하지 않음
                cores.add(c);
            }
        }
    }


    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
