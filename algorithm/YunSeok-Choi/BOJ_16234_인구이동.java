import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }

    static int n, l, r, openCnt = 1, openSum = 0;
    static boolean checkOpen = false;
    static int[][] map;
    static boolean[][] open;
    static boolean[][] v;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        int ans = 0;

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {

            v = new boolean[n][n];
            checkOpen = false;
            open = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (open[i][j]) {
                        continue;
                    }

                    openCnt = 1;
                    openSum = 0;

                    list = new ArrayList<>();

                    bfs(i, j);          // 연합 찾을 때는 -1

                    int average = openSum / openCnt;

                    for (Node node : list) {
                        map[node.y][node.x] = average;              // 연합국에 평균 값 저장
                    }


                }
            }

            if (!checkOpen) {       // 연합이 없다면 종료
                break;
            }

            ans++;
        }

        System.out.println(ans);

    }

    private static void bfs(int y, int x) {

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(y, x));

        v[y][x] = true;
        open[y][x] = true;
        int sum = map[y][x];
        int cnt = 1;

        while (!q.isEmpty()) {
            Node p = q.poll();
            list.add(p);

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + p.y;
                int nx = dx[i] + p.x;

                if (ny >= 0 && ny < n && nx >= 0 && nx < n && !v[ny][nx]) {

                    int weCnt = Math.abs(map[p.y][p.x] - map[ny][nx]);          // 인구 차이 계산 후 범위 내라면 open[][]을 통해 연합 추가
                    if (weCnt >= l && weCnt <= r) {
                        cnt++;
                        sum += map[ny][nx];
                        checkOpen = true;               // 연합이 있다고 확인하기 위한 checkOpen
                        q.offer(new Node(ny, nx));
                        v[ny][nx] = true;
                        open[ny][nx] = true;
                    }

                }
            }
        }

        openCnt = cnt;
        openSum = sum;

    }

    private static void printMap(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printOpen(boolean[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
