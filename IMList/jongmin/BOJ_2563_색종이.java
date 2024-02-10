package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {

    public static void main(String[] args) throws IOException {

        int[][] graph = new int[101][101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int i = r; i < r + 10; i++) {
                for (int j = c; j < c + 10; j++) {
                    graph[i][j] = 1;
                }
            }
        }
        int result = 0;

        for (int i = 0; i <= 100; i++) {
            result += Arrays.stream(graph[i]).sum();
        }
        System.out.println(result);
    }
}

