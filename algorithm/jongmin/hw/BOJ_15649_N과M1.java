package algorithm.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M1 {

    static int N;
    static int R;
    static int[] arr;
    static int[] sel;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line);
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        sel = new int[R];

        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }

        perm(0);
        System.out.println(sb.toString());
        br.close();
    }

    private static void perm(int r) {
        if (r == R) {
            for (int elem: sel) {
                sb.append(elem + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sel[r] = arr[i];
                perm(r+1);
                visited[i] = false;
            }
        }
    }
}

