package algorithm.hw.hw240205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1021_회전하는큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        int cnt = 0;

        for (Integer target : line) {
            int leftCnt = 0;
            int rightCnt = 0;
            Deque<Integer> tempDeque = new ArrayDeque<>(deque);
            while (true) {
                if (tempDeque.peekFirst().equals(target)) {
                    tempDeque.pollFirst();
                    break;
                }
                tempDeque.addFirst(tempDeque.pollLast());
                leftCnt++;
            }

            while (true) {
                if (deque.peekFirst().equals(target)) {
                    deque.pollFirst();
                    break;
                }
                deque.addLast(deque.pollFirst());
                rightCnt++;
            }
            if (leftCnt < rightCnt) {
                cnt += leftCnt;
            } else {
                cnt += rightCnt;
            }
        }
        System.out.println(cnt);
    }
}
