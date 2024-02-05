package sbemjr1.BOJ;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class qArr {
	int idx;
	int val;
	
	qArr(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

public class 풍선터뜨리기 {
	static int N, K, cnt, v, arr[];
	static qArr tmp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<qArr> q = new ArrayDeque<>();
		
		N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			q.offer(new qArr(i,sc.nextInt()));
		}
		
		tmp = q.poll();
		v = tmp.val;
		System.out.print(tmp.idx+" ");
		
		while(!q.isEmpty()) {
			tmp = q.poll();
			cnt++;
			if (cnt == v) {
				v = tmp.val;
				if (v < 1) {
					v += q.size();
				} else if (v >= q.size()) {
					v -= q.size();
				}
				System.out.print(tmp.idx + " ");
				cnt=0;
			} else {
				q.offer(tmp);
			}
		}
	}

}

//
//# 입력
//10
//1 -2 3 -4 5 -6 7 -8 9 -10
//
//# 출력
//1 2 9 3 6 5 7 8 10 4