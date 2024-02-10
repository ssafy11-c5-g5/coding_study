package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_5536_의석이의_세로로_말해요 {

    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T + 1; tc++) {
            words = new String[5];
            int maxLen = 0;
            for (int i = 0; i < 5; i++) {
                words[i] = br.readLine().trim();
                maxLen = Math.max(maxLen, words[i].length());
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < maxLen; j++) {
                for (int i = 0; i < 5; i++) {
                    if (j < words[i].length()) {
                        sb.append(words[i].charAt(j));
                    }
                }
            }
            System.out.println("#" + tc + " " + sb.toString());
        }

    }
}