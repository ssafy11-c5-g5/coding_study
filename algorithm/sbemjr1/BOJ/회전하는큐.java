package sbemjr1.BOJ;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 회전하는큐 {
	static int N, M, ans, min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> dq = new ArrayDeque<>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			dq.add(i);
		}
		
		for (int i = 0; i < M; i++) {
			int tmp = sc.nextInt();
			int cnt_l = 0;
			int cnt_r = 0;
			// 깊은 복사 (각 요소를 새로운 객체로 복사)
	        Deque<Integer> dq_copy_l = new ArrayDeque<>();
	        for (Integer element : dq) {
	        	dq_copy_l.add(new Integer(element));
	        }
	        Deque<Integer> dq_copy_r = new ArrayDeque<>();
	        for (Integer element : dq) {
	        	dq_copy_r.add(new Integer(element));
	        }
			
			while(dq_copy_l.peek() != tmp) {
				dq_copy_l.addLast(dq_copy_l.removeFirst());
				cnt_l++;
			}
			while(dq_copy_r.peek() != tmp) {
				dq_copy_r.addFirst(dq_copy_r.removeLast());
				cnt_r++;
			}
			
			if (cnt_l > cnt_r) {
				dq = dq_copy_r;
				dq.removeFirst();
				ans += cnt_r;
			} else {
				dq = dq_copy_l;
				dq.removeFirst();
				ans += cnt_l;
			}
		}
		System.out.println(ans);
	}
}
