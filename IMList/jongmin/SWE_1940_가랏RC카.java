package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWE_1940_가랏RC카 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            int N = Integer.parseInt(br.readLine());
            int cur = 0;
            int speed = 0;
            for (int i = 0; i < N; i++) {
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                if (line[0] == 0) {

                } else if (line[0] == 1) {
                    speed += line[1];
                } else if (line[0] == 2) {
                    speed -= line[1];
                    if (speed < 0) {
                        speed = 0;
                    }
                }
                cur += speed;
            }
            System.out.println("#" + tc + " " + cur);
        }
    }
}
