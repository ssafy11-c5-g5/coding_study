package sbemjr1.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class qArr {
	int idx;
	int val;
	
	public qArr(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

public class 풍선터뜨리기 {
	static int N, K, cnt, v, arr[];
	static qArr tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<qArr> dq = new ArrayDeque<>();
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			dq.add(new qArr(i, Integer.parseInt(st.nextToken())));
		}
		
		while(!dq.isEmpty()) {
			qArr b = dq.removeFirst();
			System.out.print(b.idx+" ");
			if(!dq.isEmpty()) {
				if(b.val >= 0) {
					for (int j = 0; j < b.val - 1; j++) {
						dq.add(dq.removeFirst());
					}
				}
				else {
					for (int j = 0; j < -(b.val); j++) {
						dq.addFirst(dq.removeLast());
					}
				}
			}
		}
		
	}

}