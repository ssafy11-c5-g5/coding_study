package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16926_배열_돌리기1 {

    static int[][] graph;
    static int N, M, R;

    static int[] dr = {1 ,0, -1, 0};
    static int[] dc = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] newGraph = new int[N][M];
        int bound = 0;
        while(newGraph[bound][bound] == 0){
            int[] startPoint = findStartPoint(bound);

            // bound는 시작 지점
            newGraph = rotate(newGraph, startPoint[0], startPoint[1], (startPoint[2]+2)%4, bound);
            bound++;
        }
        System.out.println(printGraph(newGraph));
    }

    public static int[][] rotate(int[][] newGraph, int newR, int newC, int newDir, int bound) {
        int curR = bound;
        int curC = bound;
        int dir = 0;

        while (true) {
            //System.out.println("cur: " + curR + " " + curC + " " + dir + " new: " + newR + " " + newC + " " + newDir);

            curR += dr[dir];
            curC += dc[dir];

            newR += dr[newDir];
            newC += dc[newDir];

            if (curR < bound || curR >= N-bound || curC < bound || curC >= M-bound) {
                curR -= dr[dir];
                curC -= dc[dir];
                dir = (dir+1)%4;
                curR += dr[dir];
                curC += dc[dir];
            }
            if (newR < bound || newR >= N-bound || newC < bound || newC >= M-bound) {
                newR -= dr[newDir];
                newC -= dc[newDir];
                //newDir = (newDir-1 + 4)%4;
                newDir = (newDir+1)%4;
                newR += dr[newDir];
                newC += dc[newDir];
            }
            //System.out.println("insert cur: " + curR + " " + curC + " " + dir + " new: " + newR + " " + newC + " " + newDir);
            newGraph[curR][curC] = graph[newR][newC];

            if (curR == bound && curC == bound) {
                break;
            }
        }

        return newGraph;
    }

    public static int[] findStartPoint(int bound) {
        int curR = bound;
        int curC = bound;
        int dir = 1;

        for (int i = 0; i < R; i++){
            //System.out.println(curR + " " + curC + " " + dir);

            curR += dr[dir];
            curC += dc[dir];

            if (curR < bound || curR >= N-bound || curC < bound || curC >= M-bound) {
                curR -= dr[dir];
                curC -= dc[dir];
                dir = (dir-1 + 4)%4;
                i--;
            }
        }

        return new int[]{curR, curC, dir};
    }

    private static String printGraph(int[][] graph) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(graph[i][j]). append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

