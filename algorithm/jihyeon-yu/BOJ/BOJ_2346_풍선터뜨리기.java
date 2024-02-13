package practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2346_풍선터뜨리기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new LinkedList<>();
		List<Integer> index = new LinkedList<>();
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			list.add(sc.nextInt());
			index.add(i);
		}
		int idx = 0;
		while(!list.isEmpty()) {
			while(idx < 0) {
				idx += list.size();
			}
			while(idx >= list.size()) {
				idx -= list.size();
			}
			System.out.print(index.get(idx)+1 + " ");
			int val = list.get(idx);
			list.remove(idx);
			index.remove(idx);
			idx += val;
			if(val >= 0) idx--; 
		}
	}

}
