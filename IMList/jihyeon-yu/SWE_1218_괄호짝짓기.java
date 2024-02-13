package imlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			String str = sc.next();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				char bracker = str.charAt(i);
				if(stack.isEmpty()) stack.push(bracker);
				else if((stack.peek() == '(' && bracker == ')') || (stack.peek() == '<' && bracker == '>') ||
						(stack.peek() == '[' && bracker == ']') || (stack.peek() == '{' && bracker == '}')) {
					stack.pop();
				} else stack.push(bracker);
			}
			if(stack.isEmpty()) System.out.println("#" + t + " " + 1);
			else System.out.println("#" + t + " " + 0);
		}
	}

}
