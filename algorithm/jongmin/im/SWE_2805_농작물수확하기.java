package algorithm.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_2805_농작물수확하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int index = 0; index < T; index++) {
            int n = Integer.parseInt(br.readLine());

            int[][] graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();

                for (int j = 0; j < n; j++) {
                    int number = line.charAt(j) - '0';
                    graph[i][j] = number;
                }
            }

            System.out.println("#" + (index+1) + " " + calculate(n, graph));
        }
    }


    public static int calculate(int n, int[][] graph) {
        int result = 0;

        int mid = n / 2;
        int index = 0;
        for (int i = 0; i < mid; i++) {
            for (int j = mid - i; j <= mid + i; j++) {
                result += graph[index][j];
            }
            index++;
        }

        for (int i = mid; i >= 0; i--) {
            for (int j = mid - i; j <= mid + i; j++) {
                result += graph[index][j];
            }

            index++;
        }

        return result;
    }
}
