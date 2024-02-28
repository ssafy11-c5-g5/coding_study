package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_1931_회의실배정 {
	
	static class Schedule implements Comparable<Schedule>{
		int start, end;
		public Schedule(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Schedule o) {
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Schedule[] schedule = new Schedule[N];
		for (int i = 0; i < N; i++) {
			schedule[i] = new Schedule(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(schedule);
		
		List<Schedule> list = new ArrayList<>();
		list.add(schedule[0]);
		
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if(schedule[i].start >= list.get(list.size()-1).end) {
				cnt++;
				list.add(schedule[i]);
			}
		}
		
		System.out.println(cnt);
	}

}
