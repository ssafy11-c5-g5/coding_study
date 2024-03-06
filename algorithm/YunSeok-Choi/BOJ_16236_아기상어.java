package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
    static class Node {
        int y, x, time, size, food;

        public Node(int y, int x, int time, int size, int food) {
            this.y = y;
            this.x = x;
            this.time = time;
            this.size = size;
            this.food = food;
        }
    }

    static int n;
    static int[][] map;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        Node shark = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    shark = new Node(i, j, 0, 2, 0);
                }
            }
        }

        int time = bfs(shark);

        System.out.println(time);
    }

    private static int bfs(Node shark) {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] v = new boolean[n][n];

        q.offer(new Node(shark.y, shark.x, shark.time, shark.size, shark.food));
        v[shark.y][shark.x] = true;
        int time = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();

            int minY = Integer.MAX_VALUE;
            int minX = Integer.MAX_VALUE;
            int food = 0;
            int size = 0;
            for (int t = 0; t < qSize; t++) {

                Node p = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = p.y + dy[i];
                    int nx = p.x + dx[i];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < n && !v[ny][nx]) {
                        if (map[ny][nx] == p.size || map[ny][nx] == 0) {
                            v[ny][nx] = true;
                            q.offer(new Node(ny, nx, p.time + 1, p.size, p.food));
                        } else if (map[ny][nx] < p.size) {
                            if (minY > ny) {
                                minY = ny;
                                minX = nx;
                            } else if (minY == ny) {
                                if (minX > nx) {
                                    minX = nx;
                                }
                            }
                            food = p.food + 1;
                            size = p.size;
                            time = p.time + 1;
                        }
                    }
                }
            }
            if (minY != Integer.MAX_VALUE) {
                map[minY][minX] = 0;
                if (food == size) {
                    size++;
                    food = 0;
                }
                q = new ArrayDeque<>();
                q.offer(new Node(minY, minX, time, size, food));
                v = new boolean[n][n];
                v[minY][minX] = true;
            }
        }

        return time;


    }

    private static void printV(boolean[][] v) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((v[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void print(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
