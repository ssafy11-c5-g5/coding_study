package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ_2493_탑 {

    static class Tower{
        int height;
        int idx;

        public Tower() {
            super();
        }
        public Tower(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    static int N;
    static Deque<Tower> towers  = new ArrayDeque<>();
    static Deque<Tower> tempTowers  = new ArrayDeque<>();
    static int[] idxs;

    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        idxs = new int[N];

        for (int i = 0; i < N; i++) {
            towers.add(new Tower(line[i], i));
        }

        while(!towers.isEmpty()) {
            Tower lastTower = new Tower();
            if (!tempTowers.isEmpty()) {
                lastTower = tempTowers.pollFirst();
            } else {
                lastTower = towers.pollLast();
            }

            while(!towers.isEmpty()) {

                if (towers.peekLast().height > lastTower.height) {
                    idxs[lastTower.idx] = towers.peekLast().idx+1;
                    break;
                }
                addTempTower(towers.pollLast());
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(idxs[i] + " ");
        }
        System.out.println(sb.toString());
    }

    private static void addTempTower(Tower pollTower) {

        while (!tempTowers.isEmpty()) {
            if (pollTower.height > tempTowers.peekLast().height) {
                Tower popTower = tempTowers.pollLast();
                idxs[popTower.idx] = pollTower.idx+1;
            } else {
                tempTowers.addLast(pollTower);
                return;
            }
        }
        tempTowers.addLast(pollTower);
    }
}