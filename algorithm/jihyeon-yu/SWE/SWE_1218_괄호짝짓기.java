package homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			Stack<Character> s = new Stack<Character>();
			int n = sc.nextInt();
			char[] bracket = new char[n];
			String str = sc.next();
			
			// "{} [] <> ()" 짝이 맞으면 pop, 아니면 push
			for (int i = 0; i < n; i++) {
				char val = str.charAt(i);
				if (s.isEmpty()) {
					s.push(val);
				} else if((s.peek() == '[' && val == ']') || (s.peek() == '{' && val == '}') ||
						(s.peek() == '<' && val == '>') || (s.peek() == '(' && val == ')')) {
					s.pop();
				} else {
					s.push(val);
				}
			}
			System.out.print("#" + t + " ");
			if (s.isEmpty()) System.out.println(1);
			else System.out.println(0);
		}
	}
}
