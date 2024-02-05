import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_2346_풍선터뜨리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] ar = br.readLine().split(" ");
        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] var = new int[2];
            var[0] = Integer.parseInt(ar[i]);
            var[1] = i + 1;
            deque.add(var);
        }

        int[] k = deque.removeFirst();  // 첫 번째 풍선을 터뜨리고 k에 움직여야 할 카운트와 인덱스 저장
        int q = k[0];                   // 첫 번째 풍선의 값이 양수인지 음수인지 판별하기 위한 변수 q
        sb.append(k[1] + " ");
        if (k[0] > 0) {                 // 초기값이 음수인지 양수인지에 따라 값을 +1 혹은 -1만큼 초기 이동
            k[0]--;
        } else {
            k[0]++;
        }

        while (!deque.isEmpty()) {
            if (k[0] < 0) {                         // 삭제한 값이 음수라면 first값을 last로
                k[0]++;                             // 이동한 횟수 카운트
                int[] c = deque.removeLast();
                deque.addFirst(c);
            } else if (k[0] > 0) {                  // 삭제한 값이 양수라면 last값을 first로
                k[0]--;                             // 이동 횟수 카운트
                int[] c = deque.removeFirst();
                deque.addLast(c);
            } else {                                // 이동이 완료 되었다면
                if (q > 0) {                       // 이동했던 방향이 양수라면
                    k = deque.removeFirst();       // 첫번째 값삭제, 삭제한 값이 양수라면 첫번째 값을 삭제하고 이동해야할 카운트와 인덱스 저장
                    q = k[0];
                    sb.append(k[1] + " ");
                    if (k[0] > 0) {                 // 삭제한 값이 음수인지 양수인지에 따라 값을 +1 혹은 -1만큼 초기 이동
                        k[0]--;
                    } else {
                        k[0]++;
                    }
                } else {                        // 이동했던 방향이 음수라면
                    k = deque.removeLast();     // 마지막 값 삭제, 삭제한 값이 음수라면 마지막 값을 삭제하고 이동해야할 카운트와 인덱스 저장
                    q = k[0];
                    sb.append(k[1] + " ");
                    if (k[0] > 0) {             // 삭제한 값이 음수인지 양수인지에 따라 값을 +1 혹은 -1만큼 초기 이동
                        k[0]--;
                    } else {
                        k[0]++;
                    }
                }
            }

        }

        System.out.println(sb);

    }
}
