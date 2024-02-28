package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JOL_1828_냉장고 {
	
	static class Temperature implements Comparable<Temperature>{
		int lowest, highest;
		public Temperature(int lowest, int highest) {
			this.lowest = lowest;
			this.highest = highest;
		}
		@Override
		public int compareTo(Temperature o) {
			return this.highest != o.highest ? this.highest - o.highest : this.lowest - o.lowest;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Temperature[] temp = new Temperature[N];
		for (int i = 0; i < N; i++) {
			temp[i] = new Temperature(sc.nextInt(), sc.nextInt());
		}
		
//		Arrays.sort(temp, (a, b) -> {
//			return a[1] - b[1];
//		});
		
		Arrays.sort(temp);
		
		List<Temperature> list = new ArrayList<>();
		list.add(temp[0]);
		int cnt = 0;
		for (int i = 1; i < N; i++) {
			if(list.get(0).highest >= temp[i].lowest) {
				list.add(temp[i]);
				if(i == N - 1) {
					cnt++;
					list.clear();
				}
			} else {
				cnt++;
				list.clear();
				list.add(temp[i]);
			}
		}
		System.out.println(list.size() + cnt);
	}
}




