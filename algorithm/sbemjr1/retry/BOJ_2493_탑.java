package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
	static class top {
		int h;
		int idx;
		
		public top(int h, int idx) {
			this.h = h;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "top [h=" + h + ", idx=" + idx + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		top[] arr = new top[N];
		int[] ans = new int[N];
		Stack<top> stack = new Stack<top>();
		

		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = new top(Integer.parseInt(st.nextToken()), i+1);
		}
		
		stack.add(arr[0]);
		ans[0] = 0;
		
		for (int i = 1; i < N; i++) {
			top t = stack.peek();
			if (t.h < arr[i].h) {
				while (!stack.isEmpty() && stack.peek().h < arr[i].h) {
					stack.pop();
				}
				ans[i] = stack.isEmpty() ? 0 : stack.peek().idx;
				stack.add(arr[i]);
			} else if (t.h >= arr[i].h) {
				stack.add(arr[i]);
				ans[i] = t.idx;
			}
		}
		
		for (int i = 0; i < ans.length; i++) {
			sb.append(ans[i]+" ");
		}
		System.out.println(sb.toString());
	}

}
