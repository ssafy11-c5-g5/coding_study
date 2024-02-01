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

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int i, j, sum;
		int[] partArray;
		
		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < N; k++) {
			arr[k] = Integer.parseInt(st.nextToken());
		}
		
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			partArray = Arrays.copyOfRange(arr, i-1, j);
			sum = 0;
			for (int l = 0; l < partArray.length; l++) {
				sum += partArray[l];
			}
			sb.append(sum);
			System.out.println(sb);
			sb.setLength(0);
			
		}
		
	}

}
