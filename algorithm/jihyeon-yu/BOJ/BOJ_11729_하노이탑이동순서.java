package swea;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_11729_하노이탑이동순서 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		
		bw.write((int)(Math.pow(2, n)-1)+"\n");
		bw.flush();
		hanoi(1, 2, 3, n);
		
		bw.close();
	}
	public static void hanoi(int from, int m, int to, int num) {
		if(num == 1) {
			System.out.print(from + " " + to + "\n");
			return;
		}
		hanoi(from, to, m, num-1); // A to B
		System.out.printf("%d %d\n",from,to); // A to C
		hanoi(m,from,to,num-1); // B to C
	}

}
