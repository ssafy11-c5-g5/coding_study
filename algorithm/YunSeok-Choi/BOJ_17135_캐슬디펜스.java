import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {
    static int n, m, d, max = Integer.MIN_VALUE;
    static int[] arr;
    static int[] sel;
    static int[][] map;
    static int[] dy = { 0, -1, 0 };
    static int[] dx = { -1, 0, 1 };

    static class Node {
        int y, x, cnt;

        public Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()) + 1;
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        arr = new int[m];
        sel = new int[3];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 궁수의 배치를 조합으로 만들고 게임 시작 함수를 호출
        combination(0, 0);
        System.out.println(max);
    }

    private static void combination(int idx, int k) {
        if (k == sel.length) {
            for (int i = 0; i < sel.length; i++) {
                map[n - 1][sel[i]] = 2;
            }
            start();
            for (int i = 0; i < m; i++) {
                map[n - 1][i] = 0;
            }
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sel[k] = i;
            combination(idx + 1, k + 1);
        }

    }

    private static void start() {
        int cnt = 0;
        int[][] reMap = new int[n - 1][m];

        for (int i = 0; i < n - 1; i++) {		// 원본 맵 복사
            for (int j = 0; j < m; j++) {
                int t = map[i][j];
                reMap[i][j] = t;
            }
        }

        for (int t = 0; t < n - 1; t++) {
            List<Node> nodes = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                if (map[n - 1][i] == 2) {
                    Node node = bfs(reMap, n - 2, i);
                    if (null != node) {
                        nodes.add(node);
                    }
                }
            }

            for (int i = 0; i < nodes.size(); i++) {
                Node node = nodes.get(i);
                if (reMap[node.y][node.x] == 1) {
                    reMap[node.y][node.x] = 0;
                    cnt++;
                }
            }

            for (int i = n - 2; i >= 1; i--) {		// 한칸씩 내려보내기
                for (int j = 0; j < m; j++) {
                    int k = reMap[i - 1][j];
                    reMap[i][j] = k;
                }
            }

            for (int i = 0; i < m; i++) {
                reMap[0][i] = 0;
            }


        }
        if (cnt > max) {
            max = cnt;
        }

    }

    private static Node bfs(int[][] reMap, int y, int x) {

        boolean[][] v = new boolean[n - 1][m];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(y, x, 1));
        v[y][x] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.cnt > d) {
                break;
            }
            if (reMap[node.y][node.x] == 1) {
                return node;
            }

            for (int i = 0; i < 3; i++) {
                int ny = dy[i] + node.y;
                int nx = dx[i] + node.x;

                if (ny >= 0 && ny < n - 1 && nx >= 0 && nx < m && !v[ny][nx]) {
                    v[ny][nx] = true;
                    q.offer(new Node(ny, nx, node.cnt + 1));
                }
            }
        }

        return null;
    }
}
