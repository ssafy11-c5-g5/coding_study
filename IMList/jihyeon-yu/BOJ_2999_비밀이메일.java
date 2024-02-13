package imlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2999_비밀이메일 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		String code = sc.next();
		int r = 1;
		int maxR = 0;
		int maxC = 0;
		
		while(true) {
			if(r > code.length()/r || maxR * maxC > code.length()) break;
			if(code.length() % r == 0) {
				maxR = r;
				maxC = code.length() / r;
				r++;
			} else r++;
		}
		char[] initial = code.toCharArray();
		char[][] solve = new char[maxR][maxC];
		int idx = 0;
		for (int c = 0; c < maxC; c++) {
			for (int k = 0; k < maxR; k++) {
				solve[k][c] = initial[idx++];
			}
		}
		
		for (int k = 0; k < maxR; k++) {
			for (int c = 0; c < maxC; c++) {
				System.out.print(solve[k][c]);
			}
		}
	}

}
