package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SWE_1974_스도쿠검증 {

    static int[][] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            N = 9;
            graph = new int[N][N];

            for (int i = 0; i < N; i++) {
                graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int result = 1;

            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    rowSet.add(graph[i][j]);
                }
                if (rowSet.size() != 9) {
                    System.out.println("rowError");
                    result = 0;
                    break;
                }
            }

            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    colSet.add(graph[i][j]);
                }
                if (colSet.size() != 9) {
                    System.out.println("colError");
                    result = 0;
                    break;
                }
            }

            L: for (int i = 0; i < N; i += 3) {
                for (int j = 0; j < N; j += 3) {
                    Set<Integer> boxSet = new HashSet<>();
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            boxSet.add(graph[k][l]);
                        }
                    }
                    if (boxSet.size() != 9) {
                        System.out.println("boxError");
                        result = 0;
                        break L;
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
