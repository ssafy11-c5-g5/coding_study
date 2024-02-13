package imlist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

// 도화지에 색종이 영역에 1을 초기화해서 1의 총 개수를 세는 방식
public class BOJ_2563_색종이 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 색종이의 수
		int[][] colorPaper = new int[101][101]; // 도화지
		
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int r = y; r < y+10; r++) {
				for (int c = x; c < x+10; c++) {
					colorPaper[r][c] = 1;
				}
			}
		}

		int totalArea = 0;
		
		for (int r = 0; r < 101; r++) {
			for (int c = 0; c < 101; c++) {
				if(colorPaper[r][c] == 1) totalArea++;
			}
		}
		
		System.out.println(totalArea);
		
	}

}
