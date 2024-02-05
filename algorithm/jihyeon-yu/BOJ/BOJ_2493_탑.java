package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// stack을 통한 풀이
public class BOJ_2493_탑{
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> heightStack = new Stack<>(); // 탑의 높이를 저장
		Stack<Integer> indexStack = new Stack<>(); // 각 탑의 순서를 저장
		
		int N = Integer.parseInt(st.nextToken()); // 탑의 개수
		int val; // 탑의 높이 값 선언
		
		st = new StringTokenizer(br.readLine(), " " );
		for (int i = 1; i <= N; i++) {
			val = Integer.parseInt(st.nextToken()); // 각 탑의 높이
			// stack에 값이 있을 때까지
			while(!heightStack.isEmpty()) {
				// 만약 val이 stack의 마지막 요소보다 작으면
				if(heightStack.peek() >= val) {
					// stack의 마지막 요소의 순서 번호 출력
					sb.append(indexStack.peek()).append(" ");
					break;
				}
				// 탑의 높이와 순서 번호를 제거
				heightStack.pop();
				indexStack.pop();
			}
			// stack이 비어있으면 0 출력
			if(heightStack.isEmpty()) {
				sb.append(0).append(" ");
			}
			// 모든 값 push
			heightStack.push(val);
			indexStack.push(i);
		}
		System.out.println(sb);
	}
}


/*
//메모리 초과를 BufferedReader로 해결하였으나 시간 초과로 실패
public class BOJ_2493_탑 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int[] tower = new int[N];
		int[] answer = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N - 1; i > 0; i--) {
			int ans = 0;
			for (int j = i-1; j >= 0; j--) {
				if (tower[i] <= tower[j]) {
					ans = j+1;
					break;
				} else {
					continue;
				}
			}
			answer[N-1-i] = ans;
		}
		answer[N-1] = 0;
		
		for (int i = N - 1; i >= 0 ; i--) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}

}
*/
