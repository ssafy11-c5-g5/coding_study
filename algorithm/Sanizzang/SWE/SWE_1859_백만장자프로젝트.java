package coding_study.algorithm.Sanizzang;

import java.util.Scanner;
import java.util.Stack;

public class SWE_1859_백만장자프로젝트 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        long[] result = new long[T]; // 정답을 담을 배열

        for(int i = 0; i < T; i++)
        {
            int n = sc.nextInt();
            int[] arr = new int[n]; // 매매가
            for(int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

            Stack<Integer> s = new Stack<>();
            long sum = 0; // 이익
            long max = arr[n - 1]; // 매매가 최대값 초기화

            /**
             * 배열의 뒤부터 매매가 확인
             * 만약 현재 최대 매매가 보다 앞의 매매가가 높다면
             * 현재 최대 매매가에 원료를 팜
             */
            for(int k = n - 2; k >= 0; k--) {
                if(arr[k] > max) {
                    while(!s.empty()) {
                        sum += max - s.pop();
                    }
                    max = arr[k];
                } else {
                    s.push(arr[k]);
                }
            }

            // 남아있는 원료까지 팜
            while(!s.empty()) {
                sum += max - s.pop();
            }

            result[i] = sum;
        }


        for(int i = 0;i < T;i++) {
            System.out.println("#" + (i + 1) + " " + result[i]);
        }
    }
}
