package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_7964_부먹왕국의_차원_관문 {
    static int N;
    static int D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] cities = new int[N + 2];

            cities[0] = 1;
            cities[N+1] = 1;

            for (int i = 1; i <= N; i++) {
                cities[i] = line[i - 1];
            }

            //System.out.println(Arrays.toString(cities));

            System.out.println("#" + tc + " " + buildGateway(cities));
        }
    }
    private static int buildGateway(int[] road) {
        int lastGateway = 0;
        int cnt = 0;
        for (int i = 0; i < road.length; i++) {
            if (i >= lastGateway + D && road[i] != 1) {
                road[i] = 1;
                lastGateway = i;
                cnt++;
            } else {
                if (road[i] == 1) {
                    lastGateway = i;
                }
            }
        }
        return cnt;
    }
}

