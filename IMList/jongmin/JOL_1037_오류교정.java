package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JOL_1037_오류교정 {

    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        int[] rowSums = new int[N];
        int[] colSums = new int[N];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                colSums[j] += graph[i][j];
                rowSums[i] += graph[i][j];
            }
        }

        List<Integer> errorRow = new ArrayList<>();
        List<Integer> errorCol = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (rowSums[i] % 2 == 1) {
                errorRow.add(i + 1);
            }
            if (colSums[i] % 2 == 1) {
                errorCol.add(i + 1);
            }
        }
        if (errorRow.size() == 0 && errorCol.size() == 0){
            System.out.println("OK");
        } else if (errorRow.size() == 1 && errorCol.size() == 1) {
            System.out.println("Change bit " + "(" + errorRow.get(0) + ","
                    + errorCol.get(0) + ")");
        } else {
            System.out.println("Corrupt");
        }
    }
}
