import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int[][] map;
    static boolean[][] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0;i < N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j < N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int landNum = 1;
        for(int i = 0;i < N;i++) {
            for(int j = 0;j < N;j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    map[i][j] = landNum;
                    while(!q.isEmpty()) {
                        int[] pos = q.poll();
                        for(int k = 0;k < 4;k++) {
                            int newX = pos[0] + dx[k];
                            int newY = pos[1] + dy[k];
                            if(newX >= 0 && newX < N && newY >= 0 && newY < N && map[newX][newY] == 1 && !visited[newX][newY]){
                                map[newX][newY] = landNum;
                                visited[newX][newY] = true;
                                q.offer(new int[]{newX, newY});
                            }
                        }
                    }
                    landNum++;
                }
            }
        }

        for(int i = 0;i < N;i++) {
            for(int j = 0;j < N;j++) {
                if(map[i][j] != 0) {
                    int currentLand = map[i][j];
                    visited = new boolean[N][N];
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                    L:while(!q.isEmpty()) {
                        int[] pos = q.poll();
                        for(int k = 0;k < 4;k++) {
                            int newX = pos[0] + dx[k];
                            int newY = pos[1] + dy[k];
                            if(newX >= 0 && newX < N && newY >= 0 && newY < N && map[newX][newY] != currentLand && !visited[newX][newY]) {
                                if(map[newX][newY] > 0) {
                                    result = Math.min(result, pos[2]);
                                    break L;
                                }
                                visited[newX][newY] = true;
                                q.offer(new int[]{newX, newY, pos[2] + 1});
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}