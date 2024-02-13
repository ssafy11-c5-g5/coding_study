import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> nums = new LinkedList<>();
        for(int i = 1;i <= N;i++) {
            nums.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i = 0;i < M;i++) {
            int n = Integer.parseInt(st.nextToken());

            int left = nums.indexOf(n);
            int right = 1;
            for(int j = nums.size() - 1;j >= 0;j--) {
                if(nums.get(j) == n) break;
                right += 1;
            }
            if(left <= right) {
                for(int j = 0;j < left;j++) {
                    nums.addLast(nums.removeFirst());
                }
                count += left;
            }
            else {
                for(int j = 0;j < right;j++) {
                    nums.addFirst(nums.removeLast());
                }
                count += right;
            }
            nums.removeFirst();
        }

        System.out.println(count);

    }
}