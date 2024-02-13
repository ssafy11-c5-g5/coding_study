package algorithm.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {

    static int maxNumber = 0;
    static int N, M;
    static int[] cards;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        comb(0, 0, 0);
        System.out.println(maxNumber);
    }

    private static void comb(int n, int r, int sum) {
        if(r == 3 && sum <= M) {
            maxNumber = Math.max(maxNumber, sum);
            return;
        }

        if (n >= N || sum > M) {
            return;
        }

        comb(n+1, r+1, sum+cards[n]);

        comb(n+1, r, sum);
        return;
    }
}