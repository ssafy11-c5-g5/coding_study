import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Ballon {
    int num;
    int paper;

    public Ballon(int num, int paper) {
        this.num = num;
        this.paper = paper;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Ballon> dq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1;i <= N;i++) {
            dq.add(new Ballon(i, Integer.parseInt(st.nextToken())));
        }

        while(!dq.isEmpty()) {
            Ballon b = dq.removeFirst();
            System.out.print(b.num + " ");
            if(!dq.isEmpty()) {
                if(b.paper >= 0) {
                    for(int j = 0;j < b.paper - 1;j++) {
                        dq.addLast(dq.removeFirst());
                    }
                }
                else {
                    for(int j = 0;j < -(b.paper);j++) {
                        dq.addFirst(dq.removeLast());
                    }
                }
            }

        }
    }
}
