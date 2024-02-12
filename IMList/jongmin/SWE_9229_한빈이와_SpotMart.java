package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_9229_한빈이와_SpotMart {

    static int N, M;
    static int[] snacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            snacks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(snacks);

            System.out.println("#" + tc + " " + pickSnacks());
        }
    }

    private static int pickSnacks() {
        int result = -1;
        for (int i = 0; i < N-1; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = snacks[i] + snacks[j];
                if (sum <= M && sum > result) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
