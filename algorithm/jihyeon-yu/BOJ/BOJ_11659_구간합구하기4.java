package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {
	static int[] arr;
	static int i, j, sum;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		
		st = new StringTokenizer(br.readLine());
		sum = 0;
		for (int k = 0; k < N; k++) {
			sum += Integer.parseInt(st.nextToken());
			arr[k] = sum;
		}
		
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			if (i == 1) sum = arr[j-1];
			else sum = arr[j-1] - arr[i-2];
			
			sb.append(sum);
			System.out.println(sb);
			sb.setLength(0);
		}
	}

}
