package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JOL_1828_냉장고 {

    static class Temperature implements Comparable{

        int minTemp;
        int maxTemp;

        public Temperature(int minTemp, int maxTemp) {
            this.minTemp = minTemp;
            this.maxTemp = maxTemp;
        }

        @Override
        public int compareTo(Object o) {
            if (minTemp == ((Temperature)o).minTemp) {
                return maxTemp - ((Temperature)o).maxTemp;
            }
            return minTemp - ((Temperature)o).minTemp;
        }

        @Override
        public String toString() {
            return "Temperature{" +
                    "minTemp=" + minTemp +
                    ", maxTemp=" + maxTemp +
                    '}';
        }

        public boolean isOverlap(Temperature t) {
            if (this.maxTemp < t.minTemp) {
                return false;
            }
            return true;
        }

        public Temperature narrowRange(Temperature t) {
            int max = 0;
            if (t.maxTemp < this.maxTemp) {
                max = t.maxTemp;
            } else {
                max = this.maxTemp;
            }

            return new Temperature(t.minTemp, max);
        }
    }

    static List<Temperature> temps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        temps = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int minTemp = Integer.parseInt(st.nextToken());
            int maxTemp = Integer.parseInt(st.nextToken());

            temps.add(new Temperature(minTemp, maxTemp));
        }

        Collections.sort(temps);

        Stack<Temperature> stack = new Stack<>();
        for (Temperature temp : temps) {
            if (stack.isEmpty()) {
                stack.push(temp);
            } else {
                if (stack.peek().isOverlap(temp)) {
                    Temperature tmp = stack.peek().narrowRange(temp);
                    stack.pop();
                    stack.push(tmp);
                } else {
                    stack.push(temp);
                }
            }
            //System.out.println(stack);
        }

        System.out.println(stack.size());
    }
}
