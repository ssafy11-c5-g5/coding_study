import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) - Math.abs(o2) == 0) {     //절댓값이 서로 같으면 작은 값 반환
                    return o1 - o2;
                }
                return Math.abs(o1) - Math.abs(o2);         // 절댓값이 작은 것 반환
            }
        });

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            if (c == 0) {
                Object t = pq.poll();               // null 인지 확인하기 위해 Object 로 값 받음
                if (t == null) {
                    System.out.println(0);
                } else {
                    System.out.println((int)t);     // null 이 아니라면 int 로 캐스팅
                }
            } else {
                pq.offer(c);
            }

        }


    }
}
