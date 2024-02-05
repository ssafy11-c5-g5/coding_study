package coding_study.algorithm.Sanizzang;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class BOJ_13300_방배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Map<Integer, Integer> man = new HashMap<>();
        Map<Integer, Integer> girl = new HashMap<>();
        for(int i = 0;i < N;i++) {
            int S = sc.nextInt();
            int Y = sc.nextInt();
            if(S == 0) {
                girl.put(Y, girl.getOrDefault(Y, 0) + 1);
            }
            else {
                man.put(Y, man.getOrDefault(Y, 0) + 1);
            }
        }

        int sum = 0;
        Iterator<Integer> iter1 = man.keySet().iterator();
        Iterator<Integer> iter2 = girl.keySet().iterator();

        while(iter1.hasNext()) {
            int key = iter1.next();
            int value = man.get(key);

            if(value < K) {
                sum += 1;
            }
            else {
                sum += value / K;
                if(value % K != 0) {
                    sum += 1;
                }
            }
        }

        while(iter2.hasNext()) {
            int key = iter2.next();
            int value = girl.get(key);

            if(value < K) {
                sum += 1;
            }
            else {
                sum += value / K;
                if(value % K != 0) {
                    sum += 1;
                }
            }
        }

        System.out.println(sum);

    }
}

/**
 *  풀이:
 *  이 문제는 Map을 활용하여 먼저 여학생과 남학생의 Map 객체를 나누고
 *  학년 별로 인원 수를 나눈 뒤 필요한 방의 갯수를 합하는 방식으로 해결하였다.
 */