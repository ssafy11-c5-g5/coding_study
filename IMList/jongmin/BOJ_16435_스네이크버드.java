package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16435_스네이크버드 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line);

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        line = br.readLine();

        st = new StringTokenizer(line);

        int[] h = new int[N];
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(h);

        for (int i = 0; i < N; i++) {
            if (h[i] <= L) {
                L++;
            }
        }
        System.out.println(L);
    }
}
