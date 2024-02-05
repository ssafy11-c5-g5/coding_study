package edu.ssafy.hw.hw240201;

import java.io.*;
import java.util.*;

public class SWE_5215_햄버거다이어트 {

    static class Hamburger {
        int score;
        int cal;

        public Hamburger(int score, int cal) {
            this.score = score;
            this.cal = cal;
        }
    }

    static int N;
    static int L;
    static int maxScore;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            List<Hamburger> hamburgers = new ArrayList<>();
            maxScore = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());
                hamburgers.add(new Hamburger(score, cal));
            }

            generatePowerSet(hamburgers);
            System.out.println(maxScore);
        }
    }

    public static void generatePowerSet(List<Hamburger> hamburgers) {

        for (int i = 0; i < (1<<N); i++) {
            int totalScore = 0, totalCal = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    Hamburger current = hamburgers.get(j);
                    totalScore += current.score;
                    totalCal += current.cal;
                }
            }

            if (totalCal <= L) {
                maxScore = Math.max(maxScore, totalScore);
            }
        }
    }
}
