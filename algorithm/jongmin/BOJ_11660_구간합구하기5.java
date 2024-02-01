package algorithm.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_11660_구간합구하기5 {

    static int[][] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        N+=1;
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        for (int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++){
            for(int j = 1; j < N; j++){
                graph[i][j] += (graph[i][j-1] + graph[i-1][j] - graph[i-1][j-1]);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++){
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int r1 = line[0];
            int c1 = line[1];
            int r2 = line[2];
            int c2 = line[3];

            int val = graph[r2][c2] - graph[r1-1][c2] - graph[r2][c1-1] + graph[r1-1][c1-1];
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }
}
