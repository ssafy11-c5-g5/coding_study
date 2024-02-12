package imlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16435_스네이크버드 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 과일의 개수
		int L = sc.nextInt(); // 스네이크버드의 초기 길이
		int[] fruit = new int[N];
		for (int i = 0; i < N; i++) fruit[i] = sc.nextInt();
		Arrays.sort(fruit);
		
		for (int i = 0; i < N; i++) {
				if(L < fruit[i]) break;
				L++;
		}
		
		System.out.println(L);
	}

}
