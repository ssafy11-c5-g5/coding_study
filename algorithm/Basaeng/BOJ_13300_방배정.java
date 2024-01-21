import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_13300_방배정 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] graph = new int[2][7];
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            graph[S][Y]++;
        }

        int result = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 7; j++) {
                result += (graph[i][j])/K;
                if (graph[i][j] % K != 0) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
