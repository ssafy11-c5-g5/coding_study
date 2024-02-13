package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			Queue<Integer> queue = new ArrayDeque<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			// queue에 초기값 입력
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 1;
			
			// 마지막 값이 0이 될 때까지 맨 앞 수를 cnt(1~5)만큼 빼면서 맨 뒤로 보내기
			while(true) {
				if (cnt == 6) cnt = 1;
				if(queue.peek() - cnt <= 0) {
					queue.poll();
					queue.offer(0);
					break;
				}
				queue.offer(queue.poll() - cnt);
				cnt++;
			}
			System.out.print("#" + T + " ");
			while(!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}

}
