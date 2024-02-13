package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_1860_진기의_최고급_붕어빵 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T+1; tc++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            //N명의 손님, M초의 시간을 들이면 K개의 붕어빵이 추가됨.

            String[] times = br.readLine().split(" ");
            int[] customers = Arrays.stream(times).mapToInt(Integer::parseInt).sorted().toArray();

            int idx = 0;
            int clock = 0;
            int meal = 0;

            boolean isPossible = true;

            while (clock <= customers[N-1] && isPossible) {
                if (clock!=0 && clock%M == 0){
                    meal += K;
                }

                while (idx < N && customers[idx] == clock) {
                    if (meal <= 0) {
                        isPossible = false;
                        break;
                    }
                    meal -= 1;
                    idx++;
                }
                clock++;
            }

            if (isPossible) {
                System.out.println("#" + tc + " Possible");
            } else {
                System.out.println("#" + tc + " Impossible");
            }
        }
        br.close();
    }
}
