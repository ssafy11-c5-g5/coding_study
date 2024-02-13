import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Comparator를 통한 Integer 정렬 기준 변경
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            // 각 절대값이 같다면 작은 값을 최저 힙으로
            if(Math.abs(a) == Math.abs(b)) {
                return a - b;
            }
            // 절대값이 작은 값을 최저 힙으로
            return Math.abs(a) - Math.abs(b);
        });

        int N = Integer.parseInt(br.readLine());


        for(int i = 0;i < N;i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(pq.isEmpty()) {
                    System.out.println("0");
                }
                else {
                    System.out.println(pq.poll());
                }
            }
            else {
                pq.offer(x);
            }
        }
    }
}