package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2991_사나운개 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int A = line[0];
        int B = line[1];
        int C = line[2];
        int D = line[3];

        // A+B C+D
        line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int P = line[0];
        int M = line[1];
        int N = line[2];

        int Dog1 = 0;
        int Dog2 = 0;

        int[] result = new int[3];

        for (int i = 1; i < 100; i++) {
            if ((i - 1) % (A + B) < A) {
                //System.out.println(i + "rage");
                Dog1 = 1;
            } else {
                //System.out.println(i + "calm");
                Dog1 = 0;
            }

            if ((i - 1) % (C + D) < C) {
                //System.out.println(i + "rage");
                Dog2 = 1;
            } else {
                //System.out.println(i + "calm");
                Dog2 = 0;
            }

            if (i == P) {
                result[0] = Dog1 + Dog2;
            }

            if (i == M) {
                result[1] = Dog1 + Dog2;
            }

            if (i == N) {
                result[2] = Dog1 + Dog2;
            }
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
