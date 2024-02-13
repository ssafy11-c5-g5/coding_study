import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Class implements Comparable<Class>{
    int si;
    int ti;

    Class (int si, int ti) {
        this.si = si;
        this.ti = ti;
    }

    @Override
    public int compareTo(Class o) {
        return this.si == o.si? this.ti - o.ti : this.si - o.si;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        Class[] c = new Class[N];

        for(int i = 0;i < N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            c[i] = new Class(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(c);

        int classRoom = 0;
        for(int i = 0;i < N;i++) {
            int startTime = c[i].si;
            int endTime = c[i].ti;
            pq.offer(endTime);

            while(!pq.isEmpty() && pq.peek() <= startTime) {
                pq.poll();
            }
            classRoom = Math.max(classRoom, pq.size());
        }

        System.out.println(classRoom);

    }
}