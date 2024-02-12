package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class JOL_1328_빌딩 {

    static class Building {
        int height;
        int idx;

        public Building(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Building{" +
                    "height=" + height +
                    ", idx=" + idx +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        Deque<Building> stack = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] nearBuilding = new int[N];
        for (int i = 1; i < N+1; i++) {
            int newBuilding = Integer.parseInt(br.readLine().trim());
            if (stack.isEmpty()) {
                stack.offerLast(new Building(newBuilding, i));
            } else {
                //System.out.println(stack.peekLast() + " " + newBuilding);
                while (!stack.isEmpty() && stack.peekLast().height < newBuilding) {
                    Building pollBuilding = stack.pollLast();
                    nearBuilding[pollBuilding.idx-1] = i;
                }
                stack.offerLast(new Building(newBuilding, i));
            }
            //System.out.println(stack);
        }

        for (int building : nearBuilding) {
            System.out.println(building);
        }
    }
}
