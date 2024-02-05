package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_2164_카드2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new ArrayDeque<>();
		
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		// queue의 값이 1이 될 때까지 맨 앞 값 버리기 - 맨 앞 값 맨 뒤로 보내기 반복
		while(true) {
			if (queue.size() == 1) break;
			queue.poll();
			queue.offer(queue.peek());
			queue.poll();
		}
		sb.append(queue.peek());
		System.out.println(sb);
	}

}
