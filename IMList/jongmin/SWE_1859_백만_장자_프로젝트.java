package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class SWE_1859_백만_장자_프로젝트 {

    static class Max {
        int idx;
        int val;

        public Max(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Max{" +
                    "idx=" + idx +
                    ", val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            long N = Integer.parseInt(br.readLine());
            int[] costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Max max = findMax(0, costs);
            long ans = 0;
            for (int i = 0; i < N-1; i++) {
                //System.out.println(costs[i] + " " + max.val + " " + i + " " + max.idx);
                if (costs[i] < max.val && i < max.idx) {
                    //System.out.println("plus" + i);
                    ans += max.val - costs[i];
                } else {
                    max = findMax(i+1, costs);
                    //System.out.println(max);
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }

    private static Max findMax (int start, int[] costs) {
        int idx = 0;
        int data = 0;

        for (int i = start; i < costs.length; i++) {
            if (data < costs[i]) {
                idx = i;
                data = costs[i];
            }
        }
        return new Max(idx, data);
    }
}
