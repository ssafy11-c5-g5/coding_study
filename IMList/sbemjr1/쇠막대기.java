package sbemjr1.BOJ;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		
		String str = sc.next();
		int ans = 0;
		
		for (int i = 0; i < str.length(); i++) {
			// ( 이면 스택에 저장
			if(str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else {
				// 바로 전에 ) 나왔으면 1만 더해줌 -> 잘랐을 때 나오는 자투리..?
				if (str.charAt(i-1) == ')') {
					stack.pop();
					ans += 1;
				} else { // () -> 레이저 등장 시 스택 사이즈를 더해줌 ( '(' 개수가 막대기 개수이므로 )
					stack.pop();
					ans += stack.size();
				}
			}
		}
		
		System.out.println(ans);
	}

}
