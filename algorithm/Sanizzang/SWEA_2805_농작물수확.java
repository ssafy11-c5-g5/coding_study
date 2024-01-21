package coding_study.algorithm.Sanizzang;

import java.util.Scanner;

public class SWEA_2805_농작물수확 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test = 1;test <= T;test++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            for(int i = 0;i < N;i++) {
                String str = sc.next();
                for(int j = 0;j < N;j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            int sum = 0;
            int start = N / 2;
            int end = N / 2;
            for(int i = 0;i < N;i++) {
                for(int j = start;j <= end;j++) {
                    sum += arr[i][j];
                }
                if(i < N / 2) {
                    start -= 1;
                    end += 1;
                }
                else {
                    start += 1;
                    end -= 1;
                }
            }

            System.out.println("#" + test + " " + sum);

        }
    }
}

/**
 *  풀이:
 *  이 문제의 경우 규칙이 있다.
 *  처음에 농장의 크기(N)의 1/2 에서 시작하여 N/2 위치 전 까지는
 *  열의 크기가 양쪽으로 1씩 증가하고 N/2 위치 후 부터는
 *  열의 크기가 양쪽으로 -1씩 감소한다.
 */
