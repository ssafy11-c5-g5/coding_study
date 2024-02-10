package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2999_비밀_이메일 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();

        int N = message.length();

        int rSize = 0;
        int cSize = 0;

        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                rSize = i;
                cSize = N / i;
            }
        }
        char[][] graph = new char[rSize][cSize];

        int idx = 0;
        for (int j = 0; j < cSize; j++) {
            for (int i = 0; i < rSize; i++) {
                graph[i][j] = message.charAt(idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rSize; i++) {
            for (int j = 0; j < cSize; j++) {
                sb.append(graph[i][j]);
            }
        }
        System.out.println(sb.toString());
    }
}

