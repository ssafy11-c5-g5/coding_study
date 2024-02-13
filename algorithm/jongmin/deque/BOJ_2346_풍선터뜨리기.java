package algorithm.hw.hw240205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2346_풍선터뜨리기 {

    static class Balloon {
        int data;
        int idx;

        public Balloon(int data, int idx) {
            this.data = data;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Balloon{" +
                    "data=" + data +
                    ", idx=" + idx +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Balloon> balloons = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            balloons.add(new Balloon(line[i], i + 1));
        }

        StringBuilder sb = new StringBuilder();
        int checkVal = balloons.pollFirst().data;
        int dir = 0;

        sb.append(1).append(" ");
        while (!balloons.isEmpty()) {
            //System.out.println(checkVal);
            if (checkVal > 0) {
                for (int i = 1; i < checkVal; i++) {
                    balloons.addLast(balloons.pollFirst());
                    //System.out.println(balloons);
                }
                Balloon poll = balloons.pollFirst();

                sb.append(poll.idx).append(" ");
                checkVal = poll.data;
            } else {
                for (int i = 1; i < -checkVal; i++) {
                    balloons.addFirst(balloons.pollLast());
                    //System.out.println(balloons);
                }
                Balloon poll = balloons.pollLast();

                sb.append(poll.idx).append(" ");
                checkVal = poll.data;
            }
        }
        System.out.println(sb.toString());
    }
}
