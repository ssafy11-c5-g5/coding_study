package algorithm.hw.hw0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값힙 implements Comparable<BOJ_11286_절댓값힙> {

    int value;

    public BOJ_11286_절댓값힙(int value) {
        this.value = value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<BOJ_11286_절댓값힙> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll().value);
                }
            } else {
                pq.offer(new BOJ_11286_절댓값힙(num));
            }
        }
    }

    @Override
    public int compareTo(BOJ_11286_절댓값힙 o) {
        int a = Math.abs(value);
        int b = Math.abs(o.value);
        if (a == b) {
            return value - o.value;
        }
        return a - b;
    }
}
