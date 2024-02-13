package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_10799_쇠막대기 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		char[] steels = sc.next().toCharArray();
		int pipe = 1;
		int cutNum = 0;
		
		
		for (int i = 1; i < steels.length; i++) {
			if (steels[i] == '(') {
				pipe++;
			}else if(steels[i] == ')') {
				pipe--;
				if(steels[i-1] == '(') cutNum += pipe;
				else cutNum += 1;
			}
		}
		System.out.println(cutNum);
	}
}
